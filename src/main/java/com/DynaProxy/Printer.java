package com.DynaProxy;

public class Printer implements IPrinter{
    @Override
    public void print() {
        System.out.println("=====打印！");
    }

    @Override
    public void close() {
        System.out.println("=====打印机关闭了");
    }
}
