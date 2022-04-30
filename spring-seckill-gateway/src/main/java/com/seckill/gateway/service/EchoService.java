package com.seckill.gateway.service;

import com.seckill.gateway.fallback.EchoServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SPRING-SECKILL-SERVICE",fallback = EchoServiceFallBack.class)
public interface EchoService {

    @RequestMapping(value = "/echo",method = RequestMethod.GET)
    String echo(@RequestParam("name") String name);

}
