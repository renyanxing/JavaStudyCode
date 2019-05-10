package cn.renyx.demo06Annotation;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

@Book(name = "java编程思想", authors = "Bruce Eckel")
public class ParseAnnotation {
    @Book(name = "盗墓笔记", authors = "南派三叔", price = 250)
    public void method() {

    }
    @Test
    public void parseMethodAnnotation(){
        Class<ParseAnnotation> clazz = ParseAnnotation.class;
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
//            System.out.println(m.getName() );
            boolean b = m.isAnnotationPresent(Book.class);
            //System.out.println(m.getName()+"-->"+b);
            if (b){
                Book book = m.getAnnotation(Book.class);
                System.out.println(book.name());
                System.out.println(book.price());
                System.out.println(Arrays.toString(book.authors()));
            }
        }
    }

    @Test
    public void parseClassAnnotation() {

        Class<ParseAnnotation> clazz = ParseAnnotation.class;
        boolean b = clazz.isAnnotationPresent(Book.class);
        System.out.println(b);
        if (b) {
            Book book = clazz.getAnnotation(Book.class);
            System.out.println(book);
            System.out.println(book.name());
            System.out.println(book.price());
            System.out.println(Arrays.toString(book.authors()));
        }


    }
}
