package com.common.base.vo.uaa;

import lombok.Data;

/**
 * @author 山竹
 * @version 1.0
 * @description: TODO
 * @date 2023/2/15 16:22
 */

@Data
public class UserAuthVO {

    private String id;

    private String userName;

    private String password;

    private String email;

    private String phone;

    private String nickName;

    private Long companyId;

    private Integer sex;

    private Integer status;
}

