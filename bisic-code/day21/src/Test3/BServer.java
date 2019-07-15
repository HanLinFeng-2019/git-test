package Test3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class BServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(9999);

        while(true){
            Socket socket = server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String s = br.readLine();
                        String[] str = s.split(" ");
                        String path = str[1].substring(1);
                        System.out.println(path);

                        FileInputStream fis=new FileInputStream(path);
                        byte[] bytes=new byte[1024];
                        int line;
                        OutputStream os = socket.getOutputStream();

                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        os.write("Content‐Type:text/html\r\n".getBytes());
                        os.write("\r\n".getBytes());

                        while((line=fis.read(bytes))!=-1){
                            os.write(bytes,0,line);
                        }

                        fis.close();
                        os.close();
                        br.close();
                        socket.close();
                    }catch(IOException e){
                        e.printStackTrace();
                    }

                }
            }).start();
            //浏览器客户端没写结束标识符，如果循环读soket的对象内容，就会因为找不到-1进入阻塞状态。
//        while((len=is.read(bytes))!=-1){
//            System.out.println(new String(bytes,0,len));
//        }
        }

    }
}
