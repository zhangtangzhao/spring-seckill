package com.seckill.gateway.service;

import com.seckill.gateway.fallback.CommodityFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SPRING-SECKILL-SERVICE",fallback = CommodityFallBack.class)
public interface CommodityService {

    @GetMapping("/commodity/preheat")
    Integer preheat(@RequestParam("id") Long id);

    @GetMapping("/commodity/seckill")
    public Integer seckill(@RequestParam("id")Long id, @RequestParam("userId")Long userId);

}
