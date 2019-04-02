package niubenben;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPDemo2 {
    public static void main(String[] args) throws IOException {
        // write your code here
        DatagramSocket socket =new DatagramSocket(8000);
        byte[] buff=new byte[100];
        DatagramPacket packet=new DatagramPacket(buff,100);
        socket.receive(packet);//接受传来的数据包
        System.out.println(new String(buff,0,packet.getLength()));

        String str="me too!";
        DatagramPacket packet1=new DatagramPacket(str.getBytes(),str.length(),packet.getAddress(),packet.getPort());
        socket.send(packet1);
        System.out.println(new String(packet1.getData()));
        socket.close();
    }
}
