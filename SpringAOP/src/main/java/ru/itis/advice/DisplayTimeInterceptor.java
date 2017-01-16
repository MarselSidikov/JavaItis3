package ru.itis.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Date;

public class DisplayTimeInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Time before launch: " + new Date());
        Object value = invocation.proceed();
        System.out.println("Time after launch: " + new Date());
        return value;
    }
}
