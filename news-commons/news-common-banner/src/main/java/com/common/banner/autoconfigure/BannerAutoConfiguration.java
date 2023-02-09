package com.common.banner.autoconfigure;

import com.common.banner.core.BannerApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 山竹
 * @version 1.0
 * @description: TODO
 * @date 2023/2/9 9:23
 */

@Configuration
public class BannerAutoConfiguration {
    @Bean
    public BannerApplicationRunner bannerApplicationRunner() {
        return new BannerApplicationRunner();
    }
}
