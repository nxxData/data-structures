import jdk.nashorn.internal.ir.IfNode;

public class FinalDemo {

}
class A{
    public final int number1=1;//加了final就是常量了
    public int number2=2;
    public void show(){
        //number1++;
    }
}
