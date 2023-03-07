package com.common.base.dto.admin.user;

import lombok.Data;

/**
 * @author 山竹
 * @version 1.0
 * @description: TODO
 * @date 2023/2/27 17:07
 */

@Data
public class UserPwdValidReqDTO {

    private String userId;

    private String pwd;
}
