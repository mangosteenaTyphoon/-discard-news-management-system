package com.common.base.dto.user;

import lombok.Data;

/**
 * @author 山竹
 * @version 1.0
 * @description: TODO
 * @date 2023/2/22 16:39
 */

@Data
public class UserAddOrUpdateReqDTO {

    private String userId;

    private String userName;

    private String password;

    private String email;

    private String phone;

    private String nickName;

    private Integer sex;
}
