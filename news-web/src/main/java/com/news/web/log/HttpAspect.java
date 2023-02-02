package com.news.web.log;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Aspect
@Component
@Slf4j
public class HttpAspect {

    @Value("${spring.application.name}")
    private String appName;

    /**
     * 这样写是将重复的代码提取出来方便处理
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) " +
            "|| @annotation(org.springframework.web.bind.annotation.GetMapping)" +
            "|| @annotation(org.springframework.web.bind.annotation.PostMapping)" +
            "|| @annotation(org.springframework.web.bind.annotation.DeleteMapping)"
    )
    public void log() {
    }


    @Around("log()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        Date d = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(d);

        StringBuffer url = request.getRequestURL();
        String method = request.getMethod();
        String ip = request.getRemoteAddr();
        String class_method = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String[] argNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();//参数名

        long start = System.currentTimeMillis();
        Map map = new HashMap();
        map.put("currentTime", start);
        map.put("class_method", class_method);
        map.put("url", url);
        map.put("method", method);
        map.put("app_name", appName);
        map.put("ip", ip);
        List a = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();
        for (int i = 0; i < argNames.length; i++) {
            String n = argNames[i];
            String v = "";
            if (args[i] != null) {
                v = (args[i]).toString();
            } else {
                v = "null";
            }
            params.put(n, v);
        }
        map.put("request", params);
        Object result = null;
        try {
            result = joinPoint.proceed();
            map.put("response", JSON.toJSONString(result));
        } catch (Throwable throwable) {
            map.put("exception", ExceptionUtil.getRootCauseMessage(throwable));
            throw throwable;
        } finally {
            map.put("cost", System.currentTimeMillis() - start);
            log.info(JSON.toJSONString(map));
        }
        return result;
    }


}
