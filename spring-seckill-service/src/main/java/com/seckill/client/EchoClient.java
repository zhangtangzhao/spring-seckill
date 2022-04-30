package com.seckill.client;

import com.seckill.service.EchoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EchoClient implements EchoService {

    @Resource
    EchoService echoService;

    @GetMapping("/echo")
    @Override
    public String echo(@RequestParam("name") String name) {
        return echoService.echo(name);
    }
}
