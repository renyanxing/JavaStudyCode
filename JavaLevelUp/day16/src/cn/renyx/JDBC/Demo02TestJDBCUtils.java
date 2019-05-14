package cn.renyx.JDBC;

import cn.renyx.Utils.JDBCUtils;

import java.sql.Connection;

public class Demo02TestJDBCUtils {
    public static void main(String[] args) {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);

    }
}
