package com.referenceQue;

public class classloadert {
    public static void main(String[] args) {
        System.out.println(classloadert.class.getClassLoader());
        System.out.println(classloadert.class.getClassLoader().getParent());
        System.out.println(classloadert.class.getClassLoader().getParent().getParent());

        //获取系统类加载器
        System.out.println(ClassLoader.getSystemClassLoader());
        //获取平台类加载器
//        System.out.println(ClassLoader.);
        //获取类的加载器的名称
//        System.out.println(classloadert.class.getClassLoader());
    }
}
