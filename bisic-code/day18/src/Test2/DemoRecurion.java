package Test2;

import java.io.File;

public class DemoRecurion {
    public static void main(String[] args) {
//        File file=new File("E:\\作业\\就业班");
//           getAll(file);
        int s=sum(3);
        System.out.println(s);
    }

//    private static void getAll(File dir) {
//        System.out.println(dir);
//        File[] files = dir.listFiles();
//        for (File f : files) {
//            if(f.isDirectory()){
//                getAll(f);
//            }else{
////                if(f.getName().toLowerCase().endsWith(".java")){
//                    System.out.println(f);
////                }
//
//            }
//        }
//
//
//    }

    private static int sum(int n) {
        if(n==1){
            return 1;
        }
        return n+sum(n-1);
    }
}
