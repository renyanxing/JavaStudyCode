package cn.renyx.demo04.Annotation;

@MyAnnotation01
@MyAnnotation02(a = 10,array = {"足球","篮球","乒乓球"})
public class UserAnnotation {
    @MyAnnotation01
    private String name;
    @MyAnnotation02(a=100,array = {"敲代码"})
    private int age;

    @MyAnnotation01
    public String getName() {
        return name;
    }

    @MyAnnotation03(value = '@')
    public void setName(String name) {
        this.name = name;
    }

    @MyAnnotation03('中')
    public int getAge() {
        return age;
    }

    @MyAnnotation01
    public void setAge(int age) {
        this.age = age;
    }
}
