package com.common.swagger.config;

/**
 * @author 山竹
 * @version 1.0
 * @description: TODO
 * @date 2023/2/8 9:36
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        ApiSelectorBuilder builder = new Docket(DocumentationType.SWAGGER_2)
                .enableUrlTemplating(false)
                .apiInfo(apiInfo())
                // 选择那些路径和api会生成document
                .select()
                // 对所有api进行监控
                .apis(RequestHandlerSelectors.any())
                //这里可以自定义过滤
                .paths(this::filterPath);

        return builder.build();
    }

    private boolean filterPath(String path) {
        boolean ret = path.endsWith("/error");
        if (ret) {
            return false;
        }
        //这块可以写其他的过滤逻辑
        return true;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("title")
                .description("description")
                .termsOfServiceUrl("https://www.baidu.com")
                .version("1.0")
                .contact(new Contact("nitric oxide", "www.baidu.com", "123@qq.com"))
                .build();
    }
}
