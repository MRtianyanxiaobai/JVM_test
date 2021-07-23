package com.company;

public class classTest4 {
    private static int count=0;
    public static void recursion(){
        count++;
        System.out.println(count);
        recursion();
    }
    public static void main(String args[]){
        try{
            recursion();
        } catch (Exception e){
            System.out.println("deep of calling="+count);
            e.printStackTrace();
        }
    }
}
