public class AutoBoxDemo {
    public static void main(String[] args) {
        // write your code here
        int i=10;
        double d=10.5;
        //把基本类型赋值给引用类型，基本类型会在编译的时候自动装箱
        Integer num1=i;
        Double num2=d;
        System.out.println(num1);
        System.out.println(num2);
        //把包装类（引用类型）赋值给基本类型，会自动拆箱
        int j=num1;
        double dd=num2;
        System.out.println(j);
        System.out.println(dd);
    }
}
