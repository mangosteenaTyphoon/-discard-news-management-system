package com.news.admin.controller;

import com.common.base.enity.user.RoleEntity;
import com.common.base.result.R;
import com.news.admin.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 山竹
 * @version 1.0
 * @description: TODO
 * @date 2023/2/22 16:10
 */

@Slf4j
@RestController
@RequestMapping("role")
@Api(tags = "角色管理")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /*
    * saveOrUpdate
    * @param reqDTO
    * @return com.common.base.result.R
    * @author: Admin
    * @date:  23:23
    */
    @ApiOperation("新增角色")
    @PostMapping("saveOrUpdateRole")
    public R saveOrUpdate(@RequestBody RoleEntity reqDTO){
        log.info("admin/role/saveOrUpdateRole"+reqDTO);

        return roleService.saveOrUpdateRole(reqDTO) ? R.success("操作成功~") : R.fail("操作失败~");
    }




}
