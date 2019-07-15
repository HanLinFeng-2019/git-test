package Test7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {

        new Thread(new Runnable() {
            ServerSocket server=new ServerSocket(8002);
            @Override
            public void run() {
                try{

                    Socket socket = server.accept();
                    InputStream is = socket.getInputStream();
                    BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("E:\\n.jpg"));
                    byte[] bytes=new byte[1024];
                    int len;
                    while((len=is.read(bytes))!=-1){
                        bos.write(bytes,0,len);
                    }
                    OutputStream os = socket.getOutputStream();
                    os.write("上传成功".getBytes());
                    os.close();
                    bos.close();
                    is.close();
                    socket.close();
                }catch(IOException e){

                }

            }
        }).start();

    }
}
