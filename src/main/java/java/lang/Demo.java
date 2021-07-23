package java.lang;

public class Demo{
    private int num = 1;
    public int add(){
        num = num + 2;
        return num;
    }
}
class Father {
    static {
        System.out.println("Father类的初始化过程");
    }
}



