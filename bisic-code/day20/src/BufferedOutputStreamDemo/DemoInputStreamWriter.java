package BufferedOutputStreamDemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class DemoInputStreamWriter {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter isw=new OutputStreamWriter(new FileOutputStream("day20\\src\\b.txt"),"UTF-8");
        isw.write("你好不好");
        isw.close();

    }
}
