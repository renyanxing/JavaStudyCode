package cn.renyx.demo01.transferAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01JDBC {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stat=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/day18","root","root");
            conn.setAutoCommit(false);
            stat = conn.createStatement();
            int row1 = stat.executeUpdate("update account set money=money-1000 where name='jack'");
            int row2 = stat.executeUpdate("update account set money=money+1000 where name='rose'");
            if (row1>0&&row1>0)
                System.out.println("转账成功");
        conn.commit();

        } catch (Exception e) {
            System.out.println("转账失败");
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        finally {
            try {
                if (stat!=null)
                    stat.close();
                if (conn!=null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
