package niubenben;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FactorialDemo {
    public static void main(String[] args){
        try {
            FileCopyUtil.copyFile(new File("E:\\a.jpg"),new File("E:\\b.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class FileCopyUtil{
    public static void copyFile(File src,File dst)throws IOException {
        FileInputStream fis=new FileInputStream(src);
        FileOutputStream fos=new FileOutputStream(dst);
//        long time1=System.currentTimeMillis();
//        int data=-1;
//        while ((data=fis.read())!=-1){
//            fos.write(data);
//        }
//        fos.close();
//        fis.close();
//        long time2=System.currentTimeMillis();
        byte[] buffer=new byte[1024*1024];//创建一个1兆大小的缓冲区，用来存放缓冲的数据
        int len=0;//用来保存实际读到的字节数
        long time1=System.currentTimeMillis();
        while ((len=fis.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        fos.close();
        fis.close();
        long time2=System.currentTimeMillis();
        System.out.println("复制完成共"+(time2-time1)+"毫秒");
    }
}
