package com.service.daka;

import com.service.daka.annotation.EnableMmcFeignClients;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableMmcFeignClients
@MapperScan("com.service.daka.*.mapper")
public class DakaServiceApp {
    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(DakaServiceApp.class, args);
    }
}