package test1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo01 {
    public static void main(String[] args) {
        List<stutb> list = new JDBCDemo01().full();
        System.out.println(list);
        System.out.println(list.size());

    }

    public List<stutb> full(){
        Connection con =null;
        Statement state=null;
        ResultSet rs=null;
        List<stutb> list=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///studb","root","root");
            String sql="select * from stutb";
            state = con.createStatement();
            rs = state.executeQuery(sql);
            list=new ArrayList<stutb>();
            stutb stu=null;

            while(rs.next()){
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String sex = rs.getString("sex");
                String department = rs.getString("department");
                int score = rs.getInt("score");

                stu=new stutb();
                stu.setName(name);
                stu.setAge(age);
                stu.setSex(sex);
                stu.setDepartment(department);
                stu.setScore(score);

                list.add(stu);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           if(state!=null){
               try {
                   state.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
          if(con!=null){
              try {
                  con.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
        }
        return list;
    }
}
