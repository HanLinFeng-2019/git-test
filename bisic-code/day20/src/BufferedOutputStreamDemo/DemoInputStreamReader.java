package BufferedOutputStreamDemo;

import java.io.*;

public class DemoInputStreamReader {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(new FileInputStream("D:\\GBK文件.txt"),"GBK");
        int len;
        while((len=isr.read())!=-1){
            System.out.println((char)len);
        }
        isr.close();
    }
}
