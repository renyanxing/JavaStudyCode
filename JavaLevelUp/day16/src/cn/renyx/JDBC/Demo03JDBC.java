package cn.renyx.JDBC;

import cn.renyx.demo02.Utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo03JDBC {
    @Test
    public void testInsert() {
        Statement stat = null;
        Connection conn = JDBCUtils.getConnection();
        try {
            stat = conn.createStatement();
            int i = stat.executeUpdate("insert into t_user (uname,uage,username,password) values ('任彦行',18,'renyx','renyx')");
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, stat, conn);
        }

    }

    @Test
    public void testSelect() {
        Connection conn = JDBCUtils.getConnection();
        Statement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from t_user");
            while (rs.next()) {
                System.out.println("uname:" + rs.getString(2) + " age:" + rs.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stat, conn);
        }


    }
    @Test
    public void testSelectRow(){
        Connection conn = JDBCUtils.getConnection();
        Statement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from t_user where uname='任彦行'");
//            rs = stat.executeQuery("select * from t_user where uname='张三'");
            if (rs.next()) {
                System.out.println("uname:" + rs.getString(2) + " age:" + rs.getInt(3));
            }
            else {
                System.out.println("结果不存在！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stat, conn);
        }
    }


}
