package com.common.base.enity.user;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/19 20:28
 */
@Data
@TableName("sys_user")
public class UserEntity {

    @TableId(value = "id",type = IdType.UUID)
    private String id;

    @TableField("user_name")
    private String userName;

    private String password;

    private String email;

    private String phone;

    @TableField("nick_name")
    private String nickName;

    private Integer sex;

    private Integer status;

    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createTime;

    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date updateTime;



}
