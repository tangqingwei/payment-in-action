package com.qige.transaction.msg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;
/**
 * @author 阿甘
 * @see https://study.163.com/course/courseMain.htm?courseId=1209367806&share=2&shareId=1016671292
 * @version 1.0
 * 注：如有任何疑问欢迎加入QQ群977438372 进行讨论
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.qige.transaction.msg.mapper")
public class MsgApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsgApplication.class, args);
	}
}
