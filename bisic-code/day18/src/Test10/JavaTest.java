package Test10;

import java.io.File;
import java.io.FileFilter;


public class JavaTest {
    public static void main(String[] args) {
            File f=new File("E:\\作业");
//        File[] files = f.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                if(pathname.getName().endsWith(".java")){
//                    return true;
//                }else{
//                    return false;
//                }
//            }
//        });
        File[] files= f.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
        f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        });
        f.listFiles(pathname->pathname.getName().endsWith(".java"));
    }


}
