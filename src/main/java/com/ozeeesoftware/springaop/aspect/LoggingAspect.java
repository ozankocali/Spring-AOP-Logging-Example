package com.ozeeesoftware.springaop.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    Logger logger= LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut(value = "execution(* com.ozeeesoftware.springaop.controller.StudentController.createStudent(..))")
    public void myPointcut(){

    }


    @Around("myPointcut()")
    public Object saveStudentLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper mapper=new ObjectMapper();
        String methodName=proceedingJoinPoint.getSignature().getName();
        String className=proceedingJoinPoint.getTarget().toString();
        Object[] array=proceedingJoinPoint.getArgs();

        logger.info("method invoked"+className+" : "+methodName+"()"+"arguments : "+mapper.writeValueAsString(array));

        Object object=proceedingJoinPoint.proceed();

        logger.info(className+" : "+methodName+"()"+"Response : "+mapper.writeValueAsString(object));

        return object;
    }


}
