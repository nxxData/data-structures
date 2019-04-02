package niubenben;

public class MyAnnotation {
    @MyAnnotation1
    public MyAnnotation(){

    }
    @MyAnnotation2(COLOR = Color.BLUE)
    public static void main(String[] args){
        @MyAnnotation1
        int number=10;
    }
}
//标记注解
@interface MyAnnotation1{

}
enum Color{
    RED,BLUE,YELLOW;
}
@interface MyAnnotation2{
    //String value() default "lisi";
    //String[] value();
    Color COLOR();
}