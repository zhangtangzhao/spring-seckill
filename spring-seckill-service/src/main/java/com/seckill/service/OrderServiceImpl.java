package com.seckill.service;

import com.seckill.entity.OrderEntity;
import com.seckill.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<OrderEntity> getUser(Long userId) {
        return orderMapper.getUser(userId);
    }
}
