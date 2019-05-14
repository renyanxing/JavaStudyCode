package cn.renyx.Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;

public class C3P0Utils {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    static {
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/day17");
            dataSource.setUser("root");
            dataSource.setPassword("root");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {

        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            throw new RuntimeException("获取数据库连接失败：" + e);
        }

    }
}
