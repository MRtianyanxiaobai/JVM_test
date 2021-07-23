package com.DynaProxy;

public class cgProxyTest {
    public static void main(String[] args) {
        DynamicProxy dynamicProxy = new DynamicProxy(new Printer());
        Printer printer = dynamicProxy.getProxy();
        printer.print();
        System.out.println("===========");
        printer.close();
    }
}
