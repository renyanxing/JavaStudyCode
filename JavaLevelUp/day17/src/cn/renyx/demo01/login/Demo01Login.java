package cn.renyx.demo01.login;

import cn.renyx.demo02.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo01Login {


    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();//asdasdwq' or '1=1    SQL注入
        Connection conn = JDBCUtils.getConnection();
        Statement stat = conn.createStatement();
        String sql = "select * from users where username='" + username + "' and password='" + password + "'";
        ResultSet rs = stat.executeQuery(sql);
        if (rs.next())
            System.out.println("登录成功！");
        else
            System.out.println("用户名密码错误！");
        JDBCUtils.close(rs, stat, conn);

    }
}
