package com.news.uaa.mapper;

import com.common.base.vo.uaa.UserAuthVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 山竹
 * @version 1.0
 * @description: TODO
 * @date 2023/2/15 16:24
 */

@Repository
public interface UaaMapper {

    /**
     * 根据不同账户及其账户类型获取对应的用户信息
     *
     * @param type
     * @param account
     * @return
     */
    UserAuthVO selectUserAuthInfo(@Param("type") Integer type, @Param("account") String account);

    /**
     * 根据用户ID获取对应的角色key列表
     *
     * @param userId
     * @return
     */
    List<String> selectUserIdByRole(@Param("userId") String userId);


    /**
     * 根据用户ID获取对应的角色所属菜单URL
     *
     * @param userId
     * @return
     */
    List<String> selectUserIdByPerm(@Param("userId") String userId);
}
