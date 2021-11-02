package com.ljf.company.day10;

/**
 * @Author 龙江锋
 * @Date 2021/3/7 21:31
 * @Version 1.0
 *
 * 接口
 * 1.1引入
 * abstract class Animal{
 * public abstract void eat();
 * public abstract void sleep();
 * }
 *
 * class Dog extends Animal{
 * eat(){...}
 * }
 *
 * class Cat extends Animal{
 * eat(){...}
 * }
 *
 * class Pig extends Animal{
 * eat(){...}
 * }
 *
 * 1.2 概念
 * Java里面由于不允许多重继承,所以如果要实现多个类的功能,
 * 则可以通过实现多个接口来实现,Java接口和Java抽象类代表的就是抽象类型,
 * 就是我们需要提出的抽象层的具体表现
 * OOP面向对象编程,如果要提高程序的复用率,增加程序的可维护性,可扩展性,
 * 就必须是面向接口编程,面向抽象的变成,正确的使用接口/抽象类这些抽象类型作为java结构层次上的顶层.
 *
 * 1.3 接口格式
 * interface 接口名{ 代码… }
 *
 * 1.4 特点:
 * 1) 接口中都是抽象方法
 * 2) 通过interface关键字来定义接口
 * 3) 通过implements让子类来实现接口
 * 4) 可以理解成,接口是一个特殊的抽象类(接口里的方法都是抽象方法)
 * 5) 接口突破了java单继承的局限性
 * 6) 接口和类之间可以多实现,接口与接口之间可以多继承
 * 7) 接口是对外暴露的规则,是一套开发规范
 * 8) 接口提高了程序的功能拓展,降低了耦合性
 */
public interface Day10 {

    /* 2.接口中可以有普通方法吗?--不可以!!  public void eat() {} 不能用普通方法*/
    /** public abstract可以省略*/
    void eat();
    /**play*/
    void play();
    /*3.接口中可以有抽象方法吗?--可以,接口中的方法都是抽象方法!!!*/

    /**jdk1.8后可以有普通方法,加default*/
    default void run(){
        System.out.println("1");
    }
    /**加static*/
    static void study(){
        System.out.println("2");
    }
}
