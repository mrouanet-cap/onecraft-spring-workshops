package io.onecraft.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogTimeMonitoredAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogTimeMonitoredAspect.class);

    @Pointcut("@annotation(io.onecraft.spring.annotation.TimeMonitored)")
    public void timeMonitored() {
    }

    @Pointcut("execution(* io.onecraft.spring.domain.*.*Impl.*(..))")
    public void domainMethods() {
    }

    @AfterThrowing(pointcut = "domainMethods()", throwing = "ex")
    public void afterThrowingAdvice(IllegalArgumentException ex) {
        // Custom logic after the method throws an exception
        logger.error("After throwing advice: Exception caught - %s".formatted(ex.getMessage()));
    }

    @Around("timeMonitored() && domainMethods()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // Custom logic before and after the method execution
        logger.info("Around advice: Before method %s execution".formatted(joinPoint.getSignature().getName()));
        long timeBefore = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long timeAfter = System.currentTimeMillis();
        logger.info("Around advice: After method %s execution".formatted(joinPoint.getSignature().getName()));
        logger.info("Method execution time: %dms".formatted(timeAfter - timeBefore));
        return result;
    }
}
