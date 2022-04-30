package com.seckill.service;

import com.seckill.entity.OrderEntity;

import java.util.List;

public interface OrderService {

    List<OrderEntity> getUser(Long userId);

}
