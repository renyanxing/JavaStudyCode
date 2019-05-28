package cn.renyx.demo01.transferAccount;

import cn.renyx.demo02.utils.C3P0UtilsXML;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class Demo02DbUtils {
    public static void main(String[] args) {
        QueryRunner qr = new QueryRunner();
        Connection conn = C3P0UtilsXML.getConnection();
        try {
            conn.setAutoCommit(false);
            int row1 = qr.update(conn, "update account set money=money-1000 where name='jack'");
            int row2 = qr.update(conn, "update account set money=money+1000 where name='rose'");
            if (row1>0&&row2>0)
            {
                System.out.println("转账成功！");
                conn.commit();
            }
            else
                {
                    System.out.println("转账失败！");
                }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("转账失败！");
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        finally {
            DbUtils.closeQuietly(conn);
        }
    }
}
