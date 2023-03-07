package com.news.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.base.dto.admin.menu.MenuStatusDTO;
import com.common.base.enity.user.MenuEntity;

import java.util.List;

public interface MenuService extends IService<MenuEntity> {

    boolean changeMenuStatus(MenuStatusDTO reqDTO);

    List<MenuEntity> getAllMenu();
}
