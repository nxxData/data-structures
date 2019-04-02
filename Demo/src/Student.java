public class Student {
    private String name;
    private String sex;
    private int age;
    public String getName() {
        return name;
    }
    public String getSex(){
        return sex;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public Student(String name,String sex,int age){
        this.age=age;
        this.name=name;
        this.sex=sex;
    }

    public static void main(String[] args){
        Student student=new Student("张三","男",20);
        int age=student.getAge();
        String name=student.getName();

        String sex=student.getSex();
        System.out.println(name+"  性别："+sex+"，今年"+age+"岁");

    }
}
