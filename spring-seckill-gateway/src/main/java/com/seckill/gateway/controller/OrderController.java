package com.seckill.gateway.controller;

import com.seckill.gateway.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/user")
    public String getUser(@RequestParam("userId")Long userId){
        return orderService.getUser(userId);
    }

}
