package com.ljf.company.day17;

/**
 * @Author 龙江锋
 * @Date 2021/3/21 15:37
 * @Version 1.0
 *
 * 单例设计模式
 * 4.1 概念
 * 单例模式可以说是大多数开发人员在实际中使用最多的，常见的Spring默认创建的bean就是单例模式的。
 * 单例模式有很多好处，比如可节约系统内存空间，控制资源的使用。
 * 其中单例模式最重要的：确保对象只有一个。
 * 简单来说，保证一个类在内存中的对象就一个。
 * RunTime就是典型的单例设计，我们通过对RunTime类的分析，一窥究竟。
 *
 * 底层的实现思路一共分为了3个步骤:
 * ①、对本类构造方法私有化,防止外部调用构造方法创建对象
 * ②、创建全局唯一的对象,也做私有化处理
 * ③、通过自定义的公共方法将创建好的对象返回(类似封装属性后的getXxx() )
 *
 * 本类用于测试单例设计模式1-饿汉式
 */
public class SingleTon {

    public static void main(String[] args) {

        //通过类名直接调用返回对象的方法
        MySingle single = MySingle.getSingle();
        MySingle single2 = MySingle.getSingle();

        //测试获取到的这两个引用类型变量是否相等
        //true,==比较的是地址值
        System.out.println(single == single2);
        System.out.println(single);
        System.out.println(single2);
    }
}

/**0.创建自己的单例程序*/
class MySingle{

    /**①、提供构造方法,并将构造方法私有化(构造方法私有化的目的:不让外界随意实例化/new本类对象)*/
    private MySingle() {}

    /**②、在类的内部,创建本类对象,并且把对象私有化
          (本资源也用static进行修饰,因为静态资源getSingle()只能调用静态资源)*/
    private static MySingle single = new MySingle(){};

    /*
     * 也就是以公共的方式向外界提供本类对象
     * 思考:对象创建好并且用公共的方式返回,那么此公共方法外界该如何调用呢?
     * 之前我们都是在外部创建好本类,通过对象进行调用的,但是现在外界无法创建本类对象
     * 解决方案:我们可以利用之前学习的静态的概念,被static关键字修饰的资源可以通过类名直接调用
     */

    /**③、对外提供一个全局访问点(用static关键字来修饰本方法,后续可以通过类名调用)*/
    public static MySingle getSingle() {
        //④、把内部创建好的对象返回到调用位置
        return single;
    }
}
