package cn.renyx.demo02.Reflect;

import java.lang.reflect.Method;

public class Demo05Method {
    public static void main(String[] args) throws Exception {
        Class clazz = Person.class;
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m
            );
        }
        System.out.println("--------------------------------------------------------------------");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {

            System.out.println(method);
        }
        System.out.println("--------------------------------------------------------------------");
        Method getNameMethod = clazz.getMethod("getName");
        System.out.println(getNameMethod);
        Method setNameMethod = clazz.getMethod("setName", String.class);
        System.out.println(setNameMethod);
        Method privMethod = clazz.getDeclaredMethod("method");
        System.out.println(privMethod);
        System.out.println("--------------------------------------------------------------------");
        Person obj = (Person) clazz.newInstance();
        Object v1 = getNameMethod.invoke(obj);
        System.out.println("v1:" + v1);
        Object v2 = setNameMethod.invoke(obj, "小龙女");
        System.out.println("v2:" + v2);
        System.out.println(obj);
        v1 = getNameMethod.invoke(obj);
        System.out.println("v1:" + v1);
        privMethod.setAccessible(true);
        Object v3 = privMethod.invoke(obj);


    }
}
