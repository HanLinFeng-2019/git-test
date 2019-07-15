package Test5;

import java.io.File;

public class Test05 {
    public static void main(String[] args) {
        File dir=new File("");
        File[] files = dir.listFiles();
        for (File file : files) {
            file.delete();
        }
        dir.delete();

    }
}
