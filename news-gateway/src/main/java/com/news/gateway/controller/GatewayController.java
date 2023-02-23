package com.news.gateway.controller;

import com.common.base.result.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: youcong
 * @time: 2022/1/9 17:02
 */
@RestController
public class GatewayController {
    @PostMapping("/news")
    public R index() {
        return R.success();
    }
}
