package niubenben;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayInputOutputStream {
    public static void main(String[] args) {
        // write your code here
//        String string="hello,shanghai";
//        ByteArrayInputStream bis=new ByteArrayInputStream(string.getBytes());//没有调用操作系统的底层资源所以不用关闭
//        int data=-1;
//        while ((data=bis.read())!=-1){
//            System.out.println((char)data);
//        }
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        bos.write(97);
        bos.write(65);
        try {
            bos.write("hello,world".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] buff=bos.toByteArray();
        for (byte data:buff){
            System.out.print((char) data);
        }

        try {
            FileOutputStream fos=new FileOutputStream("d:\\aa.txt",true);
            bos.writeTo(fos);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
