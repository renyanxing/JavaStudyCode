package cn.renyx.demo02.Reflect;

import java.io.IOException;

public class Demo04Constructor {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("cn.renyx.demo02.Reflect.Person");
        Object obj = clazz.newInstance();
        System.out.println(obj);

    }
}
