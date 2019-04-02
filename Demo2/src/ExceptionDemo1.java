import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo1 {
    public static void main(String[] args) {
        // write your code here
        System.out.println("请输入一个数字");
        Scanner input=new Scanner(System.in);
        int res=0;
        try {
            int number=input.nextInt();
            res=10/number;
        }catch (InputMismatchException e){
            System.out.println("只能输入数字");
            System.out.println(e.getMessage());
        }catch (ArithmeticException e){
            System.out.println("不能输入0");
            System.out.println(e.getMessage());
        }finally {
            //释放资源，关闭打开的文件，删除一些临时文件
            System.out.println(res);
        }
    }
}
