public class AnonymousInnerClass {
    public static void main(String[] args){
        Person person=new Person();
        person.feed(new Animal() {//animal继承了抽象方法匿名类构造出了方法
            @Override
            public void eat() {
                System.out.println("啃骨头");
            }
        });
    }
}

class Person{
    public void feed(Animal animal){
        animal.eat();
    }
}
abstract class Animal{
    public abstract void eat();
}
