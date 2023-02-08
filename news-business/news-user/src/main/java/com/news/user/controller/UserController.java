package com.news.user.controller;


import com.common.base.result.R;
import com.news.user.entity.User;
import com.news.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 山竹山竹
 * @since 2023-02-08
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getUser")
    public R getUser(){
        List<User> list = userService.list(null);
        return R.ok().code(20001).data("list",list);
    }

}

