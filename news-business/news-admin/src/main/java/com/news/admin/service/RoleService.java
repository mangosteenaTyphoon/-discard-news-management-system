package com.news.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.base.dto.admin.role.RoleStatusDTO;
import com.common.base.enity.user.RoleEntity;

public interface RoleService extends IService<RoleEntity> {

    boolean saveOrUpdateRole(RoleEntity reqDTO);

    boolean changeRoleStatus(RoleStatusDTO reqDTO);
}
