package com.news.uaa.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.common.base.constant.AuthConst;
import com.common.base.dto.auth.UserAuthInfoReqDTO;
import com.common.base.dto.auth.UserIdReqDTO;
import com.common.base.utils.JbcryptUtil;
import com.common.base.vo.uaa.UserAuthVO;
import com.news.uaa.mapper.UaaMapper;
import com.news.uaa.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.http.util.TextUtils;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private UaaMapper uaaMapper;

    @Override
    public Map<String, Object> loginHandle(UserAuthInfoReqDTO reqDTO) {
        Map<String, Object> returnMap = new HashMap<>();
        Integer type = reqDTO.getType();
        String account = reqDTO.getAccount();
        String password = reqDTO.getPassword();
        UserAuthVO userAuthVo = uaaMapper.selectUserAuthInfo(type, account);

        if (userAuthVo != null && !StrUtil.isEmptyIfStr(userAuthVo.getId())) {
            if (!JbcryptUtil.checkPwd(password, userAuthVo.getPassword())) {
                returnMap.put(AuthConst.FLAG, AuthConst.FLAG_ONE_VAL);
            } else {
                returnMap.put(AuthConst.ID, userAuthVo.getId());
                returnMap.put(AuthConst.USER, userAuthVo);
                returnMap.put(AuthConst.FLAG, AuthConst.FLAG_TWO_VAL);
                returnMap.put("token", StpUtil.getTokenValue());
                System.out.println("token:" + StpUtil.getTokenValue());
            }
        } else {
            returnMap.put(AuthConst.FLAG, AuthConst.FLAG_ZERO_VAL);
        }
        return returnMap;
    }

    @Override
    public List<String> queryUserIdByRole(UserIdReqDTO reqDTO) {
        return uaaMapper.selectUserIdByRole(reqDTO.getUserId());
    }

    @Override
    public List<String> queryUserIdByPerm(UserIdReqDTO reqDTO) {
        return uaaMapper.selectUserIdByPerm(reqDTO.getUserId());
    }

    public static boolean isMobileNO(String mobiles) {
        String telRegex = "[1][3578]\\d{9}";
        // "[1]"?????????1????????????1???"[3578]"????????????????????????3???5???8???????????????"\\d{9}"????????????????????????0???9???????????????9??????
        if (TextUtils.isEmpty(mobiles)) {
            return false;
        } else {
            return mobiles.matches(telRegex);
        }
    }


}
