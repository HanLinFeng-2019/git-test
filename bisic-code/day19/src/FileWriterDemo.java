import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
//        FileWriter fw=new FileWriter("E:\\b.txt");
//        fw.write("传智播客");
//        fw.write("黑马程序员",0,2);
//        fw.close();
//        FileOutputStream fos=new FileOutputStream("D:\\c.txt",true);
////        byte[] arr="i love java".getBytes();
////        fos.write(arr,0,11);
////        fos.close();
//        for(int i=1;i<=5;i++){
//            fos.write("\r\n".getBytes());
//            fos.write("I love Java".getBytes());
//        }
//        fos.close();
        //课后作业第五题
//        FileInputStream fis=new FileInputStream("D:\\b.txt");
//        byte[] ch=new byte[1024];
//        int len;
//        while((len=fis.read(ch))!=-1){
//          fis.read(ch, 0, len);
//            System.out.println(new String(ch, 0, len));
//        }
//            fis.close();
        //课后作业第六题
        FileInputStream fis=new FileInputStream("E:\\a.png");
        FileOutputStream fos=new FileOutputStream("D:\\a.png");
        int len;
        while((len=fis.read())!=-1){
            fos.write(len);
        }
            fos.close();
            fis.close();
            //
    }
}
