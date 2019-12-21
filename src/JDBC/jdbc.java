package JDBC;

import javax.swing.*;
import java.sql.*;

class Jdbc_Conn {
    Connection conn = null;
    ResultSet rs = null;
    Statement stmt = null;
//    PreparedStatement pt = null;
    protected void jdbc() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/supermarket?useSSL=false";
            String user = "root";
            String password = "";
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("111"+e.getMessage());
        }
    }
}

public class jdbc extends Jdbc_Conn {
    //数据库连接
    protected void selectuser() throws SQLException{
        jdbc();
        try {
            String sql = "select * from user";
//            pt = conn.prepareStatement(sql);
//            rs = pt.executeQuery(sql);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getString("u_id") + rs.getString("u_name") + rs.getString("u_password"));
            }
        }
        catch (SQLException e){
            System.out.println("222"+e.getMessage());
        }finally {
            if (rs != null){
                rs.close();
            }
            if (stmt != null){
                stmt.close();
            }
            if (conn != null){
                conn.close();
            }
        }
    }

    public static void main(String[] args) throws SQLException{
//        SwingUtilities.invokeLater(jdbc::selectuser);
        jdbc j = new jdbc() ;
        j.selectuser();
    }
}
