package com.ljf.company.day17;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author 龙江锋
 * @Date 2021/3/21 15:57
 * @Version 1.0
 *
 * 需要注意的是，用synchronized修饰的方法或者语句块在代码执行完之后锁会自动释放，
 * 而是用Lock需要我们手动释放锁，所以为了保证锁最终被释放(发生异常情况)，要把互斥区放在try内，
 * 释放锁放在finally内！
 *
 * 与互斥锁相比，读-写锁允许对共享数据进行更高级别的并发访问。
 * 虽然一次只有一个线程（writer 线程）可以修改共享数据，但在许多情况下，
 * 任何数量的线程可以同时读取共享数据（reader 线程）从理论上讲，与互斥锁定相比，
 * 使用读-写锁允许的并发性增强将带来更大的性能提高。
 */
public class ReentrantReadWriteLocks {
    public static void main(String[] args) {

        My2 target = new My2();

        Thread t = new Thread(target, "1号窗口：");
        Thread t2 = new Thread(target, "2号窗口：");
        Thread t3 = new Thread(target, "3号窗口：");
        Thread t4 = new Thread(target, "4号窗口：");

        t.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class My2 implements Runnable {

    int sum = 100;
    /**1.定义可重入读写锁对象,静态保证全局唯一*/
    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    @Override
    public void run() {
        while (true) {
            // t t2 t3 t4都要开门，t有钥匙，进来了出去后，t2再开门干活再锁门
            // synchronized (this) {
            //2.在操作共享资源前上写锁
            lock.writeLock().lock();
            // sum=1时 t t2 t3 t4都进来
            try {
                if (sum > 0) {
                    try {
                        // t t2 t3 t4都睡了
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // t醒了 sum=1时，sum-- = 1,sum=0
                    // t2醒了 sum=0时，sum-- = 0,sum=-1
                    // t3醒了 sum=-1时，sum-- = -1,sum=-2
                    // t4醒了 sum=-2时，sum-- = -2,sum=-3
                    System.out.println(Thread.currentThread().getName() + sum--);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.writeLock().unlock();//防止死锁，会自动释放，不释放就独占报错了
            }
        }
    }
}
