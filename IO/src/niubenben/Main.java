package niubenben;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Main {

    public static void main(String[] args) {
	// write your code here
        IteratorUtil.IteratorDir(new File("E:\\PS"));
    }
}
class IteratorUtil{
    private static int level=0;//保存层级数
    public static void IteratorDir(File file){
        if (file!=null){
            //找出递归的出口
            // 假设是文件或者空文件夹就返回
            if (file.isFile()||file.listFiles().length==0){
                return;
            }else {
                File[] files=file.listFiles();
                //先输出文件夹再输出文件
                files=sort(files);
                for (File f:files){
                    StringBuilder sb=new StringBuilder();
                    if (f.isFile()){
                        sb.append(getTab(level));
                        sb.append(f.getName());
                    }else {
                        sb.append(getTab(level));
                        sb.append(f.getName());
                        sb.append("\\");
                    }
                    System.out.println(sb.toString());
                    //假如是文件夹
                    if (f.isDirectory()){
                        level++;
                        IteratorDir(f);//递归调用遍历目录的方法
                        level--;//目录层级减一，退回上一级目录
                    }
                }

            }
        }
    }

    /**
     * 对file类型的数组进行先目录后文件的排列
     * @param files
     * @return
     */
    private static File[] sort(File[] files){
        List<File> fileList=new ArrayList<File>();
        //先存放文件夹（目录）
        for (File f:files){
            if (f.isDirectory()){
                fileList.add(f);
            }
        }
        // 再存放文件
        for (File f:files){
            if (f.isFile()){
                fileList.add(f);
            }
        }
        return fileList.toArray(new File[fileList.size()]);
    }

    private static String getTab(int level){
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<level;i++){
            sb.append("\t");
        }
        return sb.toString();
    }

}
