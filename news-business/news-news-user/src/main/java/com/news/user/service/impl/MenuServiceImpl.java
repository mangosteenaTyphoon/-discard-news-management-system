package com.news.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.base.enity.user.MenuEntity;
import com.common.base.enity.user.UserEntity;
import com.news.user.mapper.MenuMapper;
import com.news.user.mapper.UserMapper;
import com.news.user.service.MenuService;
import org.springframework.stereotype.Service;

/**
 * @author 山竹
 * @version 1.0
 * @description: TODO
 * @date 2023/2/22 16:15
 */


@Service
public class MenuServiceImpl  extends ServiceImpl<MenuMapper, MenuEntity>  implements MenuService{
}
