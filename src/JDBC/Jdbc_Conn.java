package JDBC;

import java.sql.*;

public class Jdbc_Conn {
    public Connection conn = null;
//    ResultSet rs = null;
////    Statement stmt = null;
//    PreparedStatement pt = null;
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

    //    public static void main(String[] args) throws SQLException, ParseException {
////        SwingUtilities.invokeLater(jdbc::selectuser);
//        jdbc j = new jdbc() ;
////        String time = LocalDate.now().toString();
////        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
////        Date gettime = (Date) sdf.parse(time);
////        System.out.println(gettime);
////        j.intoproduct("11001001","卫生纸",9.90,50, LocalDate.now().toString());
//        j.selectProduct("11001001","卫生纸");
//        //
//    }
}
