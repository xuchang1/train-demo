package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspectDemo2 {

    /**
     * 定义切点 — 拦截所有 Controller 包下的公共方法
     */
    @Pointcut("execution(public * org.example.service..*(..))")
    public void serviceMethods() {}

    /**
     * 环绕通知
     */
    @Around("serviceMethods()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // 可以获取到方法入参等信息
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
        Object[] args = joinPoint.getArgs();
        log.info("start service aop");
        Object result = null;
        try {
            result = joinPoint.proceed(); // 执行目标方法
            return result;
        } finally {
            log.info("end service aop");
        }
    }
}
