package Dao;

import JDBC.Jdbc_Conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CashDao extends Jdbc_Conn {
    //账单表
    //查询账单表，用作生成账单
    //插入账单表，用作数据库插入
    //更新会员卡表
    ResultSet rs = null;
    PreparedStatement pt = null;
    public Object[] selectCashCard(String cashId) throws SQLException {
        jdbc();
        try {
            String selectCashCard_sql = "SELECT * from bill WHERE s_card = ?";
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
    public int insertCard(String u_id,String v_card,String p_id,String p_num,String b_money,String b_discount,String s_card) throws SQLException {
        jdbc();
        try {
            String insert_sql = "INSERT INTO bill (u_id,v_card,p_id,p_num,b_money,b_discont,s_card,b_time) VALUES (?,?,?,?,?,?,?,?)";
            pt = conn.prepareStatement(insert_sql);
            pt.setString(1,u_id);
            pt.setString(2,v_card);
            pt.setString(3,p_id);
            pt.setString(4,p_num);
            pt.setString(5,b_money);
            pt.setString(6,b_discount);
            pt.setString(7,s_card);
            pt.setString(8, String.valueOf(LocalDateTime.now()));
            int result = pt.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
