/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndcamera.ejb;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author NUWAA
 */
public class LoggingInterceptor {

    @AroundInvoke
    public Object intercept(InvocationContext invocation) throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.println("Calling method: " + invocation.getMethod().getName());
        Object result = invocation.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + "ms");
        return result;
    }
}
