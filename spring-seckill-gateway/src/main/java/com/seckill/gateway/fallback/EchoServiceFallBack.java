package com.seckill.gateway.fallback;

import com.seckill.gateway.service.EchoService;
import org.springframework.stereotype.Component;

@Component
public class EchoServiceFallBack implements EchoService {
    @Override
    public String echo(String name) {
        return "echo fall back";
    }
}
