package com.seckill.gateway.controller;

import com.seckill.gateway.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/user/name")
    public String getName(@RequestParam("id") Long id){
        return userService.getName(id);
    }

}
