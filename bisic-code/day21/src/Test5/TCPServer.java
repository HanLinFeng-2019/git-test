package Test5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(8888);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        byte[] bytes=new byte[1024];
        int len;
        while((len=is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
                os.write(bytes,0,len);
        }
        socket.shutdownOutput();
        os.close();
        is.close();
        server.close();

    }
}
