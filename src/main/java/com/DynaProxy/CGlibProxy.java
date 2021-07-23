package com.DynaProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibProxy implements MethodInterceptor {

    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法调用前准备的日志");
        //手动new一个 打印机的实现案例
        method.invoke(target,args);
        System.out.println("方法调用后准备的日志");
        return null;
    }

    public  <T> T getProxy(Class<T> cls){
        
        return (T) Enhancer.create(cls,this);
    }
}
