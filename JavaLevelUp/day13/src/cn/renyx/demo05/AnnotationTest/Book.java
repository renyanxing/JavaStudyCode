package cn.renyx.demo05.AnnotationTest;

public @interface Book {
    public abstract String name();

    public abstract double price() default 100.00;

    public abstract String[] authors();
}
