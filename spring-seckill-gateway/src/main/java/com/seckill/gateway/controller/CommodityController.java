package com.seckill.gateway.controller;

import com.seckill.gateway.service.CommodityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CommodityController {

    @Resource
    private CommodityService commodityService;

    @GetMapping("/commodity/preheat")
    public Integer preheat(@RequestParam("id") Long id){
        return commodityService.preheat(id);
    }

    @GetMapping("/commodity/seckill")
    public String seckill(@RequestParam("id") Long id, @RequestParam("userId")Long userId){
        Integer seckill = commodityService.seckill(id, userId);
        if(seckill == 1){
            return "秒杀成功";
        }
        return "秒杀失败";
    }
}
