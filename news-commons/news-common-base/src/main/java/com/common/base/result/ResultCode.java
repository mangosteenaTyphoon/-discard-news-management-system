package com.common.base.result;

public enum ResultCode {

    UPDATE_SUCCESS("200","修改成功"),
    SELECT_SUCCESS("200", "成功"),
    UPDATE_ERROR("500","修改失败"),
    DELETE_SUCCESS("200","删除成功"),
    DELETE_ERROR("500","删除失败"),
    FAIL_ERROR("500", "服务器异常"),
    TOKEN_ERROR("999999", "没有携带token或token已被踢下线"),
    PERM_ERROR("999998", "该用户无权限"),
    ROLE_ERROR("999997", "该用户无角色"),
    USER_NO_EXIST_ERROR("A001", "该用户不存在"),
    USER_OR_PASSWD_ERROR("A002", "用户名或密码错误"),
    ILLEGAL_PARAMETER_ERROR("400", "参数不合法");
    private String code;
    private String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
