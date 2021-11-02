package com.ljf.company.day06;

/**
 * @Author 龙江锋
 * @Date 2021/3/5 19:19
 * @Version 1.0
 */
public class A {

    B demo = new B();
    C demo2 = new C();
    D demo3 = new D();

    class B{ }

    static class C{ }
}

class D{
    A.C demo4 = new A.C();
}

