package niubenben;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        // write your code here
        //1.创建一个serversocket对象
        ServerSocket serverSocket=new ServerSocket(8888);
        //2.调用accept（）方法来接受客户端的请求
        Socket socket=serverSocket.accept();
        System.out.println(socket.getInetAddress().getHostAddress()+"has connected!");
        //3.获取socket对象的输入输出流
        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String line=null;
        //读取客户端的数据
        while ((line=br.readLine())!=null){
            if (line.equals("over")){
                break;
            }
            System.out.println(line);
            bw.write(line.toUpperCase());//把转换成大写的字符串传给客户端
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
        socket.close();
        System.out.println(socket.getInetAddress().getHostAddress()+"hasn't connected!");
    }
}
