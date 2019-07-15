package Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket sk=new Socket("127.0.0.1",8080);
        OutputStream os = sk.getOutputStream();
        os.write("你好陌生人".getBytes());


        sk.close();
    }
}
