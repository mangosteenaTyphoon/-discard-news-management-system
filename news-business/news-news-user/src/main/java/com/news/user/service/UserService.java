package com.news.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.common.base.dto.user.UserAddOrUpdateReqDTO;
import com.common.base.dto.user.UserIdDTO;
import com.common.base.dto.user.UserPageReqDTO;
import com.common.base.dto.user.UserPwdValidReqDTO;
import com.common.base.enity.user.UserEntity;



public interface UserService extends IService<UserEntity> {


    int saveOrUpdateUser(UserAddOrUpdateReqDTO reqDTO);

    int changeUserStatus(UserIdDTO id, int userStatusDel);


    UserEntity selectUserOne(UserIdDTO reqDTO);

    int changePwd(UserPwdValidReqDTO reqDTO);

    IPage<UserEntity> queryUserPageList(UserPageReqDTO reqDTO);
}
