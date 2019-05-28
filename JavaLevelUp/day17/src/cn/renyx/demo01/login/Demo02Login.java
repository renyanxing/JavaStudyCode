package cn.renyx.demo01.login;

import cn.renyx.demo02.Utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class Demo02Login {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();//asdasdwq' or '1=1    SQL注入
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from users where username = ? and password = ?";
        PreparedStatement pstat = conn.prepareStatement(sql);
        pstat.setObject(1, username);
        pstat.setObject(2, password);
        ResultSet rs = pstat.executeQuery();
        if (rs.next())
            System.out.println("登陆成功！");
        else
            System.out.println("用户名密码错误！");
        JDBCUtils.close(rs, pstat, conn);
    }
}
