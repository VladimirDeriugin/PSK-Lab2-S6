package org.example.lab2.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
@LoggedInvocation
public class MethodLogger implements Serializable {
    @AroundInvoke
    public Object logMethodInvocation(InvocationContext ctx) throws Exception {
        String className = ctx.getMethod().getDeclaringClass().getName();
        String methodName = ctx.getMethod().getName();
        System.out.println("Entering method: " + className + "." + methodName);
        return ctx.proceed();
    }
}