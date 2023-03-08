package com.news.admin.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.base.constant.admin.UserConst;
import com.common.base.dto.admin.role.RoleStatusDTO;
import com.common.base.enity.user.RoleEntity;
import com.common.base.utils.StringUtil;
import com.news.admin.mapper.RoleMapper;
import com.news.admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 山竹
 * @version 1.0
 * @description: TODO
 * @date 2023/2/22 16:15
 */

@Service
public class RoleServiceImpl  extends ServiceImpl<RoleMapper,RoleEntity> implements RoleService  {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public boolean saveOrUpdateRole(RoleEntity reqDTO) {
        if(StringUtil.isEmpty(reqDTO.getId())){
            reqDTO.setId(IdUtil.simpleUUID());
            reqDTO.setStatus(UserConst.ROLE_STATUS_ENABLE);
            return 1==roleMapper.insert(reqDTO);
        }else{
            String roleName = reqDTO.getRoleName();
            QueryWrapper<RoleEntity> wrapper = new QueryWrapper<>();
            wrapper.eq("role_name",roleName);
            RoleEntity roleEntity = roleMapper.selectOne(wrapper);
            reqDTO.setId(IdUtil.simpleUUID());
            reqDTO.setStatus(UserConst.ROLE_STATUS_ENABLE);
            return StringUtil.isEmpty(roleEntity.getId()) && 1 == roleMapper.updateById(reqDTO);
        }

    }

    @Override
    public boolean changeRoleStatus(RoleStatusDTO reqDTO) {
        if(StringUtil.isEmpty(reqDTO.getId())){
            return false;
        }
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(reqDTO.getId());
        roleEntity.setStatus(reqDTO.getRoleStatus());
        return 1==roleMapper.updateById(roleEntity) ;
    }
}
