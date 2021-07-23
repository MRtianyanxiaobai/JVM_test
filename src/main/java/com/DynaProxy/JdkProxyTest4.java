package com.DynaProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;



public class JdkProxyTest4 {
    //传入任意目标类，返回它的代理类

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        //设置保存代理类
        DynamicProxy dynamicProxyTool = new DynamicProxy(new Printer());
        IPrinter iPrinterProxy = dynamicProxyTool.getProxy();
        iPrinterProxy.print();
        System.out.println("-----------------------------");
        iPrinterProxy.close();
    }

}
