package Dao;

import JDBC.Jdbc_Conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardDao extends Jdbc_Conn {
    //会员卡表

    ResultSet rs = null;
    PreparedStatement pt = null;

    //查询会员信息
    public Object[] selectCashCard(String card,String name) throws SQLException {
        jdbc();
        try {
            String selectCashCard_sql = "SELECT * from vipcard WHERE v_card = ? AND v_name = ?";
            pt = conn.prepareStatement(selectCashCard_sql);
            pt.setString(1,card);
            pt.setString(2,name);

            rs = pt.executeQuery();

            //将查询结果转换为Object数组
            Object[] result  = new Object[3];

            while (rs.next()){

                result[0] = rs.getString("v_card");
                result[1] = rs.getString("v_name");
                result[2] = rs.getString("v_integral");

            }

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Object[] selectCashCard(String card) throws SQLException {
        jdbc();
        try {
            String selectCashCard_sql = "SELECT * from vipcard WHERE v_card = ?";
            pt = conn.prepareStatement(selectCashCard_sql);
            pt.setString(1,card);

            rs = pt.executeQuery();

            //将查询结果转换为Object数组
            Object[] result  = new Object[3];

            while (rs.next()){

                result[0] = rs.getString("v_card");
                result[1] = rs.getString("v_name");
                result[2] = rs.getString("v_integral");

            }

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Object[] insertCardDao(String card) throws SQLException {
        jdbc();
        try {
            String selectCashCard_sql = "SELECT * from vipcard WHERE v_card = ?";
            pt = conn.prepareStatement(selectCashCard_sql);
            pt.setString(1,card);
            rs = pt.executeQuery();

            //将查询结果转换为Object数组
            Object[] result  = new Object[3];

            while (rs.next()){

                result[0] = rs.getString("v_card");
                result[1] = rs.getString("v_name");
                result[2] = rs.getString("v_integral");

            }

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public int insertCashCard(String id,String name) throws SQLException {
        jdbc();
        try {
            String insert_sql = "INSERT INTO vipcard (v_card,v_name,v_integral) VALUES (?,?,?)";
            pt = conn.prepareStatement(insert_sql);
            pt.setString(1,id);
            pt.setString(2,name);
            pt.setString(3,"0");
            int result = pt.executeUpdate();

            return result;


        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int updateIntegral(String vid,String integral) throws SQLException {

        jdbc();
        try {

            String update_sql = "UPDATE vipcard SET v_integral = ? WHERE v_card = ?";
            pt = conn.prepareStatement(update_sql);
            pt.setString(1, vid);
            pt.setString(2, integral);

            int result = pt.executeUpdate();

            return result;
        }
        catch (SQLException e){
            System.out.println("222"+e.getMessage());
            return -1;
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
