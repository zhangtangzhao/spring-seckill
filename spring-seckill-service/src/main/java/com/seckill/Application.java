package com.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.Jedis;

@SpringBootApplication(scanBasePackages = "com.seckill")
// 注册到eureka
@EnableEurekaClient
@MapperScan("com.seckill.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }


    @Bean(destroyMethod = "close")
    public Jedis jedis(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        return jedis;
    }
}
