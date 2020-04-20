package com.service.thirdparty;

import com.service.thirdparty.annotation.EnableMmcFeignClients;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName ThirdPartyApplication
 * @Description TODO
 * @Author mamingcong
 * @Date 2020/4/16 9:39
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableMmcFeignClients
@MapperScan("com.service.thirdparty.*.mapper")
public class ThirdPartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThirdPartyApplication.class, args);
    }

}
