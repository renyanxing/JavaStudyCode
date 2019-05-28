package renyx.dao;

import org.apache.commons.dbutils.QueryRunner;
import renyx.utils.C3P0UtilsXMLTL;

import java.sql.SQLException;

public class AccountDao {
    public int fromAccount(String fromName,double money) throws SQLException {
        QueryRunner qr = new QueryRunner();
        int row = qr.update(C3P0UtilsXMLTL.getConnection(), "update account set money=money-? where name=?",money,fromName);
        return row;
    }
    public int toAccount(String toName,double money) throws SQLException {
        QueryRunner qr = new QueryRunner();
        int row = qr.update(C3P0UtilsXMLTL.getConnection(), "update account set money=money+? where name=?",money,toName);
        return row;
    }
}
