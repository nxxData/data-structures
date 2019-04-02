package niubenben;

public class ClassDemo {
    public static void main(String[] args){
        //forname方法
        try {
            Class<?> classType=Class.forName("niubenben.Employee");
            System.out.println(classType.getName());
            System.out.println(classType.getSuperclass().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Employee{
    private String name;
    private int age;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
