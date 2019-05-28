package com.renyx.service;

import com.renyx.dao.AccountDao;
import com.renyx.utils.C3P0UtilsXML;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountService {
    public boolean Transfer(String fromName,String toName,double money){
        boolean flag=false;
        Connection conn=null;
        try {
            conn = C3P0UtilsXML.getConnection();
            conn.setAutoCommit(false);
            AccountDao accDao = new AccountDao();
            int row1 = accDao.fromAccount(conn, fromName, money);
            int row2 = accDao.toAccount(conn, toName, money);
            if (row1>0&&row2>0){
                flag=true;
                conn.commit();
            }
            else{
                conn.rollback();
            }

        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } finally {
            C3P0UtilsXML.close(null,null,conn);
            return flag;
        }



    }
}
