package com.seckill.client;

import com.seckill.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserClient implements UserService {

    @Resource
    private UserService userService;

    @GetMapping("/user/name")
    @Override
    public String getName(@RequestParam("id") Long id) {
        return userService.getName(id);
    }
}
