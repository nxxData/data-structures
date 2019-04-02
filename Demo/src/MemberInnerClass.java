public class MemberInnerClass {
    public static void main(String [] args){
        //创建外部类的对象
        Outer1 outer1=new Outer1();
        //创建内部类的对象
        Outer1.Inner1 inner1=outer1.new Inner1();
        inner1.innerShow();
    }
}

class Outer1{
    private String name="张三";
    private int num1=10;
    public void outerShow(){
        System.out.println(name);
        System.out.println(num1);
        //System.out.println(num2);外部类不能调用内部类成员

    }
    public class Inner1{
        private String name="李四";
        private int num2=20;
        private static final int num3=1;//内部类可以声明静态常量
        //public static String name1;内部类不能声明静态成员static
        public void innerShow(){
            System.out.println(Outer1.this.name);
            System.out.println(Outer1.this.num1);//成员内部类可以访问外部类的属性和成员
        }
    }
}
