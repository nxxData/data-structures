package niubenben;

public class OverrideDemo {
    public static void main(String[] args) {
        // write your code here
        Apple apple=new Apple();
        apple.info();
    }
}
class Fruit{
    public void info(){
        System.out.println("描述苹果的信息");
    }
}
class Apple extends Fruit{
    @Override
    public void info(){
        System.out.println("我是苹果");
    }
}