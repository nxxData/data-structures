public class StaticInnerClass {
    public static void main(String [] args){
        //创建外部类的对象
        Outer1 outer1=new Outer1();
        //创建内部类的对象
        Outer1.Inner1 inner1=outer1.new Inner1();
        inner1.innerShow();
    }
}

class Outer2{
    private String name="张三";
    private int num1=10;
    private static int num3=12;
    public void outerShow(){
        System.out.println(name);
        System.out.println(num1);
    }
    public static class Inner2{
        private String name="李四";
        private int num2=20;
        private static final int num3=1;
        //public static String name1;
        public void innerShow(){
            //静态内部类不能访问外部类的非静态成员
            //System.out.println(Outer2.this.num3);
        }
    }
}
