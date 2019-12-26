package Dao;

import JDBC.Jdbc_Conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CashCardDao extends Jdbc_Conn {
    //购物卡表

    ResultSet rs = null;
    PreparedStatement pt = null;

    //查询购物卡信息
    public Object[] selectCashCard(String cashId) throws SQLException {
        jdbc();
        try {
            String selectCashCard_sql = "SELECT * from shopcard WHERE s_card = ?";
            pt = conn.prepareStatement(selectCashCard_sql);
            pt.setString(1,cashId);
            rs = pt.executeQuery();
            //将查询结果转换为Object数组
            Object[] result  = new Object[3];
            while (rs.next()){
                result[0] = rs.getString("s_card");
                result[1] = rs.getString("v_card");
                result[2] = rs.getString("s_money");
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //购物卡充值
    public int updateMoney(String cashcard,String money) throws SQLException {
        jdbc();
        try {
            String update_sql = "UPDATE shopcard SET s_money = ? WHERE s_card = ?";
            pt = conn.prepareStatement(update_sql);
            pt.setString(1,money);
            pt.setString(2,cashcard);
            int result = pt.executeUpdate();

            return result;


        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }


    }

    //办理无会员卡的购物卡
    public int insertCashCard(String card) throws SQLException {
        jdbc();
        try {
            String insert_sql = "INSERT INTO shopcard (s_card,s_money) VALUES (?,?)";
            pt = conn.prepareStatement(insert_sql);
            pt.setString(1,card);
            pt.setString(2,"0");
            int result = pt.executeUpdate();

            return result;


        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    //办理有会员卡的购物卡
    public int insertCashCard(String card,String vipcard) throws SQLException {
        jdbc();
        try {
            String insert_sql = "INSERT INTO shopcard (s_card,v_card,s_money) VALUES (?,?,?)";
            pt = conn.prepareStatement(insert_sql);
            pt.setString(1,card);
            pt.setString(2,vipcard);
            pt.setString(3,"0");
            int result = pt.executeUpdate();

            return result;


        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
