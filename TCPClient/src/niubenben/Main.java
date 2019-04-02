package niubenben;

import java.io.IOException;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Socket socket=new Socket("127.0.0.1",8888);
        new Thread(new ClientInputStream(socket)).start();
        new Thread(new ClientOutputStream(socket)).start();
    }
}
