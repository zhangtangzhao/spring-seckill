package com.seckill.gateway;

import com.seckill.gateway.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EchoController {

    @Autowired
    EchoService echoService;


    @GetMapping("/echo")
    public String echo(@RequestParam("name") String name){
        return echoService.echo(name);
    }

}
