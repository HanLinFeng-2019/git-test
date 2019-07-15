package Test2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("D:\\a.png");
        Socket sockets=new Socket("192.168.24.74",9999);
        OutputStream os = sockets.getOutputStream();
        byte[] bytes=new byte[1024];
        int len;
        while((len=fis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        sockets.shutdownOutput();
        InputStream is = sockets.getInputStream();
        while((len=is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        fis.close();
        sockets.close();
    }
}
