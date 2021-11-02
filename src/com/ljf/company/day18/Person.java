package com.ljf.company.day18;

/**
 * @Author 龙江锋
 * @Date 2021/3/21 16:28
 * @Version 1.0
 *
 * 暴力反射
 * 指可以将程序中的私有的属性或者方法通过反射技术，暴力的获取到资源
 * 本类用来测试暴力反射*/

public class Person {

    /**1.提供私有属性*/
    private String name;
    private int age;

    /**2.提供私有方法*/
    private void save(int m , String n) {
        System.out.println("save().." + m + n);
    }

    private void update() {
        System.out.println("update()..");
    }
}
