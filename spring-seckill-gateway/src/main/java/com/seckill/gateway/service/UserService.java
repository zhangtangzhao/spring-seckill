package com.seckill.gateway.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SPRING-SECKILL-SERVICE")
public interface UserService {

    @GetMapping("/user/name")
    String getName(@RequestParam("id") Long id);

}
