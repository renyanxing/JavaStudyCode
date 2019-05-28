package cn.renyx.demo04DBUtils;

import cn.renyx.demo02.Utils.C3P0UtilsXML;
import cn.renyx.demo05.domain.Product;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Demo01DBUtils {
    @Test
    public void testInsert() throws SQLException {
        QueryRunner qr = new QueryRunner();
        Connection conn = C3P0UtilsXML.getConnection();
        String sql = "INSERT INTO product(pid,pname,price,category_id) VALUES(?,?,?,?)";
        int row = qr.update(conn, sql, 14, "优乐美", 3, "c005");
        System.out.println(row + "行数据添加成功");
        DbUtils.closeQuietly(conn);
    }

    @Test
    public void testUpdate() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0UtilsXML.getDataSource());
        int row = qr.update("update product set price=?,pname=? where pid=?", 4, "相约奶茶", 14);
        System.out.println(row + "行数据修改成功");

    }

    @Test
    public void testDelete() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0UtilsXML.getDataSource());
        int row = qr.update("delete from product where pid in (?,?,?,?)", 9, 10, 11, 14);
        System.out.println(row + "行数据删除成功");
    }

    @Test
    public void testBeanHandler() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0UtilsXML.getDataSource());
        Product p = qr.query("select * from product", new BeanHandler<>(Product.class));
        System.out.println(p);
    }

    @Test
    public void testBeanListHandler() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0UtilsXML.getDataSource());
        List<Product> list= qr.query("select * from product", new BeanListHandler<>(Product.class));
        for (Product product : list) {
            System.out.println(product);
        }

    }

    @Test
    public void testScalarHandler() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0UtilsXML.getDataSource());
        Object o = qr.query("select count(*) from product", new ScalarHandler());
//        Object o = qr.query("select pname from product where pid=?", new ScalarHandler(), 8);
        System.out.println(o);

    }
    @Test
    public void testColumnListHandler() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0UtilsXML.getDataSource());
        List<Object> list = qr.query("select * from product", new ColumnListHandler(2));
        for (Object o : list) {
            System.out.println(o);
        }


    }
}
