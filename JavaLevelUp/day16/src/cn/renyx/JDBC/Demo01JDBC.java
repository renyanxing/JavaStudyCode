package cn.renyx.JDBC;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class Demo01JDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/day16", "root", "root");
        Statement state = conn.createStatement();
        ResultSet resultSet = state.executeQuery("SELECT * FROM  t_user");
        while (resultSet.next()) {
            System.out.println("name:" + resultSet.getString(2) + " age:" + resultSet.getInt(3));
        }

        state.close();
        conn.close();

    }
}
