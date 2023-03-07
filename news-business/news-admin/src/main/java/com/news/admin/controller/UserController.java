package com.news.admin.controller;

import cn.hutool.core.util.StrUtil;
import com.common.base.constant.admin.UserConst;
import com.common.base.dto.admin.user.UserAddOrUpdateReqDTO;
import com.common.base.dto.admin.user.UserIdDTO;
import com.common.base.dto.admin.user.UserPageReqDTO;
import com.common.base.dto.admin.user.UserPwdValidReqDTO;
import com.common.base.enity.user.UserEntity;
import com.common.base.result.R;
import com.common.base.utils.JbcryptUtil;
import com.news.admin.service.UserService;
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
    
    /** 
     * @description: 根据用户id删除用户 
     * @param: reqDTO
     * @return:  
     * @author 山竹
     * @date:  14:41
     */
    @DeleteMapping("/deleteUser")
    @ApiOperation("根据id删除用户")
    public R deleteUser (@RequestBody UserIdDTO reqDTO){
        log.info("/deleteUser"+reqDTO);
        return R.success(userService.changeUserStatus(reqDTO, UserConst.USER_STATUS_DEL));
    }


    /**
     * 禁用用户
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/forbidUser")
    @ApiOperation("禁用用户")
    public R forbid(@RequestBody UserIdDTO reqDTO) {
        log.info("/user/forbid"+reqDTO);
        return R.success(userService.changeUserStatus(reqDTO, UserConst.USER_STATUS_FORBID));
    }

    /**
     * 获取用户信息
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/getById")
    @ApiOperation("获取用户信息")
    public R getById(@RequestBody UserIdDTO reqDTO) {
        log.info("/user/getById"+reqDTO);
        return R.success(userService.selectUserOne(reqDTO));
    }


    /**
     * 验证旧密码是否正确
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/oldPwdValidate")
    @ApiOperation("验证旧密码是否正确")
    public R oldPwdValidate(@RequestBody UserPwdValidReqDTO reqDTO) {
        log.info("/user/oldPwdValidate");
        UserEntity userEntity = userService.getById(reqDTO.getUserId());
        if (!StrUtil.isEmpty(userEntity.getId())) {
            if (JbcryptUtil.checkPwd(reqDTO.getPwd(), userEntity.getPassword())) {
                return R.success(true);
            } else {
                return R.success(false);
            }
        }
        return R.success(false);
    }

    /**
     * 修改密码
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/changePwd")
    @ApiOperation("修改密码")
    public R changePwd(@RequestBody UserPwdValidReqDTO reqDTO) {
        return R.success(userService.changePwd(reqDTO));
    }

    /**
     * 获取用户列表
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/queryPageList")
    @ApiOperation("获取用户列表")
    public R queryPageList(@RequestBody UserPageReqDTO reqDTO) {
        log.info("/user/queryPageList:" + reqDTO);
        return R.success(userService.queryUserPageList(reqDTO));
    }
    












}
