import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo01 {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource com = new ComboPooledDataSource();
        Connection conn = com.getConnection();
        System.out.println(conn);



    }
}
