package Test7;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        FileWriter fw=new FileWriter("D:\\Info.txt");
        while(true){
            System.out.println("请输入内容：");
            String str = sc.next();
            if("886".equals(str)){
                break;
            }else{
                fw.write(str);
                fw.write("\r\n");
            }

        }
        fw.close();


    }
}
