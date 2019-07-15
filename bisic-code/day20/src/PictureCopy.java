import java.io.*;

public class PictureCopy {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("D:\\a.png"));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("E:\\a.png"));

        byte[] b=new byte[1024];
        int len;
        while((len=bis.read())!=-1){
            bos.write(len);
        }
        bos.close();
        bis.close();
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end-start));
    }
}
