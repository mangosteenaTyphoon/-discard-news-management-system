package com.news.user.controller;

import com.common.base.enity.user.MenuEntity;
import com.common.base.result.R;
import com.news.user.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 山竹
 * @version 1.0
 * @description: TODO
 * @date 2023/2/22 16:10
 */

@Slf4j
@RequestMapping("menu")
@RestController
@Api(tags = {"后台管理-菜单管理"}, description = "后台管理-菜单管理")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 增加或修改菜单
     *
     * @param reqDTO
     * @return
     */
    @ApiOperation("新增或修改菜单")
    @PostMapping("saveOrUpdateMenu")
    public R saveOrUpdateMenu(@RequestBody MenuEntity reqDTO){
        log.info("/menu/saveOrUpdateMenu"+reqDTO.toString());
        boolean flag = menuService.saveOrUpdate(reqDTO);
        if(flag){
            return R.success("操作成功");
        }else{
            return R.fail("操作失敗");
        }

    }



}
