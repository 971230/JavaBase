package com.ljf.company.day16;

/**
 * @Author 龙江锋
 * @Date 2021/3/19 11:47
 * @Version 1.0
 *
 * 进程与线程
 *  1 进程
 *      1.1 进程的概念
 *      进程就是正在运行的程序,它代表了程序所占用的内存区域
 *      -------------------------------------------------------------------------------
 *      1.2 进程的特点
 *      独立性:
 *          进程是系统中独立存在的实体,它可以拥有自己独立的资源,每个进程都拥有自己私有的地址空间,
 *          在没有经过进程本身允许的情况下,一个用户进程不可以直接访问其他进程的地址空间
 *      动态性:
 *          进程与程序的区别在于,程序只是一个静态的指令集合,而进程是一个正在系统中活动的指令集合,
 *          程序加入了时间的概念以后,称为进程,具有自己的生命周期和各种不同的状态,这些概念都是程序所不具备的.
 *      并发性:
 *          多个进程可以在单个处理器CPU上并发执行,多个进程之间不会互相影响.
 *      ---------------------------------------------------------------------------------
 *      1.3 并行与并发
 *      高并发：多个进程抢占公共资源    并行：多个CPU处理不同的进程
 *      HA(High Availability)高可用:指在高并发的情景中,尽可能的保证程序的可用性,减少系统不能提供服务的时间
 **********************************************************************************************
 *  2 线程
 *      2.1 线程的概念
 *      线程是操作系统OS能够进行运算调度的最小单位,它被包含在进程之中,是进程中的实际运作单位.
 *      一个进程可以开启多个线程,其中有一个主线程来调用本进程中的其他线程
 *      我们看到的进程的切换，切换的也是不同进程的主线程
 *      多线程扩展了多进程的概念,使的同一个进程可以同时并发处理多个任务
 *      --------------------------------------------------------------------
 *      2.2 进程与线程的关系
 *      一个操作系统中可以有多个进程,一个进程中可以包含一个线程(单线程程序),也可以包含多个线程(多线程程序)
 *      每个线程在共享同一个进程中的内存的同时,又有自己独立的内存空间.
 *      所以想使用线程技术,得先有进程,进程的创建是OS操作系统来创建的,一般都是C或者C++完成
 *********************************************************************************************
 * 3 多线程的特性
 *      3.1 随机性
 *      线程的随机性指的是同一时刻,只有一个程序在执行
 *      我们宏观上觉得这些程序像是同时运行,但是实际上微观时间是因为CPU在高效的切换着，
 *      这使得各个程序从表面上看是同时进行的,也就是说,宏观层面上,所有的进程/线程看似同时运行,
 *      但是微观层面上,同一时刻,一个CPU只能处理一件事.切换的速度甚至是纳秒级别的,非常快
 *      ---------------------------------------------------------------------------
 *      3.2 CPU分时调度
 *      时间片,即CPU分配给各个线程的一个时间段,称作它的时间片,即该线程被允许运行的时间，
 *      如果在时间片用完时线程还在执行,那CPU将被剥夺并分配给另一个线程,将当前线程挂起,
 *      如果线程在时间片用完之前阻塞或结束,则CPU当即进行切换,从而避免CPU资源浪费,
 *      当再次切换到之前挂起的线程,恢复现场,继续执行。
 *      注意:我们无法控制OS选择执行哪些线程,OS底层有自己规则,如:
 *      FCFS(First Come First Service 先来先服务算法)
 *      SJS(Short Job Service短服务算法)
 *      -------------------------------------------------------------------------
 *      3.3 线程的状态
 *      由于线程状态比较复杂,我们由易到难,先学习线程的三种基础状态及其转换,简称”三态模型” :
 *      ①就绪(可运行)状态：线程已经准备好运行，只要获得CPU调度，就可立即执行
 *      ②执行(运行)状态：线程已经获得CPU，其程序正在运行的状态
 *      ③阻塞状态：正在运行的线程由于某些事件（I/O请求等）暂时无法执行的状态，即线程执行阻塞
 *
 *      就绪 → 执行:为就绪线程分配CPU即可变为执行状态"
 *      执行 → 就绪:正在执行的线程由于时间片用完被剥夺CPU暂停执行,就变为就绪状态
 *      执行 → 阻塞:由于发生某事件,使正在执行的线程受阻,无法执行,则由执行变为阻塞
 *      (例如线程正在访问临界资源,而资源正在被其他线程访问)
 *      反之,如果获得了之前需要的资源,则由阻塞变为就绪状态,等待分配CPU再次执行
 *
 *      我们可以再添加两种状态:
 *      ④创建状态:线程的创建比较复杂,需要先申请PCB,然后为该线程运行分配必须的资源,
 *               并将该线程转为就绪状态插入到就绪队列中
 *      ⑤终止状态:等待OS进行善后处理,最后将PCB清零,并将PCB返回给系统
 *
 *      PCB(Process Control Block):为了保证参与并发执行的每个线程都能独立运行,
 *      OS配置了特有的数据结构PCB来描述线程的基本情况和活动过程,进而控制和管理线程
 *      ---------------------------------------------------------------------
 *      3.4 线程状态与代码对照
 *      线程生命周期,主要有五种状态:
 *      ①新建状态(New) : 当线程对象创建后就进入了新建状态.如:Thread t = new MyThread();
 *      ②就绪状态(Runnable):当调用线程对象的start()方法,线程即为进入就绪状态.
 *          处于就绪(可运行)状态的线程,只是说明线程已经做好准备,随时等待CPU调度执行,
 *          并不是执行了t.start()此线程立即就会执行
 *      ③运行状态(Running):当CPU调度了处于就绪状态的线程时,此线程才是真正的执行,即进入到运行状态
 *          就绪状态是进入运行状态的唯一入口,也就是线程想要进入运行状态状态执行,先得处于就绪状态
 *      ④阻塞状态(Blocked):处于运状态中的线程由于某种原因,暂时放弃对CPU的使用权,停止执行,
 *                        此时进入阻塞状态,直到其进入就绪状态才有机会被CPU选中再次执行.
 *                        根据阻塞状态产生的原因不同,阻塞状态又可以细分成三种:
 *          等待阻塞:运行状态中的线程执行wait()方法,本线程进入到等待阻塞状态
 *          同步阻塞:线程在获取synchronized同步锁失败(因为锁被其他线程占用),它会进入同步阻塞状态
 *          其他阻塞:调用线程的sleep()或者join()或发出了I/O请求时,线程会进入到阻塞状态.
 *          当sleep()状态超时.join()等待线程终止或者超时或者I/O处理完毕时线程重新转入就绪状态
 *      ⑤死亡状态(Dead):线程执行完了或者因异常退出了run()方法,该线程结束生命周期
 *
 ********************************************************************************************
 *  4 多线程代码创建方式1:继承Thread
 *      4.1 概述
 *      Thread类本质上是实现了Runnable接口的一个实例,代表一个线程的实例
 *      启动线程的唯一方法就是通过Thread类的start()实例方法
 *      start()方法是一native方法,它将通知底层操作系统,.最终由操作系统启动一个新线程,操作系统将执行run()
 *      这种方式实现的多线程很简单,通过自己的类直接extends Thread,并重写run()方法,
 *      就可以自动启动新线程并执行自己定义的run()方法
 *      模拟开启多个线程,每个线程调用run()方法.
 *
 *      --------------------------------------------------------------------------
 *      4.2 常用方法
 *      构造方法
 *      Thread() 分配新的Thread对象
 *      Thread(String name) 分配新的Thread对象
 *      Thread(Runnable target) 分配新的Thread对象
 *      Thread(Runnable target,String name) 分配新的Thread对象
 *      --------------------------------------------------------------------------
 *
 *      普通方法
 *      static Thread currentThread( ):返回对当前正在执行的线程对象的引用
 *      long getId():返回该线程的标识
 *      String getName():返回该线程的名称
 *      void run():如果该线程是使用独立的 Runnable 运行对象构造的，则调用该 Runnable 对象的 run 方法
 *      static void sleep(long millions):在指定的毫秒数内让当前正在执行的线程休眠(暂停执行)
 *      void start():使该线程开始执行:Java虚拟机调用该线程的run()
 *
 ********************************************************************************************
 *  5 两种实现方式的比较
 *      继承Thread类
 *          优点: 编写简单,如果需要访问当前线程,无需使用Thread.currentThread()方法,
 *               直接使用this即可获得当前线程
 *          缺点: 自定义的线程类已继承了Thread类,所以后续无法再继承其他的类
 *      实现Runnable接口(推荐)
 *          优点: 自定义的线程类只是实现了Runnable接口或Callable接口,后续还可以继承其他类,
 *               在这种方式下,多个线程可以共享同一个target对象,所以非常适合多个相同线程来处理同一份资源的情况,
 *               从而可以将CPU、代码、还有数据分开(解耦),形成清晰的模型,较好地体现了面向对象的思想
 *          缺点: 编程稍微复杂,如想访问当前线程,则需使用Thread.currentThread()方法
 */
