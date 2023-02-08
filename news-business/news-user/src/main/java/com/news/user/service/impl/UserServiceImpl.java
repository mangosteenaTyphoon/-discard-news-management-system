package com.news.user.service.impl;

import com.news.user.entity.User;
import com.news.user.mapper.UserMapper;
import com.news.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 山竹山竹
 * @since 2023-02-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
