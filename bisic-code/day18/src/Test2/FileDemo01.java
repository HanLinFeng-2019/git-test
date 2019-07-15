package Test2;

import java.io.File;
import java.io.IOException;

public class FileDemo01 {
    public static void main(String[] args) throws IOException {
//        File f=new File("D:\\a.txt");
//        if(f.exists()){
//            return;
//        }else{
//            boolean b = f.createNewFile();
//            System.out.println(b);
//        }
//        File f1=new File("D:\\ccc\\bbb\\aaa\\b.txt");
//        boolean m = f1.mkdirs();
//        System.out.println(m);
//        boolean n = f1.createNewFile();
//        System.out.println(n);
//
//        String name = f1.getName();
//        System.out.println(name);
//
//        long length = f1.length();
//        System.out.println(length);
//
//        String ab = f1.getAbsolutePath();
//        System.out.println(ab);
//
//        String parent = f1.getParent();
//        System.out.println(parent);
        File f=new File("E:\\作业");
        File[] files = f.listFiles();
        for (File file : files) {
            System.out.println(file);
        }

    }
}
