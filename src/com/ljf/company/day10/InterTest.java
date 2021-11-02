package com.ljf.company.day10;

/**
 * @Author 龙江锋
 * @Date 2021/3/8 22:29
 * @Version 1.0
 */
public class InterTest {

    /** 1.创建入口函数main()*/
    public static void main(String[] args) {

        //2.接口可以创建多态对象
        Day10 inter = new InterImpl();
        inter.eat();
        inter.play();
        //3.接口可以创建对象吗?--不可以!!!!
        //new Day10();
        InterImpl i = new InterImpl();
        i.eat();
        i.play();
    }
}
