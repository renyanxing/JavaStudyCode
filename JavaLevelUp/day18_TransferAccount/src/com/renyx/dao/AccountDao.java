package com.renyx.dao;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountDao {
    public int fromAccount(Connection conn,String fromName,double money) throws SQLException {
        QueryRunner qr = new QueryRunner();
        int row = qr.update(conn, "update account set money=money-? where name=?",money,fromName);
        return row;
    }
    public int toAccount(Connection conn,String toName,double money) throws SQLException {
        QueryRunner qr = new QueryRunner();
        int row = qr.update(conn, "update account set money=money+? where name=?",money,toName);
        return row;
    }
}
