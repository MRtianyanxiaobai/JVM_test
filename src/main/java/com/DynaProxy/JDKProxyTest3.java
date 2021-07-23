package com.DynaProxy;

import java.lang.reflect.*;

public class JDKProxyTest3 {
    //传入任意目标类，返回它的代理类
    private  static Object getProxy(final  Object target) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader()
                    , target.getClass().getInterfaces()
                    , new InvocationHandler() {
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            System.out.println("方法调用前准备的日志");
                            //手动new一个 打印机的实现案例
                            method.invoke(target,args);
                            System.out.println("方法调用前准备的日志");

                            return 0;
                        }
                    });
            return  proxy;

    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        //设置保存代理类
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Printer printerimpl = new Printer();
        IPrinter iPrinterProxy = (IPrinter) getProxy(printerimpl);
        iPrinterProxy.print();
        System.out.println("-----------------------------");
        iPrinterProxy.close();
    }
}
