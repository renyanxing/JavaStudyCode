package cn.renyx.demo05.AnnotationTest;

import java.lang.reflect.Method;

@Book(name = "java编程思想", authors = "Bruce Eckel")
public class UserBook {
    @Book(name = "钢铁是怎样炼成的", authors = "保尔")
    private String name;

    @Book(name = "盗墓笔记", authors = "南派三叔", price = 250)
    public void method() {
    }
}
