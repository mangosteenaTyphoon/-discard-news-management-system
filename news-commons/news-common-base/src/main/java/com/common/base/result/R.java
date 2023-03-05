package com.common.base.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//统一返回结果的类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R<T> implements Serializable {
    private String code;
    private String msg;
    private T data;

    public R(String code) {
        this.code = code;
        this.msg = ResultCode.SELECT_SUCCESS.getCode();
    }

    public R(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public R(T data) {
        this.code = ResultCode.SELECT_SUCCESS.getCode();
        this.data = data;
        this.msg = ResultCode.SELECT_SUCCESS.getMsg();
    }

    public static R success(String msg) {
        return new R(ResultCode.SELECT_SUCCESS.getCode(),msg);
    }


    public static R success(Object data) {
        return new R(data);
    }

    public static R fail() {
        return new R(ResultCode.FAIL_ERROR);
    }

    public static R fail(String msg) {
        return R.fail(ResultCode.FAIL_ERROR.getCode(), msg);
    }

    public static R fail(String code, String msg) {
        return new R(code, msg);
    }

    public static <T> R<T> failed(ErrorCode errorCode) {
        return new R<T>(errorCode.getCode(), errorCode.getMsg(), null);
    }
}

