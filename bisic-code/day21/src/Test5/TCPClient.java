package Test5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",8888);
        OutputStream os = socket.getOutputStream();
        os.write("Hello服务器，我是客户端".getBytes());
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        byte[] bytes=new byte[1024];
        int len;
        while((len=is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        is.close();
        os.close();
        socket.close();
    }
}
