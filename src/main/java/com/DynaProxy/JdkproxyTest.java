package com.DynaProxy;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkproxyTest {
//    Proxy.getProxyClass()
    public static void main(String[] args) throws Exception {
        //两个参数，第一个为类加载器，可以为任意的类加载器
        //第二个需要创建对象的类接口
        Class iprinterProxyClazz = Proxy.getProxyClass(JdkproxyTest.class.getClassLoader(),Printer.class.getInterfaces());
        //获取构造器
        Constructor iprinterConstructer = iprinterProxyClazz.getConstructor(InvocationHandler.class);
        //利用反射创建实例，即通过构造器创建实例
        IPrinter iPrinterimpl = (IPrinter) iprinterConstructer.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("方法调用前准备的日志");
                //手动new一个 打印机的实现案例
                Printer printerImpl = new Printer();
                method.invoke(printerImpl,args);
                System.out.println("方法调用前准备的日志");

                return 0;
            }
        });
        iPrinterimpl.print();

    }
}
