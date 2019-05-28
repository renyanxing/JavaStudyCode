package com.renyx.threadLocal;

public class Demo01ThreadLocal {
    public static void main(String[] args) {
        ThreadLocal<String> tl = new ThreadLocal<String>();
        tl.set(Thread.currentThread().getName()+"-->添加数据");
        String s = tl.get();
        System.out.println(s);
        new Thread(new Runnable() {
            @Override
            public void run() {
                tl.set(Thread.currentThread().getName()+"-->添加数据");
                System.out.println(tl.get());
            }
        }).start();



    }
}
