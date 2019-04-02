package niubenben;

import com.sun.scenario.effect.impl.prism.PrImage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class ClientInputStream implements Runnable{
    private Socket socket=null;

    public ClientInputStream(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);//自动刷新输出流
            while (true) {
                try {
                    String line = br.readLine();
                    System.out.println(line);
                }catch (SocketException e){
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
