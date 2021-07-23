package com.company;

public class OperateStack {
    public static void main(String[] args) {
        //byte、short、char、boolean：声明在数组中存放时，都以int型来保存
        OperateStack operateStack = new OperateStack();
        System.out.println(operateStack.testGetSum());
    }
    public int getSum(){
        int m = 10;
        int n = 20;
        int k = m + n;
        return k;
    }
    public int testGetSum(){
        System.out.println(this.toString());
        //获取上一个栈桢返回的结果，并保存在操作数栈中
        int i = getSum();
        int j = 10;
        return i+j;
    }
}
