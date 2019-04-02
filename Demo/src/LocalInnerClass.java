import sun.net.idn.Punycode;

public class LocalInnerClass {
    public static void main(String[] args){
        Outer3 outer3=new Outer3();
        outer3.showOuter();
    }
}

class Outer3{
    private String name="zhangsan";
    private int num1=10;
    private static int num2=20;
    public void showOuter(){
        int num4=50;
        //局部内部类不能加访问修饰符
        class Inner3{
            private int num3=30;
            private int num1=40;
            public void showInner(){
                System.out.println(num3);
                System.out.println(num1);
                System.out.println(num4);

            }
        }
        Inner3 inner3=new Inner3();
        inner3.showInner();
    }
}
