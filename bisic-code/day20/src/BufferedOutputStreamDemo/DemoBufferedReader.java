package BufferedOutputStreamDemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DemoBufferedReader {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("day20\\src\\b.txt"));
        String line;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
        br.close();
    }
}