public class Thread1 {
    public static void main(String[] args) {
        //4.创建自定义线程对象
        /*此时对应的状态就是新建状态*/
        Thread t = new MyThread();


        /*如果只是调用两个线程的run(),那么会按顺序先执行完一个线程,再执行另一个线程,不会有多线程的效果*/
        //t.run();//怎么去执行run()的业务?--真的可以用run()来执行我们的多线程任务吗?

        /*run()与start()本质上的区别,run()在执行时只能是当做一个顺序执行的单线程普通方法执行,
        并没有多线程编程的效果*/
        t.start();
        /*对应的状态就是就绪状态,想要使用多线程启动干活,必须调用start()才是真正的启动线程*/
        /*6.只有调用start()才会使线程从新建状态变成可运行状态,才把线程加入就绪队列
         *  当我们调用start()启动线程时,底层虚拟机会自动调用run()的业务*/
        //5.模拟多线程,需要至少启动2个线程,如果只是启动一个线程,是单线程程序
        Thread t2 = new MyThread();
        //t2.run();
        t2.start();

        /*线程的随机性,t0 t1 t2的执行结果不可控,因为会由CPU在调度,结果有随机性*/
        /*线程的随机性:CPU会自动调度可运行状态的线程们,但是哪个时间片执行哪个线程我们无法控制*/
//		2=Thread-0
//		3=Thread-0
//		2=Thread-1
//		1=Thread-2
//		3=Thread-1
        //给线程起名
        Thread t3 = new MyThread("小灰灰");
        t3.start();
    }
}

//1.自定义多线程类
/**1.方式1:extends Thread*/
class MyThread extends Thread{

    /**最后:为了修改线程名称,不再使用系统分配的默认名称,需要提供含参构造
     * 并在构造中调用父类给线程起名的构造函数*/
    public MyThread() {
        super();
    }

    public MyThread(String s) {
        super(s);
    }

    /*2.1线程中的业务必须写在run()里*/

    //    @Override2. 源码:745行
    //    public void run() {
    //        if (target != null) {
    //            target.run();}}


    /**3.如果不满意run()的内容,可以重写
    2.2 重写Thread父类中的run()*/
    @Override
    public void run() {
        final int a = 10;
        /*4.super表示父类对象的引用,也就是默认使用Thread类里的业务,不用*/
        //super.run();
        //3.写业务:输出10次当前正在执行的线程名称
        for (int i = 0; i < a; i++) {
            /*5.getName()可以获取正在执行任务的线程名称,是从父类中继承的方法,可以直接使用*/
            System.out.println(i + "=" + getName());
        }
    }
}

