package com.seckill.mapper;

import com.seckill.entity.OrderEntity;

import java.util.List;

public interface OrderMapper {

    int insert(OrderEntity orderEntity);

    List<OrderEntity> getUser(Long userId);

}
