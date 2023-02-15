package com.news.uaa;

import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.stp.StpLogic;
import com.common.base.constant.ApplicationConst;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author 山竹
 * @version 1.0
 * @description: TODO
 * @date 2023/2/15 17:04
 */

@SpringCloudApplication
@EnableFeignClients(basePackages = ApplicationConst.FEIGN_PACKAGE_SCANNER)
@MapperScan(ApplicationConst.MAPPER_UAA)
public class UaaApplication {
    public static void main(String[] args) {
        SpringApplication.run(UaaApplication.class, args);
        System.out.println("======认证服务启动成功======");
    }

    @Bean
    public StpLogic getStpLogicJwt() {
        return new StpLogicJwtForSimple();
    }
}
