import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoOutputStream {
    public static void main(String[] args) throws IOException {
//        FileOutputStream fos=new FileOutputStream("D:\\a.txt");
////        fos.write(97);
////       byte[] b={60,65,66,67,68};
////       fos.write(b);
////       fos.write(b,1,2);
//
FileInputStream fis=new FileInputStream("\\day19\\src\\b.txt");
            byte[] t= new byte[1024];
                int len;
                while((len=fis.read(t))!=-1){
                    System.out.println(new String(t,0,len));
                }
                fis.close();
    }
}
