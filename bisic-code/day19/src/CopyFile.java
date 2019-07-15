import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("D:\\a.txt");
        FileOutputStream fos=new FileOutputStream("E:\\a.txt");
        long start = System.currentTimeMillis();
        byte[] bytes=new byte[1024];
         int len;
         while((len=fis.read(bytes))!=-1){
             fos.write(bytes,0,len);
         }
         fos.close();
         fis.close();


        long end = System.currentTimeMillis();
        System.out.println("耗时:"+(end-start)+"毫秒");
    }
}
