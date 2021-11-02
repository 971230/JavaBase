package com.ljf.company.day19;

/**
 * @Author 龙江锋
 * @Date 2021/3/21 16:44
 * @Version 1.0
 *
 * 匿名内部类
 * 匿名内部类属于局部内部类,而且是没有名字的局部内部类,通常和匿名对象一起使用
 * 优势：方便，优化程序设计结构
 * 劣势：只能调用一个,且只能调用一次
 *
 * new 对象名() + {...}; 匿名对象+匿名内部类
 */
public class Inner5 {
    public static void main(String[] args) {

        /*接口可以创建对象吗?不可以!!!*/
        //new Inner1();//接口不能创建对象

        //③.  new Inner1(){...}; 匿名对象
        /*就相当于创建了一个接口的实现类 + 重写接口中的所有抽象方法*/
        new Inners1() {//a、接口的实现类

            @Override
            public void save() {//重写接口中的抽象方法1
                System.out.println("我是Inner1接口的save()");
            }

            @Override
            public void get() {//重写接口中的抽象方法2
                System.out.println("我是Inner1接口的get()");
            }
        }.get();//b、触发指定的重写后的方法,只能调用一个,且只能调用一次
        /*注意!!!匿名对象只干一件事!!!*/

        /* *********************************************************************/

        //⑤. new Inner2(){...}; 匿名对象,相当于创建了抽象类的子类,必须重写所有抽象方法
        new Inners2() {
            @Override
            public void eat() {
                System.out.println("我是Inner2抽象类的eat()");
            }
        }.eat();

        /* *********************************************************************/

        //⑦.普通类的匿名对象,没有强制要求产生匿名内部类的重写方法
        new Inners3(){
            @Override
            public void game() {
                System.out.println();
            }

            @Override
            public void sleep() {
                System.out.println();
            }
        };
        //如果使用对象,只需要干一件事--直接创建匿名对象,简单方便
        new Inners3().sleep();
        //如果使用同一个对象,要干很多事情--必须给对象起名字
        Inners3 in = new Inners3();
        in.game();
        in.sleep();
    }
}

/**
 * ①.创建接口
 */
interface Inners1 {

    /**
     * ②.定义接口中的抽象方法
     */
    void get();
    void save();
}

/**
 * ④.创建抽象类
 */
abstract class Inners2 {

    public abstract void eat();

    public void play() {
        System.out.println("我是Inner2抽象类的play()");
    }
}

/**
 * ⑥.创建普通类
 */
class Inners3 {
    public void game() {
        System.out.println("我是Inner3普通类的game()");
    }

    public void sleep() {
        System.out.println("我是Inner3普通类的sleep()");
    }
}