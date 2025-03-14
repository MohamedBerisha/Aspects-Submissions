package com.example.demo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Log before any method in the controller class is called
    @Before("execution(* com.example.demo.controller.Controller.*(..))")
    public void logBefore() {
        System.out.println("A controller method is about to be called");
    }
}
