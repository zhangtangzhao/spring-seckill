package com.seckill.service;

import org.springframework.stereotype.Service;

@Service("echoService")
public class EchoServiceImpl implements EchoService{

    @Override
    public String echo( String name) {
        System.out.println("server");
        return name;
    }
}
