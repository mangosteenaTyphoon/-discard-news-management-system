package com.news.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 山竹
 * @version 1.0
 * @description: TODO
 * @date 2023/2/8 13:36
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.news.user.mapper")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
