package cn.renyx.demo01.Junit;


import org.junit.Test;

public class Demo01Junit {
    @Test
    public void test01() {
        System.out.println("test01");
    }
    //以下方法不能执行
    /*@Test
    private void test02() {
        System.out.println("test02");
    }

    @Test
    public void test03(String s) {
        System.out.println(s);
    }

    @Test
    public int test04() {
        System.out.println("test04");
        return 1;
    }*/
}
