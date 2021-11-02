package com.ljf.company.day20;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author 龙江锋
 * @Date 2021/3/21 16:58
 * @Version 1.0
 * <p>
 * 回声案例
 * 需求：接收客户端输入的每行数据,服务器再把回应给到用户
 * <p>
 * 1.1 服务器端
 * 接收客户端输入的每行数据,服务器再把回应给到用户
 * 这个类用来当做回声案例的服务器端
 * <p>
 * * 1.启动服务器
 * * 2.接收客户端的连接请求
 * * 3.给每个用户分配对应的话务员
 * * 4.话务员:主要负责和对应的客户端对象进行沟通I/O
 * <p>
 * ①.创建优化后的Servers类,充当服务器端
 */
public class Servers {

    /**②.创建方法,负责服务多个客户*/
    public void service() {

        /*③.匿名对象+匿名内部类(重写run方法)*/
        new Thread() {
            /**⑤.把业务写在run()中*/
            @Override
            public void run() {
                try {
                    //5.1 启动服务器,设置端口号为8000并等待客户端连接
                    ServerSocket ss = new ServerSocket(1230);
                    System.out.println("服务器启动成功!");
                    while (true) {//死循环,一直accept,也就是接受客户端的连接请求

                        //5.2 一直接受所有客户端的连接请求
                        Socket socket = ss.accept();
                        System.out.println("客户端连接成功!");

                        //5.3 给每个客户分配自己对应的话务员,1v1
                        TrafficThread t = new TrafficThread(socket);
                        t.start();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();/*④.启动线程*/
    }

    /**⑥.创建话务员内部类,主要负责和客户端沟通 I/O*/
    static class TrafficThread extends Thread {

        //6.1 定义本类中的成员变量socket,用来保持通话
        Socket socket;

        public static void main(String[] args) {
            Servers servers = new Servers();
            servers.service();
        }

        //6.2含参构造,接受当前的连接信息,保持通话,为谁服务就保存谁的数据
        public TrafficThread(Socket socket) {
            this.socket = socket;
        }

        //6.3把话务员的业务放在run(),一直读取客户端发来的数据,并作出回应
        @Override
        public void run() {
            try {
                //7.1读取一行BufferedReader,并且写出一行PrintWriter --双向流
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(socket.getOutputStream()));

                //7.2读取客户端发来的一行数据
                String line;//定义变量,记录读取到的一行数据
                while ((line = bufferedReader.readLine()) != null) {//只要有数据就一直读
                    System.out.println("客户端发来的数据:" + line);
                    //7.1可以给客户端作出响应-接收键盘输入的响应
                    System.out.println("请输入您的回应:");
                    //7.2发出作为服务器的响应
                    out.println(new Scanner(System.in).nextLine());
                    out.flush();//把数据刷出去
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
