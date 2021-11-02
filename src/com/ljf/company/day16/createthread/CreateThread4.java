package com.ljf.company.day16.createthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author 龙江锋
 * 创建线程池的方法四：
 * 通过Executor 的工具类可以创建四种类型的普通线程池：
 * ①.FixThreadPool(int n); 固定大小的线程池
 * ②.SingleThreadPoolExecutor :单线程池
 * ③.CashedThreadPool(); 缓存线程池
 * ④.newScheduledThreadPool:定时与周期性任务的线程池
 */
public class CreateThread4 {
    /**①.FixThreadPool(int n); 固定大小的线程池
     * 使用于为了满足资源管理需求而需要限制当前线程数量的场合。使用于负载比较重的服务器。*/
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++){
            ex.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++){
                        System.out.println(Thread.currentThread().getName() + j);
                    }
                }
            });
        }
        ex.shutdown();
    }

    /**②.SingleThreadPoolExecutor :单线程池
     * 需要保证顺序执行各个任务的场景 */
    public static void main1(String[] args) {
        ExecutorService ex= Executors.newSingleThreadExecutor();

        for(int m = 0; m < 5; m++) {
            ex.submit(new Runnable() {

                @Override
                public void run() {
                    for(int n = 0; n < 10; n++) {
                        System.out.println(Thread.currentThread().getName() + n);
                    }
                }
            });
        }
        ex.shutdown();
    }

    /**③.CashedThreadPool(); 缓存线程池
     * 当提交任务速度高于线程池中任务处理速度时，缓存线程池会不断的创建线程
     * 适用于提交短期的异步小程序，以及负载较轻的服务器*/

    public static void main2(String[] args) {
        ExecutorService ex = Executors.newCachedThreadPool();

        for(int p = 0; p < 5; p++) {
            ex.submit(new Runnable() {

                @Override
                public void run() {
                    for(int q = 0; q < 10; q++) {
                        System.out.println(Thread.currentThread().getName()+q);
                    }
                }
            });
        }
        ex.shutdown();
    }

    /**④.newScheduledThreadPool:定时与周期性任务的线程池*/
    public static void main3(String[] args) {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " : 延迟3秒");
            }
        });

        /*
         * 定长线程池，支持定时及周期性任务执行
         */
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        //延迟3s后运行
        scheduledThreadPool.schedule(thread, 3, TimeUnit.SECONDS);

        //首次执行延迟1s，每次间隔3秒
        scheduledThreadPool.scheduleAtFixedRate(thread, 1, 3, TimeUnit.SECONDS);

        //每次执行结束，已固定时延开启下次执行
        scheduledThreadPool.scheduleWithFixedDelay(thread, 1, 3, TimeUnit.SECONDS);

        System.out.println(Thread.currentThread().getName() + " : main thread");
        scheduledThreadPool.shutdown();
    }
}
