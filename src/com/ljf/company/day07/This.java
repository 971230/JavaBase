package com.ljf.company.day07;

/**
 * @Author 龙江锋
 * @Date 2021/3/5 17:48
 * @Version 1.0
 *
 * this关键字是对象内部指代自身的引用，不同对象不能共用一个this
 */
public class This {
    public static void main(String[] args) {
        //创建对象时会自动调用构造方法
        Dog dog = new Dog();
        Dog dog2 = new Dog("小旺旺");
    }
}

/**
 * this还可以在构造方法间相互调用
 * 但请一定注意:是单向的,不是双向来回调用,会死循环
 */
class Dog{
    /** 无参构造*/
    public Dog() {
        /*在无参构造中 调用含参构造的功能*/
        /*规定:this关键字必须在构造方法中的第一行*/
        this("旺财");
        System.out.println("无参构造");
        // this("123");
        // Call to 'this()' must be first statement in constructor body
    }

    /**含参构造*/
    public Dog(String s) {
        /*在含参构造中 调用无参构造的功能*/
        /*规定:this关键字必须在构造方法中的第一行*/
        //会去执行dog()无参构造方法里面的内容,再执行自己的内容
        //this();
        System.out.println("含参构造" + s);
    }
}
