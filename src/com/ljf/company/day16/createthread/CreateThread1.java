package com.ljf.company.day16.createthread;

/**
 * @author 龙江锋
 * 创建线程方法一:
 * 继承Thread类实现多线程
 * ①.    一个线程调用 两次start()方法将会抛出线程状态异常，也就是的start()只可以被调用一次
 * ②.   native生明的方法只有方法名，没有方法体。是本地方法，不是抽象方法，而是调用c语言方法
 *   registerNative()方法包含了所有与线程相关的操作系统方法
 * ③.    run()方法是由jvm创建完本地操作系统级线程后回调的方法，不可以手动调用（否则就是普通方法）
 */
public class CreateThread1 extends Thread{
    public static void main(String[] args) {
        CreateThread1 myThread1 = new CreateThread1();
        CreateThread1 myThread2 = new CreateThread1();
        CreateThread1 myThread3 = new CreateThread1();
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
    public CreateThread1(){ }

    @Override
    public void run() {
        for(int i = 0 ; i < 10 ; i++) {
            System.out.println(Thread.currentThread() + ":" + i);
        }
    }
}
