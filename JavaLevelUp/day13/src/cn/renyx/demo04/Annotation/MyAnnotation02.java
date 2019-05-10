package cn.renyx.demo04.Annotation;

import java.lang.annotation.Annotation;

public @interface MyAnnotation02 {
    public abstract int a();

    public abstract double b() default 8.8;

    public abstract String[] array();

//    public abstract Person p();

//    public abstract Class clazz();
//
//    public abstract MyAnnotation01 my01();
//
//    public abstract Color c();
}
