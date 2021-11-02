package com.ljf.company.day07;

/**
 * @Author 龙江锋
 * @Date 2021/3/5 20:07
 * @Version 1.0
 *
 * 继承
 * 1 概念
 * 继承是面向对象最显著的一个特征
 * 继承是从已有的类中派生出新的类,新的类能吸收已有类的数据属性和行为,并扩展新的能力.
 * Java继承是会用已存在的类的定义作为基础建立新类的技术
 * 新类的定义可以增加新的数据或者新的功能,也可以使用父类的功能,但不能选择性的继承父类(超类/基类)
 * 这种继承使得复用以前的代码非常容易,能够大大的缩短开发的周期,降低开发费用.
 *
 * 2 特点
 * 1) 使用extends关键字来表示继承关系
 * 2) 相当于子类把父类的功能复制了一份
 * 3) Java只支持单继承
 * 4) 继承可以传递(爷爷/儿子/孙子这样的关系)
 * 5) 不能继承父类的私有成员
 * 6) 继承多用于功能的修改,子类可以在拥有父类功能的同时,进行功能拓展
 * 7) 像是is a的关系
 */
public class Extends {
    public static void main(String[] args) {
        //创建Cat对象进行测试
        Cat c = new Cat();
        c.eat();
        //创建DingDang对象进行测试
        DingDang d = new DingDang();
        d.eat();
        d.print();
        //System.out.println(d.b);//'b' has private access in 'com.ljf.company.day07.Cat'
    }
}


/** 1.创建父类Animal-爷爷类*/
class Animal{
    /** 2.定义一个父类中的普通方法*/
    public void eat() {
        System.out.println("吃啥都行~");
    }
}


//3.创建Animal类的子类Cat--爸爸类
/* 1.子类与父类是继承关系,用extends关键字来表示/连接*/
/**2.java只支持单继承,一个子类只能有一个父类,一个父类可以有多个子类*/
class Cat extends Animal{
    /** 5.定义属性*/
    int a = 10;
    /** 5.父类的私有资源,子类无法继承*/
    int b = 100;
}


/*6.继承是is a的关系,要求子类必须是父类的一种继承结构,依赖性非常强,强耦合*/
//4.创建Cat类的子类DingDang--儿子类
/**4.继承具有传递性,爷爷的功能会传给爸爸,爸爸的功能会传给儿子*/
class DingDang extends Cat{
    /** 6.在孙子类中定义打印的方法*/
    public void print() {
        /*3.子类集成父类以后,相当于把父类的功能进行了复制*/
        //子类可以打印父类的公有属性a
        System.out.println(a);
        //System.out.println(sum);//子类不可以打印父类的私有属性sum
    }
}
