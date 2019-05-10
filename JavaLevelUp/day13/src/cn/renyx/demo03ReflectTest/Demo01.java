package cn.renyx.demo03ReflectTest;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

public class Demo01 {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.load(new FileReader("day13\\prop.txt"));
        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");
        Class clazz = Class.forName(className);
        Object obj = clazz.newInstance();
        Method method = clazz.getMethod(methodName);
        method.invoke(obj);
    }
}
