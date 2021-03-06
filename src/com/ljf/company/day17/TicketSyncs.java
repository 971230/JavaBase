package com.ljf.company.day17;

/**
 * @Author 龙江锋
 * @Date 2021/3/21 15:16
 * @Version 1.0
 *
 * 把有可能出现问题的代码包起来，一次只让一个线程执行。
 * 通过synchronized关键字实现线程同步。
 * 当多个对象操作共享数据时，可以使用同步锁解决线程安全问题。
 *
 * 同步：就是体现了排队的效果，就是同一时刻只能有一个线程独占资源，没有权利的排队。坏处就是效率低，但是安全。
 * 异步：就是体现了多线程的效果，就是互相不等待，互相抢占资源。好处是效率高，但是不安全。
 *
 * 关于同步和异步:同步就类似于排队效果,而异步就类似于多线程同时执行的效果
 *
 * 1.1 synchronized
 * synchronized (对象){需要同步的代码;}
 *
 ***************************************************************************************
 * 1.2 前提
 *      1．前提1：同步需要两个或者两个以上的线程(单线程无需考虑多线程安全问题)
 *      2．前提2：多个线程间必须使用同一个锁(我上锁后其他人也能看到这个锁,
 *              不然我的锁锁不住其他人,就没有了上锁的效果)
 *
 * TIPS:既然是加锁,那么就需要有锁住的对象,一般锁的是当前对象this
 *      那为什么同步代码块的锁对象可以是obj,但是同步方法必须是this呢?
 *      因为同步代码块同一个时刻只有一个线程进入,而同步方法可以让多个线程进入.
 *
 *     特点
 *      synchronized同步关键字可以用来修饰方法,称为同步方法,使用的锁对象是this
 *      synchronized同步关键字可以用来修饰代码块,称为同步代码块,使用的锁对象可以任意
 *      同步的缺点是会降低程序的执行效率，但我们为了保证线程的安全,有些性能是必须要牺牲的
 *      但是为了性能,加锁的范围需要控制好,比如我们不需要给整个商场加锁,试衣间加锁就可以了
 *
 *      synchronized的特性
 *      1.1 原子性
 *      所谓原子性就是指一个操作或者多个操作，要么全部执行并且执行的过程不会被任何因素打断，要么就都不执行。
 *      1.2 可见性
 *      可见性是指多个线程访问一个资源时，该资源的状态、值信息等对于其他线程都是可见的。
 *      1.3 有序性
 *      有序性值程序执行的顺序按照代码先后执行。
 *      1.4 可重入性
 *      synchronized和ReentrantLock都是可重入锁。当一个线程试图操作一个由其他线程持有的对象锁的临界资源时，
 *      将会处于阻塞状态，但当一个线程再次请求自己持有对象锁的临界资源时，这种情况属于重入锁。
 *      通俗一点讲就是说一个线程拥有了锁仍然还可以重复申请锁。
 *
 *      本类用于练习改造售票案例
 *  *   需求:4个线程共同卖100张票
 *  *   问题1:出现了重卖现象:一张票卖给了多个人
 *  *   问题2:出现了超卖现象:出现了0张/-1张/-2张这样的现象
 */
public class TicketSyncs {
    public static void main(String[] args) {

        //5.创建接口实现类对象作为业务目标对象
        TicketSync target = new TicketSync();

        //6.将目标对象交由Thread线程对象
        Thread t1 = new Thread(target);
        Thread t2 = new Thread(target);
        Thread t3 = new Thread(target);
        Thread t4 = new Thread(target);

        //7.以多线程的方式启动线程--会将线程由新建状态变为就绪状态
        /*1.如果只创建了一个线程对象,是单线程场景,不会出现数据问题*/
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

//1.通过实现Runnable接口的方式完成多线程售票案例
/*2.多线程中出现数据不安全问题的前提:多线程程序 + 有共享数据(成员变量) + 多条语句操作共享数据*/
/**3.同步锁:相当于给容易出现问题的代码加了一把锁,从可能出现问题的代码开始,到问题代码结束
 *   位置:不能太大,也不能太小,太大,干啥都得排队,导致程序的效率太低,太小,没锁住*/
class TicketSync implements Runnable{
    /**3.定义变量用来保存票数，实现Runnable可以不加static*/
    int tickets = 100;

    /**创建了一个唯一的"锁"对象,不论之后哪个线程进同步代码块,使用的都是obj对象,"唯一"很重要
     * 锁对象也可以使用this*/
    final Object obj = new Object();


    //2.添加未实现方法run()--写业务
    /*6.使用场景：如果一个方法里的代码都被同步了,可以直接把方法修饰成同步方法,同步方法的锁对象得用this*/
    /**public synchronized void run() {//被synchronized修饰的方法是同步方法*/
    @Override
    public void run() {//被synchronized修饰的方法是同步方法

        //4.1通过while(true)死循环的方式卖票,注意添加出口!!!
        while(true) {

            /*4.synchronized(锁对象){}--同步代码块:是指同一时间这一资源会被一个线程独享,
                大家使用的时候,都得排队,同步效果*/
            /*5.锁对象的要求:多线程之间必须使用同一把锁,同步代码块的方式,关于锁对象可以任意定义*/
            synchronized (obj) {

                /*synchronized (new Object()) {
                  不对,相当于每个线程都用了自己的锁,多个线程进来一次new一次,并不是使用的同一把锁*/
                //4.2通过if结构判断买票的情况
                //还有票
                if(tickets > 0){

                    //8.手动添加休眠方法,创造延迟效果,注意可能会发生问题,需要由try-catch包裹
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //4.3打印的是当前卖票的线程以及票数
                    System.out.println(Thread.currentThread().getName() + "=" + tickets--);
                }
                if(tickets <= 0) {
                    break; //没有票了,退出循环,没得卖了
                }
            }
        }
    }
}
