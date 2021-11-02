package com.ljf.company.day17;

/**
 * @Author 龙江锋
 * @Date 2021/3/21 15:50
 * @Version 1.0
 *
 * 悲观锁和乐观锁
 *
 *   悲观锁：像它的名字一样，对于并发间操作产生的线程安全问题持悲观状态.
 *      悲观锁认为竞争总是会发生，因此每次对某资源进行操作时，都会持有一个独占的锁,就像synchronized,
 *      不管三七二十一，直接上了锁就操作资源了。
 *
 *   乐观锁：还是像它的名字一样，对于并发间操作产生的线程安全问题持乐观状态.
 *      乐观锁认为竞争不总是会发生，因此它不需要持有锁，
 *      将”比较-替换”这两个动作作为一个原子操作尝试去修改内存中的变量，
 *      如果失败则表示发生冲突，那么就应该有相应的重试逻辑。
 *
 *   两种常见的锁
 *      Ø  synchronized 互斥锁（悲观锁，有罪假设）采用synchronized修饰符实现的同步机制叫做互斥锁机制，
 *      它所获得的锁叫做互斥锁。每个对象都有一个monitor(锁标记)，当线程拥有这个锁标记时才能访问这个资源，
 *      没有锁标记便进入锁池。任何一个对象系统都会为其创建一个互斥锁，这个锁是为了分配给线程的，防止打断原子操作。
 *      每个对象的锁只能分配给一个线程，因此叫做互斥锁。
 *
 *      Ø  ReentrantLock 排他锁（悲观锁，有罪假设），排他锁在同一时刻仅有一个线程可以进行访问，
 *      实际上独占锁是一种相对比较保守的锁策略，在这种情况下任何“读/读”、“读/写”、“写/写”操作都不能同时发生，
 *      这在一定程度上降低了吞吐量。然而读操作之间不存在数据竞争问题，如果”读/读”操作能够以共享锁的方式进行，
 *      那会进一步提升性能。
 *
 *      Ø  ReentrantReadWriteLock 读写锁（乐观锁，无罪假设），因此引入了ReentrantReadWriteLock，顾名思义，
 *      ReentrantReadWriteLock是Reentrant（可重入）Read（读）Write（写）Lock（锁），我们下面称它为读写锁。
 *      读写锁内部又分为读锁和写锁，读锁可以在没有写锁的时候被多个线程同时持有，写锁是独占的。
 *      读锁和写锁分离从而提升程序性能，读写锁主要应用于读多写少的场景。
 */
public class TicketThread extends Thread{
    /**总票数，多个线程共享这个变量，能修改 ticket–*/
    private int ticket = 100;

    /**执行业务，重写父类run方法*/
    @Override
    public void run() {
        //业务处理，卖票：票–
        //线程非常多，我想尽量给我资源
        while(true) {
            //对象锁
            synchronized (this) {
                //判断一个条件，出去条件
                //多线程可能ticket=-1
                if(ticket <=0 ) {
                    break;     //退出死循环
                }
                //不出现，线程run方法执行太快，不会发生线程冲突
                try {  //不能抛出异常，抛出就不是重写run方法
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("窗口：" + Thread.currentThread().getName()
                        +", 剩余票数：" + ticket-- );
            }
        }
    }

    /**3个窗口都买这一个票*/
    public static void main(String[] args) {
        //目标
        Thread target = new TicketThread();
        for(int i = 0; i < 3; i++) {
            //3个线程共同作用一个target
            new Thread(target).start();
        }
    }
}
