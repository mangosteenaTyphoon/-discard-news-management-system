package com.news.admin.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.base.constant.admin.UserConst;
import com.common.base.dto.admin.user.UserAddOrUpdateReqDTO;
import com.common.base.dto.admin.user.UserIdDTO;
import com.common.base.dto.admin.user.UserPageReqDTO;
import com.common.base.dto.admin.user.UserPwdValidReqDTO;
import com.common.base.enity.user.UserEntity;
import com.common.base.utils.JbcryptUtil;
import com.news.admin.mapper.UserMapper;
import com.news.admin.service.UserService;
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

    @Override
    public int changeUserStatus(UserIdDTO userIdDTO, int userStatusDel) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userIdDTO.getUserId());
        userEntity.setStatus(userStatusDel);
        return userMapper.updateById(userEntity);
    }

    @Override
    public UserEntity selectUserOne(UserIdDTO reqDTO) {
        UserEntity userEntity = userMapper.selectById(reqDTO.getUserId());
        userEntity.setPassword(null);
        return userEntity;
    }

    @Override
    public int changePwd(UserPwdValidReqDTO reqDTO) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(reqDTO.getUserId());
            userEntity.setPassword(JbcryptUtil.bcryptPwd(reqDTO.getPwd()));
            return userMapper.updateById(userEntity);
    }

    @Override
    public IPage<UserEntity> queryUserPageList(UserPageReqDTO reqDTO) {
        Page<UserEntity> page = new Page<>(reqDTO.getPageNum(), reqDTO.getPageSize());
        return userMapper.selectUserPageList(page, reqDTO);
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
