package com.DynaProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxy implements InvocationHandler {
    Object target = null;
    public DynamicProxy(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法调用前准备的日志");
        //手动new一个 打印机的实现案例
        method.invoke(target,args);
        System.out.println("方法调用前准备的日志");

        return 0;
    }
    //将invoke和getProxy解耦
    public <T> T getProxy()  {
        return (T) Proxy.newProxyInstance(this.target.getClass().getClassLoader()
                , this.target.getClass().getInterfaces(),this);

    }
}