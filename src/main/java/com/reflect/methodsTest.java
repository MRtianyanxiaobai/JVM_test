package com.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class methodsTest {
    byte[] buffer = new byte[1 * 1024 * 1024];//1MB

        public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

            Employee employee = new Employee("小明", "18", "写代码", 1, "Java攻城狮", 100000);
            Method sayHello = employee.getClass().getMethod("sayHello");
            System.out.println(sayHello);   // 打印 sayHello 的方法信息

            for (int i = 0; i < 30; i++) {
                sayHello.invoke(employee);      // 让 employee 执行 sayHello 方法
                long end = System.currentTimeMillis();

            }

        }


}

