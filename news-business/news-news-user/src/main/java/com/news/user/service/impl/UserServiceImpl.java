package com.news.user.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.base.constant.UserConst;
import com.common.base.dto.user.UserAddOrUpdateReqDTO;
import com.common.base.enity.user.UserEntity;
import com.common.base.utils.JbcryptUtil;
import com.news.user.mapper.UserMapper;
import com.news.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 山竹
 * @version 1.0
 * @description: TODO
 * @date 2023/2/22 16:15
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity>  implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveOrUpdateUser(UserAddOrUpdateReqDTO reqDTO) {
        return handleUserAddOrUpdate(reqDTO);
    }





    private int handleUserAddOrUpdate(UserAddOrUpdateReqDTO reqDTO) {
        UserEntity userEntity = new UserEntity();
        if (StrUtil.isEmpty(reqDTO.getUserId())) {
            userEntity.setId(IdUtil.simpleUUID());
            userEntity.setUserName(reqDTO.getUserName());
            userEntity.setNickName(reqDTO.getNickName());
            userEntity.setPassword(JbcryptUtil.bcryptPwd(reqDTO.getPassword()));
            userEntity.setEmail(reqDTO.getEmail());
            userEntity.setPhone(reqDTO.getPhone());
            userEntity.setSex(reqDTO.getSex());
            userEntity.setStatus(UserConst.USER_STATUS_NORMAL);
            userEntity.setCreateTime(DateUtil.date());
            userEntity.setUpdateTime(DateUtil.date());
            return userMapper.insert(userEntity);
        } else {
            userEntity.setId(reqDTO.getUserId());
            userEntity.setUserName(reqDTO.getUserName());
            userEntity.setNickName(reqDTO.getNickName());
            userEntity.setEmail(reqDTO.getEmail());
            userEntity.setPhone(reqDTO.getPhone());
            userEntity.setSex(reqDTO.getSex());
            userEntity.setStatus(UserConst.USER_STATUS_NORMAL);
            userEntity.setUpdateTime(DateUtil.date());
            return userMapper.updateById(userEntity);
        }
    }

}
