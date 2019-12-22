package Dao;

import JDBC.Jdbc_Conn;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class UserDao extends JDBC.Jdbc_Conn{
    //收银员表

    ResultSet rs = null;
    PreparedStatement pt = null;

    //根据用户查询信息
    public ArrayList selectUser(String jobNum, String pwd) throws SQLException {

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

    //新建用户
    public int insertUser(String no,String name,String pwd) throws SQLException{

        try {
            String insert_sql = "INSERT INTO user (u_id,u_name,u_password) VALUES (?,?,?)";
            pt = conn.prepareStatement(insert_sql);
            pt.setString(1,no);
            pt.setString(2,name);
            pt.setString(3,pwd);
            int res = pt.executeUpdate();

            System.out.println(res);

            return res;
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
}
