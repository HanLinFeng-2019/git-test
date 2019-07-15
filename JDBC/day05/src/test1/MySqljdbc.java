package test1;

import java.sql.*;

public class MySqljdbc {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql:///studb","root","root");
//        String sql="update stutb set score=100 where age=36";
//        String sql="insert into stutb values('王五',20,'女','pyath基础班',100)";
        String sql="select * from stutb";
        Statement state = con.createStatement();
//        int i = state.executeUpdate(sql);
        ResultSet rs = state.executeQuery(sql);
        while(rs.next()){
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String sex = rs.getString("sex");
            String department = rs.getString("department");
            int score = rs.getInt("score");
            System.out.println(name+"--"+age+"--"+sex+"--"+department+"--"+score);
        }
        state.close();
        con.close();

    }
}
