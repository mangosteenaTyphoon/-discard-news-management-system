package com.common.base.dto.common;

import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author 山竹
 * @version 1.0
 * @description: TODO
 * @date 2023/2/15 11:53
 */

@Data
//@Document("operate_log")
public class OperateLog {
    private static final long serialVersionUID = 1L;

    /**
     * 日志主键
     */
//    @Id
    private String operId;

    /**
     * 功能名称
     */
    private String functionName;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 请求方式
     */
    private String requestMethod;

    /**
     * 操作人员
     */
    private String operName;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 请求url
     */
    private String operUrl;

    /**
     * 操作地址
     */
    private String operIp;

    /**
     * 请求参数
     */
    private String operParam;

    /**
     * 返回参数
     */
    private String jsonResult;

    /**
     * 操作状态（0正常 1异常）
     */
    private Integer status;

    /**
     * 错误消息
     */
    private String errorMsg;

    /**
     * 操作时间
     */
    private Date operTime;
}
