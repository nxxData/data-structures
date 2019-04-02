import java.util.Random;

public class RandomCode {
    public static void main(String[] args) {
        // write your code here
        System.out.println("验证码如下：\n"+RandomGen.codeGen());
    }
}
class RandomGen{
    //生成四位不重复的验证码
    public static String codeGen(){
        char[] codeSequence={'A','B','C','D','E','F','G','H','I','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','1','2','3','4','5','6','7','8','9','0'};
        Random random=new Random();
        int count=0;
        StringBuilder stringBuilder=new StringBuilder();
        while (true){
            //随机产生一个下标，通过下标取出字符数组中对应的字符
            char c=codeSequence[random.nextInt(codeSequence.length)];
            //假设取出来的字符在动态字符中不存在，代表没有重复
            if (stringBuilder.indexOf(c+"")==-1){
                stringBuilder.append(c);//追加到动态字符串中
                count++;
                if (count==4){
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }
}
