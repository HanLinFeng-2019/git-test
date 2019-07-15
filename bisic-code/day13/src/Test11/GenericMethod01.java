package Test11;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class GenericMethod01<E> {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket(InetAddress.getByName("192.168.24.75"),9999);
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fos=new FileOutputStream(new File("d:\\c.jpg"));
        byte[]bytes=new byte[1024];
        int len;
        while((len=inputStream.read(bytes))!=-1){
            fos.write(bytes,0,len);
            fos.flush();
        }
        fos.close();
        socket.close();

    }
}
