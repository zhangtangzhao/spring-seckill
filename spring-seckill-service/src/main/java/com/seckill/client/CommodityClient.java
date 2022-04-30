package com.seckill.client;

import com.seckill.service.CommodityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CommodityClient {

    @Resource
    private CommodityService commodityService;

    @GetMapping("/commodity/preheat")
    public Integer preheat(@RequestParam("id") Long id){
        return commodityService.preheat(id);
    }

    @GetMapping("/commodity/seckill")
    public Integer seckill(@RequestParam("id")Long id, @RequestParam("userId")Long userId){
        return commodityService.seckill(id, userId);
    }

}
