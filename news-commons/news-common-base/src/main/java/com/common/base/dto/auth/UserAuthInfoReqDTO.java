package com.common.base.dto.auth;

import lombok.Data;

/**
 * @description:
 * @author: 山竹
 * @time: 2021/9/20 22:23
 */
@Data
public class UserAuthInfoReqDTO {

    private Integer type;

    private String account;

    private String password;
}
