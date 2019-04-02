package niubenben;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPDemo1 {
    public static void main(String[] args) throws IOException {
        // write your code here
        DatagramSocket socket=new DatagramSocket();
        String str="i love you!";
        //把数据进行封装，封装到数据报包中
        DatagramPacket packet=new DatagramPacket(str.getBytes(),str.length(), InetAddress.getByName("localhost"),8000);
        socket.send(packet);//发送

        byte[] buff=new byte[100];
        DatagramPacket packet1=new DatagramPacket(buff,100);
        socket.receive(packet1);
        System.out.println(new String(buff,0,packet1.getLength()));
        socket.close();
    }
}
