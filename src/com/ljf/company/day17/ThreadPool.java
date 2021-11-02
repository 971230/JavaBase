package com.ljf.company.day17;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Author 龙江锋
 * @Date 2021/3/21 15:28
 * @Version 1.0
 *
 *
 * execute(Runnable任务对象) 把任务丢到线程池
 *
 * newFixedThreadPool(int nThreads) 最多n个线程的线程池
 * newCachedThreadPool() 足够多的线程,使任务不必等待
 * newSingleThreadExecutor() 只有一个线程的线程池
 */
public class ThreadPool {
    static final int FREQUENCY = 5;

    /******************自动创建线程池*******************************/
    @Test
    public void autoThreadPool(){
        //5.创建接口实现类对象作为业务目标对象
        TicketSync target = new TicketSync();

        /*7.线程池ExecutorService:用来存储线程的池子,把新建线程/启动线程/销毁线程的任务都交给池来管理*/
        /*8.Executors用来辅助创建线程池对象,newFixedThreadPool()创建具有参数个数的线程数的线程池*/
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < FREQUENCY; i++) {
            /*9.execute()让线程池中的线程来执行任务,每次调用都会启动一个线程*/
            //本方法的参数就是执行的业务,也就是实现类的目标对象
            pool.execute(target);
            //pool.shutdown();
        }
        /*Executors 返回的线程池对象的弊端如下：
        1） FixedThreadPool 和 SingleThreadPool：
        允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。
        2） CachedThreadPool：
        允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM*/

    }

    /***********************手动创建线程池*****************************/

    @Test
    public void manualThreadPool(){
        TicketSync target = new TicketSync();
        /* 创建线程池的7个参数
        1、corePoolSize线程池的核心线程数
        2、maximumPoolSize能容纳的最大线程数
        3、keepAliveTime空闲线程存活时间
        4、unit 存活的时间单位
        5、workQueue 存放提交但未执行任务的队列
        6、threadFactory 创建线程的工厂类
        7、handler 等待队列满后的拒绝策略*/
        ExecutorService threadPool = new ThreadPoolExecutor(2,5,
                1L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        threadPool.execute(target);

        /*新任务被提交后，会先进入到此工作队列中，任务调度时再从队列中取出任务。jdk中提供了四种工作队列：
        ①ArrayBlockingQueue
        基于数组的有界阻塞队列，按FIFO排序。新任务进来后，会放到该队列的队尾，有界的数组可以防止资源耗尽问题。
        当线程池中线程数量达到corePoolSize后，再有新任务进来，则会将任务放入该队列的队尾，等待被调度。
        如果队列已经是满的，则创建一个新线程，如果线程数量已经达到maxPoolSize，则会执行拒绝策略。

        ②LinkedBlockingQueue
        基于链表的无界阻塞队列（其实最大容量为Integer.MAX），按照FIFO排序。
        由于该队列的近似无界性，当线程池中线程数量达到corePoolSize后，再有新任务进来，会一直存入该队列，
        而不会去创建新线程直到maxPoolSize，因此使用该工作队列时，参数maxPoolSize其实是不起作用的。

        ③SynchronousQueue
        一个不缓存任务的阻塞队列，生产者放入一个任务必须等到消费者取出这个任务。也就是说新任务进来时，
        不会缓存，而是直接被调度执行该任务，如果没有可用线程，则创建新线程，如果线程数量达到maxPoolSize，
        则执行拒绝策略。

        ④PriorityBlockingQueue
        具有优先级的无界阻塞队列，优先级通过参数Comparator实现。


        handler 拒绝策略
        当工作队列中的任务已到达最大限制，并且线程池中的线程数量也达到最大限制，这时如果有新任务提交进来，
        该如何处理呢。这里的拒绝策略，就是解决这个问题的，jdk中提供了4中拒绝策略：

        ①CallerRunsPolicy
        该策略下，在调用者线程中直接执行被拒绝任务的run方法，除非线程池已经shutdown，则直接抛弃任务
        ②AbortPolicy
        该策略下，直接丢弃任务，并抛出RejectedExecutionException异常。
        ③DiscardPolicy
        该策略下，直接丢弃任务，什么都不做。
        ④DiscardOldestPolicy
        该策略下，抛弃进入队列最早的那个任务，然后尝试把这次拒绝的任务放入队列
        */

    }

    /************************ThreadLocal******************************/

    @Test
    public void threadLocalPool() throws InterruptedException {
        /* ThreadLocal对外提供的方法只有三个get()、set(T)、remove()。
         * ThreadLocal是为了线程隔离，为了变量只能被固定的线程使用
         * 底层是用ThreadLocalMap是来存entry,因为key为弱引用，value为强引用
         * 会存在内存泄漏问题：ThreadLocal在保存的时候会把自己当做Key存在ThreadLocalMap中，
         * 正常情况应该是key和value都应该被外界强引用才对，但是现在key被设计成WeakReference弱引用了。
         * 这就导致了一个问题，ThreadLocal在没有外部强引用时，发生GC时会被回收，
         * 如果创建ThreadLocal的线程一直持续运行，那么这个Entry对象中的value就有可能一直得不到回收，
         * 发生内存泄露。就比如线程池里面的线程，线程都是复用的，那么之前的线程实例处理完之后，
         * 出于复用的目的线程依然存活，所以，ThreadLocal设定的value值被持有，导致内存泄露。
         * 解决方案：在代码最后使用remove()方法
         * */

        //新建一个ThreadLocal
        final ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("main-thread : Hello");

        Thread thread = new Thread(() -> {
            // 获取不到主线程设置的值，所以为null
            System.out.println(threadLocal.get());
            threadLocal.set("sub-thread : World");
            System.out.println(threadLocal.get());
        });
        // 启动子线程
        thread.start();
        // 让子线程先执行完成，再继续执行主线
        thread.join();
        // 获取到的是主线程设置的值，而不是子线程设置的
        System.out.println(threadLocal.get());
        threadLocal.remove();
        System.out.println(threadLocal.get());
    }
}
