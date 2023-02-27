package com.news.user;


import com.common.base.constant.ApplicationConst;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 山竹
 * @version 1.0
 * @description: TODO
 * @date 2023/2/22 15:57
 */

@SpringCloudApplication
@EnableFeignClients(basePackages = ApplicationConst.FEIGN_PACKAGE_SCANNER)
@MapperScan(ApplicationConst.MAPPER_USER)
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
        System.out.println("======用户管理微服务启动成功======");
    }

}
