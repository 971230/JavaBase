package com.ljf.company.day16.createthread;

/**
 * @author 龙江锋
 *
 *创建线程方法二：
 * 覆写Runnable()接口实现多线程，而后同样覆写run().推荐此方式
 *
 * ①.覆写Runnable接口实现多线程可以避免单继承局限
 * ②.当子类实现Runnable接口，此时子类和Thread的代理模式
 * （子类负责真是业务的操作，thread负责资源调度与线程创建辅助真实业务。
 *
 *
 * 继承Thread和实现Runnable接口的区别：
 *     a.实现Runnable接口避免多继承局限
 *     b.实现Runnable()可以更好的体现共享的概念
 */

public class CreateThread2 implements Runnable {

    public static int count = 20;

    @Override
    public void run() {
        while (count > 0) {
            try {
                Thread.sleep(200);
                count--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "当前剩余:" + count);
        }
    }

    public static void main(String[] args) {
        CreateThread2 Thread1 = new CreateThread2();
        Thread mThread1 = new Thread(Thread1, "线程1");
        Thread mThread2 = new Thread(Thread1, "线程2");
        Thread mThread3 = new Thread(Thread1, "线程3");
        mThread1.start();
        mThread2.start();
        mThread3.start();

    }
}
