package JDBCUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class JDBCUtils {
    public static void main(String[] args) {

        try {
            Properties pro = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pro.load(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
