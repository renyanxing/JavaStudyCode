package cn.renyx.demo03.test;

import cn.renyx.demo02.Utils.C3P0Utils;
import cn.renyx.demo02.Utils.C3P0UtilsXML;
import org.junit.Test;

import java.sql.*;

public class TestC3P0Utils {
    @Test
    public void test01() throws SQLException {
        Connection conn = C3P0Utils.getConnection();
//        System.out.println(conn);
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("select * from users");
        while (rs.next()){
            System.out.println(rs.getInt("uid")+"\t"+rs.getString("username"));
        }
        C3P0Utils.close(rs,stat,conn);

    }
    @Test
    public void test02() throws SQLException {
        Connection conn = C3P0UtilsXML.getConnection();
//        System.out.println(conn);
        PreparedStatement stat = conn.prepareStatement("select * from users");
        ResultSet rs = stat.executeQuery();
        while (rs.next()){
            System.out.println(rs.getInt("uid")+"\t"+rs.getString("username"));
        }
        C3P0Utils.close(rs,stat,conn);
    }
}
