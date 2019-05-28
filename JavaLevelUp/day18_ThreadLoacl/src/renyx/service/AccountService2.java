package renyx.service;


import renyx.dao.AccountDao;
import renyx.utils.C3P0UtilsXMLTL;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountService2 {
    public boolean Transfer(String fromName,String toName,double money){
        boolean flag=false;
        Connection conn=null;
        try {
            conn = C3P0UtilsXMLTL.getConnection();
            conn.setAutoCommit(false);
            AccountDao accDao = new AccountDao();
            int row1 = accDao.fromAccount(fromName, money);

            int row2 = accDao.toAccount(toName, money);
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
            C3P0UtilsXMLTL.close(null,null,conn);
            return flag;
        }



    }
}
