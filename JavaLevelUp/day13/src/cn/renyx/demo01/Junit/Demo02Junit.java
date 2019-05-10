package cn.renyx.demo01.Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Demo02Junit {
    @Test
    public void test01() {
        System.out.println("mytest01");
    }

    @Test
    public void test02() {
        System.out.println("mytest02");
    }

    @Test
    public void test03() {
        System.out.println("mytest03");
    }

    @Before
    public void mybefore() {
        System.out.println("mytbefore");
    }

    @After
    public void myafter() {
        System.out.println("myafter");
    }
}
