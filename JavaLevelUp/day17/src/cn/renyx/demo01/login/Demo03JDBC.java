package cn.renyx.demo01.login;

import cn.renyx.Utils.JDBCUtils;
import org.junit.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo03JDBC {
    @Test
    public void testInsert() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pst = conn.prepareStatement("insert into users (username,password) values (?,?)");
        pst.setObject(1,"zhangsf");
        pst.setObject(2,"zhangsf");
        int i = pst.executeUpdate();
        System.out.println(i+"行数据添加成功！");
        JDBCUtils.close(null,pst,conn);


    }
    @Test
    public void testUpdate() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pst = conn.prepareStatement("update  users set password=? where username=?");
        pst.setObject(1,"000000");
        pst.setObject(2,"zhangsf");
        int i = pst.executeUpdate();
        System.out.println(i+"行数据修改成功！");
        JDBCUtils.close(null,pst,conn);
    }
    @Test
    public void testDelete() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pst = conn.prepareStatement("delete from users  where username=?");
        pst.setObject(1,"zhangsf");
        int i = pst.executeUpdate();
        System.out.println(i+"行数据删除成功！");
        JDBCUtils.close(null,pst,conn);
    }
}
