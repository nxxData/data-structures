import java.util.Arrays;

public class MyStringBuilder {
    public static void main(String[] args) {
        // write your code here
        MyStringBuilderDemo myStringBuilderDemo=new MyStringBuilderDemo();
        myStringBuilderDemo.append("hello").append(",java").append("123");
        System.out.println("字敷个数"+myStringBuilderDemo.length());
        System.out.println("字符"+myStringBuilderDemo.toString());
    }
}
class MyStringBuilderDemo{
    private char[] value;
    private int count=0;
    public MyStringBuilderDemo(){
        value=new char[16];
    }
    public MyStringBuilderDemo(int capacity){
        value=new char[capacity];
    }
    public MyStringBuilderDemo(String string){
        value=new char[string.length()+16];
    }
    public int length(){
        return count;
    }
    public int capacity(){
        return value.length;
    }
    public MyStringBuilderDemo append(String string){
        int len=string.length();
        ensureCapacity(count+len);
        //把要添加的字符串追加到新的指定数组的指定位置。
        string.getChars(0,len,value,count);
        count+=len;
        return this;
    }
    private void ensureCapacity(int capacity){
        if (capacity-value.length>0){
            int newCapacity=value.length*2+2;
            value= Arrays.copyOf(value,newCapacity);
        }
    }
    //把字符数组转换成字符形式
    public String toString(){
        return new String(value,0,count);
    }
}