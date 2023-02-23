package com.news.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.base.dto.user.UserAddOrUpdateReqDTO;
import com.common.base.enity.user.UserEntity;



public interface UserService extends IService<UserEntity> {

    /**
     * 新增或修改用户
     *
     * @param reqDTO
     * @return
     */
    int saveOrUpdateUser(UserAddOrUpdateReqDTO reqDTO);
}
