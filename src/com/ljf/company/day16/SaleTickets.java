package com.ljf.company.day16;

/**
 * @Author 龙江锋
 * @Date 2021/3/19 13:54
 * @Version 1.0
 * 这个类用来测试多线程售票
 * 需求:设计4个售票窗口，总计售票100张
 */
public class SaleTickets {
    public static void main(String[] args) {
        //4.创建线程对象
        TicketThread t = new TicketThread();
        TicketThread t2 = new TicketThread();
        TicketThread t3 = new TicketThread();
        TicketThread t4 = new TicketThread();
        //问题1：我们想让程序只卖100张票，但是目前卖了400张，为什么？
        //解决：需要将成员变量设置成静态的，可以被多个对象共享
        t.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

/**1.多线程编程：extends Thread*/
class TicketThread extends Thread {

    /** int tickets = 100;//定义变量，记录票的数据 成员变量-实例变量
    可以被多个对象共享，只会加载一次,要数据共享*/
    static int tickets = 100;

    /**2.把业务写在run()里*/
    @Override
    public void run() {
        //3.一直卖票
        while(true) {
            //！！！如果数据能够接受sleep的考验，才能说明数据没有了安全隐患
            try {//有中断异常，需要try  catch
                //问题2：产生了重卖：同一张票卖给了多个人
                //问题3：产生了超卖：超出了票数，甚至卖出了0和-1和-2
                //解决：加锁
                //让程序休眠10ms
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "=" + tickets--);

            //判断是否还有票
            if(tickets <= 0) {
                break;//死循环的出口！！
            }
        }
    }
}
