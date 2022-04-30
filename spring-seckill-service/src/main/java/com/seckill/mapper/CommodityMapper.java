package com.seckill.mapper;

public interface CommodityMapper {

    Integer selectStockById(Long id);

    Integer updateStock(Long id);

}
