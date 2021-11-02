package com.ljf.company.day10;

/**
 * @Author 龙江锋
 * @Date 2021/3/11 11:02
 * @Version 1.0
 */
interface AA {
    void r();
}

class C{
    public static void d() {
        System.out.println("12");
    }
}
class B extends C implements AA {

    @Override
    public void r() {
        System.out.println("1");
    }
}

class D{
    public static void main(String[] args) {
        C i = new B();
        C.d();

        AA p = new B();
        p.r();
    }
}
