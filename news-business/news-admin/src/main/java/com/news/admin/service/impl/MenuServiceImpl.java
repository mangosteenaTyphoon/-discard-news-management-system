package com.news.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.base.dto.admin.menu.MenuStatusDTO;
import com.common.base.enity.user.MenuEntity;
import com.common.base.utils.StringUtil;
import com.news.admin.mapper.MenuMapper;
import com.news.admin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 山竹
 * @version 1.0
 * @description: TODO
 * @date 2023/2/22 16:15
 */


@Service
public class MenuServiceImpl  extends ServiceImpl<MenuMapper, MenuEntity>  implements MenuService{

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public boolean changeMenuStatus(MenuStatusDTO reqDTO) {
        if(StringUtil.isEmpty(reqDTO.getId())){
            return false;
        }
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setId(reqDTO.getId());
        menuEntity.setStatus(reqDTO.getMenuStatus());
        return 1 == menuMapper.updateById(menuEntity);
    }

    @Override
    public List<MenuEntity> getAllMenu() {
        QueryWrapper<MenuEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("status",0);
        List<MenuEntity> list = menuMapper.selectList(wrapper);
        return list;
    }
}
