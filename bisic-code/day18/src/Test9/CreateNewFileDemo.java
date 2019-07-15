package Test9;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreateNewFileDemo {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        String path = sc.next();
        File f=new File(path);
        if(f.exists()){
            System.out.println("输入的文件不存在");
            return;
        }
        if(f.isFile()){
            System.out.println(f.length());
        }else if(f.isDirectory()){
            File[] files = f.listFiles();

            long add=0;
            for (File file : files) {
                if(file.isFile()){
                    add+=file.length();
                }
            }
            System.out.println(add);
        }
    }
}
