package Test2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer2 {
    public static void main(String[] args) throws IOException {
    ServerSocket server=new ServerSocket(9999);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Socket socket = server.accept();
                    InputStream is = socket.getInputStream();

                    FileOutputStream fos=new FileOutputStream("E:\\c.png");
                    byte[] bytes=new byte[1024];
                    int len;
                    while((len=is.read(bytes))!=-1){
                        fos.write(bytes,0,len);
                    }

                    OutputStream os = socket.getOutputStream();
                    os.write("上传成功".getBytes());
                    fos.close();
                    socket.close();
                }catch(IOException e){
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
