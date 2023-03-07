package com.common.base.dto.admin.user;

import com.common.base.dto.base.PageParam;
import lombok.Data;

/**
 * @author 山竹
 * @version 1.0
 * @description: TODO
 * @date 2023/2/27 17:26
 */

@Data
public class UserPageReqDTO extends PageParam {

    private String nickName;
}
