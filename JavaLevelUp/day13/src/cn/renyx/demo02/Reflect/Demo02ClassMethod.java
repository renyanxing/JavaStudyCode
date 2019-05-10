package cn.renyx.demo02.Reflect;

public class Demo02ClassMethod {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("cn.renyx.demo02.Reflect.Person");
        String simpleName = clazz.getSimpleName();
        System.out.println(simpleName);
        System.out.println(clazz.getName());
    }
}
