package com.common.base.exceptionhandler;



import com.common.base.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseBody//这个为了返回数据
    public R error(Exception e){
        e.printStackTrace();
        return R.fail("执行了全局异常");
    }

    @ExceptionHandler(MyException.class)
    @ResponseBody//这个为了返回数据
    public R error(MyException e){
        log.error(e.getName());
        e.printStackTrace();
        return R.fail(e.getMessage());
    }


}
