package com.renyx.threadLocal;

import com.renyx.utils.C3P0UtilsXML;

import java.sql.Connection;

public class Demo02ThreadLocal {
    public static void main(String[] args) {
        ThreadLocal<Connection> tl = new ThreadLocal<>();
        Connection conn1 = C3P0UtilsXML.getConnection();
        tl.set(conn1);
        Connection conn2 = tl.get();
        System.out.println(conn1);
        System.out.println(conn2);
        System.out.println(conn1 == conn2);

    }

}
