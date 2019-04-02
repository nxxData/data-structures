package niubenben;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            DownLoadUtil.download("https://i1.hdslb.com/bfs/archive/7970fcda180df1b6f158b5ad777a2775fde08cd2.jpg","DZW.jpg","e:\\");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class DownLoadUtil{
    public static void download(String urlString,String fileName,String savePath)throws IOException {
        URL url=new URL(urlString);
        URLConnection conn=url.openConnection();
        InputStream is=conn.getInputStream();
        byte[] buff=new byte[1024];
        int len=0;
        File file=new File(savePath);
        if (!file.exists()){
            file.mkdirs();
        }
        OutputStream os=new FileOutputStream(file.getAbsolutePath()+"\\"+fileName);
        while ((len=is.read(buff))!=-1){
            os.write(buff,0,len);
        }
        //释放资源
        os.close();
        is.close();
    }
}
