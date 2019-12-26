package JDBC;

import java.sql.*;

public class Jdbc_Conn {
    public Connection conn = null;

    protected void jdbc() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/supermarket?useSSL=false&serverTimezone=GMT&characterEncoding=UTF-8";
            String user = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("111"+e.getMessage());
        }
    }
}
