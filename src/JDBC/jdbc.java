package JDBC;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Jdbc_Conn {
    Connection conn = null;
    ResultSet rs = null;
    Statement stmt = null;
    PreparedStatement pt = null;
    protected void jdbc() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/supermarket?useSSL=false&serverTimezone=GMT&characterEncoding=UTF-8";
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

    //根据用户查询信息
    public ArrayList selectuser(String jobNum, String pwd) throws SQLException{
        jdbc();

        try {
            //将查询结果放入ResultSet
            String sql = "SELECT * FROM user WHERE u_id = ? AND u_password = ?";
            pt = conn.prepareStatement(sql);
            pt.setString(1,jobNum);
            pt.setString(2,pwd);
            rs = pt.executeQuery();

//            String sql = "SELECT * FROM user WHERE u_id = '" + jobNum + "' AND u_password = '" + pwd + "'";
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery(sql);

            //将ResultSet的结果集转存为list返回
            ArrayList lists = new ArrayList();
            ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
            int columnCount = md.getColumnCount();//得到数据集的列数

            while (rs.next()) {//数据集不为空
                HashMap rowData = new HashMap();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnName(i), rs.getObject(i));
                }
                lists.add(rowData);
            }

            return lists;
        }
        catch (SQLException e){
            System.out.println("222"+e.getMessage());
            return null;
        }
        finally {

            if (rs != null){
                rs.close();
            }
            if (pt != null){
                pt.close();
            }
            if (conn != null){
                conn.close();
            }
        }
    }

    public int insertuser(String no,String name,String pwd) throws SQLException{
        jdbc();

        try {
            String insert_sql = "INSERT INTO user (u_id,u_name,u_password) VALUES (?,?,?)";
            pt = conn.prepareStatement(insert_sql);
            pt.setString(1,no);
            pt.setString(2,name);
            pt.setString(3,pwd);
            int res = pt.executeUpdate();

            System.out.println(res);

            return res;

            //将查询结果放入ResultSet
//            String select_sql = "SELECT * FROM user WHERE u_id = ? AND u_password = ?";
//            pt = conn.prepareStatement(select_sql);
//            pt.setString(1,name);
//            pt.setString(2,pwd);
//            rs = pt.executeQuery();

            //将ResultSet的结果集转存为list返回
//            ArrayList lists = new ArrayList();
//            ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
//            int columnCount = md.getColumnCount();//得到数据集的列数
//
//            while (rs.next()) {//数据集不为空
//                HashMap rowData = new HashMap();
//                for (int i = 1; i <= columnCount; i++) {
//                    rowData.put(md.getColumnName(i), rs.getObject(i));
//                }
//                lists.add(rowData);
//            }
//
//            return lists;
        }
        catch (SQLException e){
            System.out.println("222"+e.getMessage());
            return -100;
        }
        finally {

            if (rs != null){
                rs.close();
            }
            if (pt != null){
                pt.close();
            }
            if (conn != null){
                conn.close();
            }
        }
    }

//    public static void main(String[] args) throws SQLException{
////        SwingUtilities.invokeLater(jdbc::selectuser);
//        jdbc j = new jdbc() ;
//        j.insertuser("eeee","eeee");
//    }
}
