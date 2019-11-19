package com.qige.transaction.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;
import tk.mybatis.spring.annotation.MapperScan;


@EnableDiscoveryClient
@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@MapperScan("com.qige.transaction.order.mapper")
@EnableFeignClients(basePackages = {"com.qige.transaction.inventory.api","com.qige.transaction.score.api",
		"com.qige.transaction.coupon.api","com.qige.transaction.msg.api"})
@ImportResource({"classpath:applicationContext.xml"})
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
}
