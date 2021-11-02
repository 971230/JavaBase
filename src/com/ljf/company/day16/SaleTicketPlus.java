package com.ljf.company.day16;

/**
 * @Author 龙江锋
 * @Date 2021/3/19 13:56
 * @Version 1.0
 *
 * 这个类用来测试多线程售票
 * 需求:设计4个售票窗口，总计售票100张
 */
public class SaleTicketPlus {
    public static void main(String[] args) {
        //3.创建接口实现类对象，作为目标业务对象(就是业务)
        TicketRunnable target = new TicketRunnable();

        //将目标业务和thread做绑定，new时是新建状态
        Thread thread  = new Thread(target,"窗口1");
        Thread thread2 = new Thread(target,"窗口2");
        Thread thread3 = new Thread(target,"窗口3");
        Thread thread4 = new Thread(target,"窗口4");
        //4.启动多线程，只创建一个线程对象是单程序，不会有数据问题
        //就绪状态，等待CPU调用
        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

/**1.创建多线程类*/
class TicketRunnable implements Runnable{
    /**创建静态成员变量，保存票的总数*/
    static int tickets = 100;

    /**2.把业务放入run()*/
    @Override
    public void run() {
        //一直卖票
        while(true) {
            //通过if判断当前买票的具体情况
            //if(tickets > 0) {
                try {
                    /*以后如何判断程序有没有线程安全问题？
                    在多线程程序中 + 有共享数据 + 多条语句操作共享数据*/
                    //先让程序休眠10ms
                    //问题1：超卖，0  -1
                    //问题2：重卖，70号票卖给了两个人
                    //增加了程序访问的延迟性,安全隐患更易暴露
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Thread.currentThread().getName()获取当前正在执行任务的线程名
                System.out.println(Thread.currentThread().getName() + "=" + tickets--);
            //}
            if(tickets <= 0) {
                break;//死循环的出口！！
            }
        }
    }
}


/*
* 每次创建线程对象，都会生成一个tickets变量值是100，创建4次对象就生成了400张票了。
* 不符合需求，怎么解决呢？能不能把tickets变量在每个对象间共享，就保证多少个对象都是卖这100张票。
*
解决方案: 用静态修饰
产生超卖，0 张 、-1张、-2张。
产生重卖，同一张票卖给多人。
多线程安全问题是如何出现的？常见情况是由于线程的随机性+访问延迟。
以后如何判断程序有没有线程安全问题？
在多线程程序中 + 有共享数据 + 多条语句操作共享数据*/
