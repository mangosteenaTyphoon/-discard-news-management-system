package com.common.base.dto.base;

import lombok.Data;

/**
 * @author 山竹
 * @version 1.0
 * @description: TODO
 * @date 2023/2/27 17:26
 */

@Data
public class PageParam {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private String orderCon;
    private String sortCon;
}
