package niubenben;

import java.io.*;

public class CopyDirDemo {
    public static void main(String[] args) {
        // write your code here
        CopyDirUtil.copyDir(new File("e:\\PS"),new File("d:\\PS"));
        System.out.println("success");
    }
}
class CopyDirUtil{
    public static void copyDir(File src,File dst){
        dst.mkdirs();//e\\zz\\bb判断创建目标文件夹
        if (src!=null){
            File[] files=src.listFiles();//遍历源文件中的所有文件或目录
            if (files!=null){
                for (File f:files){
                    if (f.isFile()){
                        //复制文件
                        try {
                            FileInputStream fis=new FileInputStream(f);
                            FileOutputStream fos=new FileOutputStream(dst.getAbsolutePath()+"\\"+f.getName());
                            byte[] buff=new byte[1024*1024];//自定义一个字节缓冲区
                            int len=0;//保存的是读到的字节个数
                            while ((len=fis.read(buff))!=-1){
                                fos.write(buff,0,len);
                            }
                            fis.close();
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }else{
                        copyDir(f,new File(dst.getAbsolutePath()+"\\"+f.getName()));
                    }
                }
            }
        }
    }
}