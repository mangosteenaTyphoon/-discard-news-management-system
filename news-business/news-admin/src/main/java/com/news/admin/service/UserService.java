package com.news.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.common.base.dto.admin.user.UserAddOrUpdateReqDTO;
import com.common.base.dto.admin.user.UserIdDTO;
import com.common.base.dto.admin.user.UserPageReqDTO;
import com.common.base.dto.admin.user.UserPwdValidReqDTO;
import com.common.base.enity.user.UserEntity;



public interface UserService extends IService<UserEntity> {


    int saveOrUpdateUser(UserAddOrUpdateReqDTO reqDTO);

    int changeUserStatus(UserIdDTO id, int userStatusDel);


    UserEntity selectUserOne(UserIdDTO reqDTO);

    int changePwd(UserPwdValidReqDTO reqDTO);

    IPage<UserEntity> queryUserPageList(UserPageReqDTO reqDTO);
}
