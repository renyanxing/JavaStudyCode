package com.renyx.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C3P0UtilsXML {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();



    public static Connection getConnection() {

        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            throw new RuntimeException("获取数据库连接失败：" + e);
        }

    }
    public static DataSource getDataSource(){
        return dataSource;
    }
    public static void close(ResultSet rs, Statement stat, Connection conn) {
        if (rs != null)
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (stat != null)
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
