package com.seckill.gateway.fallback;

import com.seckill.gateway.service.CommodityService;
import org.springframework.stereotype.Component;

@Component
public class CommodityFallBack implements CommodityService {
    @Override
    public Integer preheat(Long id) {
        System.out.println("CommodityFallBack ...preheat...");
        return 0;
    }

    @Override
    public Integer seckill(Long id, Long userId) {
        System.out.println("CommodityFallBack....seckill...");
        return 0;
    }
}
