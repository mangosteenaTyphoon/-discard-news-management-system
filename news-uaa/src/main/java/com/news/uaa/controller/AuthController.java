package com.news.uaa.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;

import com.common.base.constant.ApplicationConst;
import com.common.base.constant.AuthConst;
import com.common.base.dto.auth.LogoutReqDTO;
import com.common.base.dto.auth.UserAuthInfoReqDTO;
import com.common.base.dto.auth.UserIdReqDTO;
import com.common.base.result.R;
import com.common.base.result.ResultCode;
import com.common.log.annotation.Log;
import com.news.uaa.service.UserAuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@Slf4j
@Api(tags = {"认证管理"}, description = "认证管理")
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private UserAuthService userAuthService;

    /**
     * 用户进行登录
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("登录")
    @Log("登录")
    public R login(@RequestBody UserAuthInfoReqDTO reqDTO) {
        if (StrUtil.isEmpty(reqDTO.getAccount()) || StrUtil.isEmpty(reqDTO.getPassword()) || reqDTO.getType() == null) {
            return R.fail(ResultCode.ILLEGAL_PARAMETER_ERROR.getCode(), ResultCode.ILLEGAL_PARAMETER_ERROR.getMsg());
        }
        Map<String, Object> resultMap = userAuthService.loginHandle(reqDTO);
        String flag = resultMap.get(AuthConst.FLAG).toString();
        if (AuthConst.FLAG_ZERO_VAL.equals(flag)) {
            return R.fail(ResultCode.USER_NO_EXIST_ERROR.getCode(), ResultCode.USER_NO_EXIST_ERROR.getMsg());
        }
        if (AuthConst.FLAG_ONE_VAL.equals(flag)) {
            return R.fail(ResultCode.USER_OR_PASSWD_ERROR.getCode(), ResultCode.USER_OR_PASSWD_ERROR.getMsg());
        }
        if (AuthConst.FLAG_TWO_VAL.equals(flag)) {
            String ID = reqDTO.getType() + ApplicationConst.DEFAULT_FLAG + resultMap.get(AuthConst.ID).toString();
            StpUtil.login(ID);
            return R.success(resultMap);
        }
        return R.success("登录成功");
    }


    /**
     * 登录状态
     *
     * @return
     */
    @PostMapping("/isLogin")
    @ApiOperation("登录状态")
    @Log("登录状态")
    @SaCheckLogin
    public R isLogin() {
        return R.success(StpUtil.isLogin());
    }

    /**
     * 获取Token信息
     *
     * @return
     */
    @PostMapping("/getTokenInfo")
    @ApiOperation("获取Token信息")
    @Log("获取Token信息")
    @SaCheckLogin
    public R getTokenInfo() {
        return R.success(StpUtil.getTokenInfo());
    }

    /**
     * 退出
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/logout")
    @ApiOperation("退出")
    @Log("退出")
    @SaCheckLogin
    public R logout(@RequestBody LogoutReqDTO reqDTO) {
        StpUtil.logout(reqDTO.getUserId());
        return R.success("注销成功");
    }

    /**
     * 获取用户对应的角色
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/getRole")
    @ApiOperation("获取用户对应的角色")
    public R<List<String>> getRole(@RequestBody UserIdReqDTO reqDTO) {
        return R.success(userAuthService.queryUserIdByRole(reqDTO));
    }

    /**
     * 获取用户对应的角色菜单URL
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/getPerm")
    @ApiOperation("获取用户对应的角色菜单URL")
    public R<List<String>> getPerm(@RequestBody UserIdReqDTO reqDTO) {
        return R.success(userAuthService.queryUserIdByPerm(reqDTO));
    }


    /**
     * @description  给用户添加角色
     * @param null
     * @return
     * @author  山竹
     * @date    2023/3/9 10:03
    */



    /**
     * @description 给角色添加相关的菜单
     * @param null
     * @return
     * @author  山竹
     * @date    2023/3/9 10:05
    */



    /**
     * @description 获取用户的菜单权限
     * @param null
     * @return
     * @author  山竹
     * @date    2023/3/9 10:05
    */
}
