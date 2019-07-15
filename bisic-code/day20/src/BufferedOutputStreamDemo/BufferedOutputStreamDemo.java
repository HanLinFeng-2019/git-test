package BufferedOutputStreamDemo;

import java.io.*;

public class BufferedOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("day20\\src\\b.txt"));
        bos.write("你好陌生人".getBytes());
        bos.close();
/*
BufferedInputStream bis=new BufferedInputStream(new FileInputStream("day20\\src\\b.txt"));
byte[] b=new byte[1024];
int len;
while((len=bis.read(b))!=-1){
System.out.println(new String(b,0,len));
}
bis.close();
*/
    }
}
