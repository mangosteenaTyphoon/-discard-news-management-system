package com.news.admin.controller;

import com.common.base.constant.admin.MenuConst;
import com.common.base.dto.admin.menu.MenuStatusDTO;
import com.common.base.dto.admin.menu.MenuUpdateDTO;
import com.common.base.enity.user.MenuEntity;
import com.common.base.result.R;
import com.common.base.result.ResultCode;
import com.common.base.utils.StringUtil;
import com.news.admin.service.MenuService;
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
      * @description
      * @param reqDTO 
      * @return  R
      * @author  山竹 
      * @date    2023/3/7 16:33
     */
    @ApiOperation("新增或修改菜单")
    @PostMapping("saveOrUpdateMenu")
    public R saveOrUpdateMenu(@RequestBody MenuEntity reqDTO){
        log.info("/menu/saveOrUpdateMenu"+reqDTO.toString());
        return menuService.saveOrUpdate(reqDTO) ? R.success("操作成功") : R.fail("操作失败");

    }

 

    /**
     * @description 改变菜单状态
     * @param reqDTO
     * @return  com.common.base.result.R
     * @author  山竹
     * @date    2023/3/7 16:36
    */
    @ApiOperation("改变菜单状态")
    @PostMapping("changeMenuStatus")
    public R forbidMenu(@RequestBody MenuStatusDTO reqDTO){
        log.info("admin/menu/forbidMenu"+reqDTO.toString());
        return menuService.changeMenuStatus(reqDTO) ? R.success("修改成功") :R.fail("修改失败");

    }
    
    /**
     * @description 查询全部菜单
     * @param
     * @return  null
     * @author  山竹 
     * @date    2023/3/7 16:33
    */
    @ApiOperation("查询全部菜单")
    @GetMapping("getAllMenu")
    public R getAll(){
        log.info("admin/menu/getAllMenu");
        return R.success(menuService.getAllMenu());
    }

    /**
     * @description 修改菜单信息
     * @param reqDTO
     * @return  R
     * @author  山竹
     * @date    2023/3/7 17:06
    */
    @ApiOperation("修改菜单信息")
    @PostMapping("updateMenuInfo")
    public R updateMenu(@RequestBody MenuUpdateDTO reqDTO){
        log.info("admin/menu/updateMenuInfo"+reqDTO.toString());
        if(StringUtil.isEmpty(reqDTO.getId())){
            return R.fail("输入错误");
        }
        return  menuService.updateById(reqDTO) ? R.success("修改成功") : R.fail("修改失败");
    }

    /**
     * @description 根据用户查询出所有
     * @param null
     * @return
     * @author  山竹
     * @date    2023/3/7 17:23
    */












}
