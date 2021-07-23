package com.DynaProxy;

import java.lang.reflect.*;

public class JdkProxyTest2 {
        //传入任意目标类，返回它的代理类
        private  static Object getProxy(final  Object target) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            Class iprinterProxyClazz = Proxy.getProxyClass(target.getClass().getClassLoader(),target.getClass().getInterfaces());
            //获取构造器
            Constructor iprinterConstructer = iprinterProxyClazz.getConstructor(InvocationHandler.class);
            //利用反射创建实例，即通过构造器创建实例
            Object proxyImpl = (Object) iprinterConstructer.newInstance(new InvocationHandler() {
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("方法调用前准备的日志");
                    //手动new一个 打印机的实现案例
                    method.invoke(target,args);
                    System.out.println("方法调用前准备的日志");

                    return 0;
                }
            });
            return  proxyImpl;

        }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        //设置保存代理类
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        Printer printerimpl = new Printer();
        IPrinter iPrinterProxy = (IPrinter) getProxy(printerimpl);
        iPrinterProxy.print();
        System.out.println("-----------------------------");
        iPrinterProxy.close();
    }

}
