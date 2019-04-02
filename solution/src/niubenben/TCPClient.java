package niubenben;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        // write your code here
        Socket socket=new Socket("127.0.0.1",8888);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (true){
            String line=br.readLine();//获取键盘所输入的字符串
            bw.write(line);
            bw.newLine();//有换行才会知道结束了
            bw.flush();
            if (line.equals("over")){
                break;
            }
            System.out.println(reader.readLine());//获取服务端传来的大写数据
        }
        reader.close();
        br.close();
        bw.close();
        socket.close();
    }
}
