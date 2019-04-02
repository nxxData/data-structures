package niubenben;

import java.io.*;
import java.net.Socket;

public class ServerStream implements Runnable{
    private Socket socket=null;
    private  int number;
    public ServerStream(Socket socket,int number){
        super();
        this.socket=socket;
        this.number=number;
    }
    @Override
    public void run(){
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);//自动刷新输出流
            while (true){
                String line=br.readLine();
                System.out.println("客户端"+number+":"+line);
                pw.println(line.toUpperCase());
                if (line.equals("bye")) {
                    System.out.println("客户端" + number + "已经断开连接");
                    break;
                }
            }
            br.close();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
