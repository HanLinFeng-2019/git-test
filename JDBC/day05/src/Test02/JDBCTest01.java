package Test02;

import java.sql.*;

public class JDBCTest01 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stm=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///selldb","root","root");
            String sql="select * from sell order by sellmoney desc limit 0,3";
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int sellnumbers = rs.getInt("sellnumbers");
                int sellmoney = rs.getInt("sellmoney");
                int money = rs.getInt("money");
                System.out.println(id+" "+name+" "+sellnumbers+" "+sellmoney+" "+money);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
