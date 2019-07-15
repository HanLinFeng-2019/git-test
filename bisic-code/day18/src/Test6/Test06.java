package Test6;

import java.io.File;

public class Test06 {
    public static void main(String[] args) {
        File dir=new File("");
        long len=0;
        File[] files = dir.listFiles();
        for (File file : files) {
            len+=file.length();
        }

    }
}
