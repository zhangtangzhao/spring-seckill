package com.seckill.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;

public class RedisUtil {

    public static void   setCache(Jedis jedis,String key, String value, int seconds){
        jedis.setex(key,seconds,value);
    }

    public static String getCache(Jedis jedis, String key){
        return jedis.get(key);
    }

    public static boolean tryLock(Jedis jedis,String key,String value,int  seconds){
        SetParams setParams=new SetParams();
        setParams.nx();
        setParams.px(seconds);
        return "OK".equals(jedis.set(key, value, setParams));
    }

    public static boolean releaseLock(Jedis jedis, String key, String value){
        String luaScript = "if redis.call('get',KEYS[1]) == ARGV[1] then " +
                "return redis.call('del',KEYS[1]) else return 0 end";
        return jedis.eval(luaScript, Collections.singletonList(key), Collections.singletonList(value)).equals(1L);
    }


}
