package cn.renyx.demo02.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo03Constructor {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("cn.renyx.demo02.Reflect.Person");
        Constructor[] cons1 = clazz.getConstructors();
        for (Constructor con : cons1) {
            System.out.println(con);
        }
        System.out.println("\r\n---------------------------------------------------------------\r\n");
        Constructor[] cons2 = clazz.getDeclaredConstructors();
        for (Constructor con : cons2) {
            System.out.println(con);

        }
        System.out.println("\r\n---------------------------------------------------------------\r\n");
        Constructor conNullPara = clazz.getConstructor();
        System.out.println(conNullPara);
        Object objNull = conNullPara.newInstance();
        System.out.println(objNull);
        System.out.println((Person) objNull);
        Constructor con2Para = clazz.getConstructor(String.class, int.class);
        System.out.println(con2Para);
        Object obj2Para = con2Para.newInstance("狗头老高", 18);
        System.out.println(obj2Para);
        Constructor conPriv = clazz.getDeclaredConstructor(String.class);
        System.out.println(conPriv);
        conPriv.setAccessible(true);
        Object objPriv = conPriv.newInstance("任彦行");
        System.out.println(objPriv);

    }
}
