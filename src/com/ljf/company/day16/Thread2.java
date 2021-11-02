package com.ljf.company.day16;

/**
 * @Author 龙江锋
 * @Date 2021/3/19 13:50
 * @Version 1.0
 *
 * 如果自己的类已经extends另一个类,就无法多继承,此时,可以实现一个Runnable接口
 *
 * 5.2 常用方法
 * void run()使用实现接口Runnable的对象创建线程时,启动该线程将导致在独立执行的线程中调用对象的run()方法
 *
 * 创建线程方法二：
 *  * 覆写Runnable()接口实现多线程，而后同样覆写run().推荐此方式
 *  *
 *  * ①.覆写Runnable接口实现多线程可以避免单继承局限
 *  * ②.当子类实现Runnable接口，此时子类和Thread的代理模式
 *  * （子类负责真是业务的操作，thread负责资源调度与线程创建辅助真实业务。
 *  *
 *  *
 *    继承Thread和实现Runnable接口的区别：
 *      a.实现Runnable接口避免多继承局限
 *      b.实现Runnable()可以更好的体现共享的概念
 */
public class Thread2 {
    public static void main(String[] args) {
        //4.创建线程对象
        MyRunnable target = new MyRunnable();
        //5.2 问题:怎么把接口的实现类和Thread类绑定:接口没有start()方法
        Thread thread1 = new Thread(target);

        //5.1如何启动线程?
        thread1.start();

        //6.--以多线程编程的方式启动,需要创建多个线程对象并启动
        //8.使用指定的构造函数修改线程的名称--使用Thread类的含参构造
        Thread thread2 = new Thread(target,"杰克");
        Thread thread3 = new Thread(target,"露丝");
        thread2.start();
        thread3.start();

        //7.自己测试start()和run()的区别
        //run()只是一个普通方法执行的效果,也就是单线程顺序执行的效果,没有多线程的线现象
    }
}

/**1.自定义多线程类,方式2 implements Runnable*/
class MyRunnable implements Runnable{
    static int a = 10;

    /** 2.把业务放入run(),重写了Runnable接口里的*/
    @Override
    public void run() {
        //3.写业务,打印10次线程名称
        for(int i = 0; i < a; i++){
            //问题:Runnable接口中,没有提供多余的方法维度只有一个run()
            //Thread.currentThread()获取当前正在执行业务的线程对象 getName()获取此线程对象的名称
            System.out.println(i + "=" + Thread.currentThread().getName());
        }
    }
}
