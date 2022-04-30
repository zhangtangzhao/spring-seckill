package com.seckill.service;

public interface CommodityService {

    Integer preheat(Long id);

    Integer updateStock(Long id);

    Integer seckill(Long id,Long userId);

}
