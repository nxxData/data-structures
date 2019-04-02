public class EmployeeDemo {
    public static void main(String[] args){

    }
}
//抽象类
abstract class Employee{
    private int number;
    private String name;
    private double salary;

    public Employee(int number, String name, double salary) {
    }

    //抽象方法的声明
    public abstract void work();
}
//一旦一个类继承了抽象类，那么这个类就要么实现抽象类中的抽象方法
//要么继续抽象下去
class JavaTeacher extends Employee{
    private double allowance;
    public JavaTeacher(int number,String name,double salary,double allowance){
        super(number,name,salary);
        this.allowance=allowance;
    }
    //抽象方法的实现
    public void work(){
        System.out.println("上java课");
    }
}
