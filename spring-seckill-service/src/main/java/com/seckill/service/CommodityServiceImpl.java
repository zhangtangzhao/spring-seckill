package com.seckill.service;

import com.seckill.entity.OrderEntity;
import com.seckill.mapper.CommodityMapper;
import com.seckill.mapper.OrderMapper;
import com.seckill.util.RedisUtil;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CommodityServiceImpl implements CommodityService{

    @Resource
    private CommodityMapper commodityMapper;

    @Resource
    private Jedis jedis;

    @Resource
    private OrderMapper orderMapper;

    private static String stockLua;

    static{
        /**
         *  -1 表示不限库存
         *  0 表示没有库存
         *  -2 表示库存不足
         *  -3 表示库存未初始化
         */
        StringBuilder sb = new StringBuilder();
        sb.append("if (redis.call('exists',KEYS[1]) == 1) then");
        sb.append("    local stock = tonumber(redis.call('get',KEYS[1]));");
        sb.append("    local num = tonumber(ARGV[1]);");
        sb.append("    if (stock == -1) then");
        sb.append("          return -1;");
        sb.append("    end;");
        sb.append("     if(stock >= num) then");
        sb.append("         return redis.call('incrby',KEYS[1],0-num);");
        sb.append("      end;");
        sb.append("      return -2;");
        sb.append("end;");
        sb.append("return -3;");
        stockLua = sb.toString();
    }

    /**
     * 商品库存预热
     * @param id
     * @return
     */
    @Override
    public Integer preheat(Long id) {
        Integer stock = commodityMapper.selectStockById(id);
        RedisUtil.setCache(jedis,"commodity_"+id,String.valueOf(stock),180);
        return stock;
    }

    @Override
    public Integer updateStock(Long id) {
        return commodityMapper.updateStock(id);
    }

    @Override
    public Integer seckill(Long id,Long userId) {
        String key = "commodity_"+id;
        Long stock = stock(key, 1);
        if(stock == -3){
            //未初始化
            String lock = "lock";
            String uuid = UUID.randomUUID().toString();
            if(RedisUtil.tryLock(jedis,lock,uuid,60)){
                String cache = RedisUtil.getCache(jedis, key);
                if(cache== null || cache.isEmpty()){
                    preheat(id);
                }
                RedisUtil.releaseLock(jedis,lock,uuid);
            }
        }

        boolean flag = stock >= 0;
        if(flag){
            // 表示秒杀成功  库存量大时可以考虑mq
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setcId(id);
            orderEntity.setuId(userId);
            orderEntity.setCreateTime(new Date());
            orderMapper.insert(orderEntity);
            return 1;
        }

        return 0;
    }

    private Long stock(String key, int num){
        List<String> keys = new ArrayList<>();
        keys.add(key);

        List<String> args = new ArrayList<>();
        args.add(Integer.toString(num));

        return (Long)(jedis.eval(stockLua,keys,args));
    }
}
