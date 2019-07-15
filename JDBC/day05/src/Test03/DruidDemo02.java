package Test03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface DruidDemo02 {
    public static void main(String[] args) {

        try {
            Connection conn = JDBCUtils.getConnection();
            System.out.println(conn);
            String sql="insert into sell values(null,?,?,?,?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,"王二小");
            pre.setInt(2,1);
            pre.setInt(2,110000);
            pre.setInt(2,3000);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
