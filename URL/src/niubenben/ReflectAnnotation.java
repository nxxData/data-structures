package niubenben;

import java.lang.annotation.*;
import java.lang.reflect.Method;

public class ReflectAnnotation {
    public static void main(String[] args) throws Exception{
        Class<?> classType=Class.forName("niubenben.AnnotationTest");
        boolean flag=classType.isAnnotationPresent(Description.class);//注解和类是同一级别的
        if (flag){
            Description description=(Description)classType.getAnnotation(Description.class);
            System.out.println("AnnotationTest's description---->"+description.value());
            Method[] methods=classType.getDeclaredMethods();
            for (Method method:methods){
                if (method.isAnnotationPresent(Author.class)){
                    Author author=(Author) method.getAnnotation(Author.class);
                    System.out.println("AnnotationTest's author---->"+author.name()+"from"+author.group());
                }
            }
        }
    }
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@interface Author{
    String name();
    String group();
}
@Retention(RetentionPolicy.RUNTIME)//一直保留到运行阶段直到java虚拟机的运行结束为止
@Target(ElementType.TYPE)
@Documented
@interface Description{
    String value();
}
@Description("这是一个用来测试的类")
class AnnotationTest{
    @Author(name="chenhao",group = "com.iotek")
    public void test(){
        System.out.println("test over");
    }
}
