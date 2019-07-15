package Test7;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\a.jpg");
        if(!file.exists()){
            return;
        }
        if (!file.getName().endsWith(".jpg")){
            return;
        }
        if (file.length()>=1024*1024*2){

            return;
        }
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
        Socket socket=new Socket("127.0.0.1",8002);
        OutputStream os = socket.getOutputStream();
        byte[] bytes=new byte[1024];
        int len;
        while((len=bis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        while((len=is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }

        is.close();
        os.close();
        bis.close();
        socket.close();
    }
}
