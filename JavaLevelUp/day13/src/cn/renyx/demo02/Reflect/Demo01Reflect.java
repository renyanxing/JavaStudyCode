package cn.renyx.demo02.Reflect;

public class Demo01Reflect {
    public static void main(String[] args) throws ClassNotFoundException {
        Person p=new Person();
        Class c1=p.getClass();
        System.out.println(c1);
        Class c2 = Person.class;
        System.out.println(c2);
        Class c3 = Class.forName("cn.renyx.demo02.Reflect.Person");
        System.out.println(c3);
    }
}
