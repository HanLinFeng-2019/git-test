package Test1;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        show3();
    }

    private static void show3() {
        File f=new File("E:\\作业\\就业班\\day06\\day06课堂笔记.txt");
        String[] list = f.list();
        for (String s : list) {
            System.out.println(s);
        }
        File[] files = f.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
    }

    private static void show2() {
        File f4=new File("day18\\src\\Test1\\FileTest.java");

        System.out.println(f4.getAbsolutePath());

        System.out.println(f4.exists());
        File f5=new File("day18\\src\\a\\b\\Test1\\FileTest.java");

        System.out.println(f5.mkdirs());
        System.out.println(f5);
    }

    private static void show1() {
        File f=new File("E:\\作业\\就业班\\day01\\day01课堂笔记.txt");
        File f1=new File("day02");
        File absoluteFile = f.getAbsoluteFile();
        System.out.println(absoluteFile);
        File f3=new File("day01课堂笔记.txt");
        System.out.println(f3.getAbsoluteFile());
        String name = f.getName();
        System.out.println(name);
        String path = f1.getPath();
        System.out.println(path);
        long length = f.length();
        System.out.println(length);
        boolean exists = f.exists();
        System.out.println(exists);
        boolean directory = f.isDirectory();
        System.out.println(directory);
        boolean file = f.isFile();
        System.out.println(file);

    }
}
