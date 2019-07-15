import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesOutputStream {
    public static void main(String[] args) throws IOException {
        properties();
        return;
    }

    private static void properties() throws IOException {
        Properties pt=new Properties();
        pt.setProperty("王二小","15");
        pt.setProperty("许三多","20");
        pt.setProperty("黄鼠狼","23");

        FileWriter fw=new FileWriter("E:\\a.txt");
        pt.store(fw,"save");
        fw.close();
    }
//    private static void show03(){
//        Properties prop=new Properties();
//        prop.load(new FileReader);
//    }


}



