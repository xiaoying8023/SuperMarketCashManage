package Dao;

import java.sql.*;
import java.util.HashMap;

public class GoodsDao extends JDBC.Jdbc_Conn{
    //货物表

    ResultSet rs = null;
    PreparedStatement pt = null;

    //商品查询
    public HashMap selectProduct(String name) throws SQLException {

        jdbc();
        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
//            Date gettime = (Date) sdf.parse(time);

            String select_sql = "SELECT * FROM product WHERE p_name = ?";
            pt = conn.prepareStatement(select_sql);
            pt.setString(1,name);

            rs = pt.executeQuery();

            ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
            int columnCount = md.getColumnCount();//得到数据集的列数

            HashMap rowData = new HashMap();

            while (rs.next()) {//数据集不为空
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnName(i), rs.getObject(i));
                }
            }

            return rowData;

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

    //商品信息更新
    public int updateProduct(String price,String stock,String time) throws SQLException {

        jdbc();
        try {

            String select_sql = "UPDATE product SET p_pricce = ?,p_stock = ?,p_gettime = ?";
            pt = conn.prepareStatement(select_sql);
            pt.setString(1, price);
            pt.setString(2, stock);
            pt.setString(3,time);



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

        return 0;
    }

    public int insertProduct(String id,String name,String price,String stock,String time){
        return 0;
    }
}
