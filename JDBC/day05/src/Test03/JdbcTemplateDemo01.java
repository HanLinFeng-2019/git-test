package Test03;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

public class JdbcTemplateDemo01 {
    public static void main(String[] args) throws SQLException {
        JdbcTemplate template= new JdbcTemplate((DataSource) JDBCUtils.getConnection());
    }
}
