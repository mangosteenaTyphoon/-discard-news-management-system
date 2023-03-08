package com.common.base.enity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/19 20:40
 */
@Data
@TableName("sys_menu")
public class MenuEntity {

    @TableId(value = "id",type = IdType.UUID)
    private String id;

    @TableField("menu_name")
    private String menuName;

    @TableField("menu_key")
    private String menuKey;

    @TableField("menu_url")
    private String menuUrl;

    @TableField("menu_type")
    private String menuType;

    @TableField("parent_id")
    private Long parentId;

    @TableField("menu_sort")
    private Long menuSort;

    private Integer status;
}
