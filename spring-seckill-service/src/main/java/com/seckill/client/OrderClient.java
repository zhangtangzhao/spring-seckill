package com.seckill.client;

import com.alibaba.fastjson.JSON;
import com.seckill.entity.OrderEntity;
import com.seckill.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderClient {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/user")
    public String getUser(@RequestParam("userId")Long userId){
        List<OrderEntity> users = orderService.getUser(userId);
        if(users == null){
            users = new ArrayList<>();
        }
        return JSON.toJSONString(users);
    }

}
