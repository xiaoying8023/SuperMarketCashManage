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

}
