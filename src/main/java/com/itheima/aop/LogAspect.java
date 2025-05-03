package com.itheima.aop;

import com.alibaba.fastjson.JSONObject;
import com.itheima.mapper.OperateLogMapper;
import com.itheima.pojo.OperateLog;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@Slf4j
@Aspect
public class LogAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.itheima.anno.Log)")
    public Object record(ProceedingJoinPoint joinPoint) throws Throwable {

        //操作人ID
        String token = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(token);
        Integer operateId = (Integer) claims.get("id");


        //操作时间
        LocalDateTime operateNow = LocalDateTime.now();

        //操作类名
        String operateClassName = joinPoint.getTarget().getClass().getName();

        //操作方法名
        String operateMethodName = joinPoint.getSignature().getName();

        //操作参数
        String operateArgs = Arrays.toString(joinPoint.getArgs());





        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        //方法返回值
        String returnValue = JSONObject.toJSONString(result);

        //耗费时间
        long costTime = end - start;

        OperateLog operate = new OperateLog(null,operateId,operateNow,operateClassName,operateMethodName,operateArgs,returnValue,costTime);


        operateLogMapper.insert(operate);
        return result;
    }
}
