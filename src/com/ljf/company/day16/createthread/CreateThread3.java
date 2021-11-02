package com.ljf.company.day16.createthread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 龙江锋
 *
 * 创建线程方法三：
 * 覆写Callable接口实现多线程（JDK1.5）
 * ①.核心方法叫call()方法，有返回值
 * ②.有返回值
 */
public class CreateThread3 implements Callable<String> {

    private final int count = 20;

    @Override
    public String call() {
        for (int i = count; i > 0; i--){
            //Thread.yield();
            System.out.println(Thread.currentThread() + "当前票数" + i);
        }
        return "sale out";
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> callable  =new CreateThread3();
        FutureTask<String> futureTask=new FutureTask<>(callable);
        Thread myThread = new Thread(futureTask);
        Thread myThread2 = new Thread(futureTask);
        Thread myThread3 = new Thread(futureTask);
        //mThread.setName("hhh");
        myThread.start();
        myThread2.start();
        myThread3.start();
        System.out.println(futureTask.get());
    }
}
