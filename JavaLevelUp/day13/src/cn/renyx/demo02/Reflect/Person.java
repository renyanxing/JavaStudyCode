package cn.renyx.demo02.Reflect;

public class Person {
    private String name;


    private int age;

    static {
        System.out.println("静态代码块");
    }

    public Person() {
        System.out.println("Person类的空参构造方法");
    }

    private Person(String name) {
        System.out.println("Person类的私有构造方法");
        this.name = name;
    }

    public Person(String name, int age) {
        System.out.println("Person类的满参构造方法");
        this.name = name;
        this.age = age;
    }

    private void method() {
        System.out.println("Person类的私有方法");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    @Override
//    public String toString() {
//        return "Person{name='" + this.name + "',age=" + this.age + "}";
//    }
}
