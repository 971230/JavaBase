package com.ljf.company.day08;

/**
 * @Author 龙江锋
 * @Date 2021/3/7 20:06
 * @Version 1.0
 *
 * 静态代码块、构造代码块、局部代码块
 * 1 静态代码块格式
 *   static {}
 *
 * 静态资源随着类的加载而加载，并且只被加载一次，一般用于项目的初始化
 * 特点: 被static修饰,位置在类里方法外
 *
 * 2 三种代码块的比较
 * 1) 静态代码块：在类加载时就加载，并且只被加载一次，一般用于项目的初始化
 * 2) 构造代码块：在创建对象时会自动调用，每次创建对象都会被调用,提取构造共性
 * 3) 局部代码块：方法里的代码块,限制局部变量的范围
 ************************************************************************
 * 本类用于测试代码块之间的关系
 *
 * 总结:
 * 1.代码块之间的执行顺序:静态代码块 --> 构造代码块 --> 构造方法 --> 局部代码块
 * 2.为什么是这样的顺序呢?
 * 3.原因:
 * 3.1)静态代码块优先于对象加载,是随着类的加载就会第一时间加载进入内存,并且一直存在,
 *     直到类消失它才会消失
 * 3.1.1)作用:专门用来完成一些需要第一时间加载并且只加载一次的资源
 * 3.2)构造代码块是在创建对象时才会触发,专门用来提取构造方法的共性
 * 3.3)局部代码块是在方法调用时才触发,专门用来控制变量的作用范围
 */
public class Block {
    static {
        System.out.println("公共类的静态代码块，只加载一次");
    }

    public static void main(String[] args) {

        //7.创建对象进行测试
        /*1.在创建对象前,会自动执行静态代码块,而且此代码块只加载一次*/
        /*2.在创建对象时,会自动调用构造代码块和构造方法*/
        Person p = new Person();

        /*3.当调用方法时,如果方法中有局部代码块,才会执行局部代码块*/
        p.study();
        System.out.println("******************************");

        //8.再次创建一次对象进行测试
        //再去创建对象,静态代码块也不会再次加载了
        Person p2 = new Person();
        p2.study();
    }
}

/**1.创建Person类*/
class Person {

    //2.创建静态代码块
    /*位置:类里方法外 + 触发节点: 随着类的加载而加载,只加载一次*/
    static {
        System.out.println("我是静态代码块~只加载一次");
    }

    //3.创建构造代码块
    /*位置:类里方法外 + 触发节点:创建对象时立即执行*/
    {
        System.out.println("我是构造代码块~");
    }

    /**4.创建构造方法*/
    public Person() {
        System.out.println("我是Person类的无参构造方法");
    }

    /**5.创建普通方法*/
    public void study() {
        System.out.println("我是普通方法~");
        //6.创建局部代码块
        /*位置:方法里 + 触发节点:调用此方法时*/
        {
            System.out.println("我是局部代码块~");
        }
    }
}


class A{
    static {
        System.out.println("①父类的静态代码块");
    }
    {
        System.out.println("③父类构造代码块");
    }
    public A(){
        System.out.println("④父类构造方法");
    }
    public void eat(){
        System.out.println("父类普通方法");
        {
            System.out.println("父类局部代码块");
        }
    }
}

class B extends A{
    static {
        System.out.println("②子类的静态代码块");
    }
    {
        System.out.println("⑤子类构造代码块");
    }
    public B(){
        System.out.println("⑥子类构造方法");
    }

    @Override
    public void eat(){
        System.out.println("⑦子类普通方法");
        {
            System.out.println("⑧子类局部代码块");
        }
    }
}
