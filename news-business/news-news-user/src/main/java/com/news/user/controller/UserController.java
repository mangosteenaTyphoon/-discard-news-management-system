package com.news.user.controller;

import com.common.base.dto.user.UserAddOrUpdateReqDTO;
import com.common.base.result.R;
import com.news.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 山竹
 * @version 1.0
 * @description: TODO
 * @date 2023/2/22 16:10
 */


@Slf4j
@Api(tags = {"后台管理-用户管理"}, description = "后台管理-用户管理")
@RequestMapping("user")
@RestController

public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @Description //新增或者修改用户
     * 
     * @Param reqDTO
     * @return R
     * @Date 2023/2/22 16:10
     * @Author 山竹
     **/
    @PostMapping("/saveOrUpdate")
    @ApiOperation("新增或修改用户")
    public R saveOrUpdate (@RequestBody UserAddOrUpdateReqDTO reqDTO){
        log.info("/user/saveOrUpdate:"+reqDTO);
        return R.success(userService.saveOrUpdateUser(reqDTO));
    }
    
    /** 
     * @description: 查询全部用户
     * @param: null 
     * @return:  
     * @author 山竹
     * @date:  11:46
     */
    @GetMapping("/getAllUser")
    @ApiOperation("查询全部用户")
    public R getAllUser(){
        log.info("/getAllUser");
        return R.success(userService.list(null));
    }








}
