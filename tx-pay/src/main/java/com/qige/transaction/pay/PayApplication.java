package com.qige.transaction.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.qige.transaction.pay.mapper")
@EnableFeignClients(basePackages = {"com.qige.transaction.order.api","com.qige.transaction.msg.api"})
public class PayApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.qige.transaction.pay.PayApplication.class,args);
    }
}
