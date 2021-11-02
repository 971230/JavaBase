package com.ljf.company.day20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author 龙江锋
 * @Date 2021/3/21 17:02
 * @Version 1.0
 *
 * 客户端
 *       接收客户端输入的每行数据,服务器再把回应给到用户
 *
 *       本类用来做回声案例的客户端
 *
 *  * 1.连接指定的服务器
 *  * 2.给服务器发送数据
 *  * 3.接收服务器响应的数据
 */
public class Clients {
    public static void main(String[] args) {
        try {
            //1.连接指定的服务器,同时指定服务器的IP和端口号
            Socket socket = new Socket("127.0.0.1",1230);

            //2.给服务器发送数据
            while(true) {
                //向服务器写出一行数据,并且读取服务器响应回来的数据
                PrintWriter out = new PrintWriter
                        (new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader in = new BufferedReader
                        (new InputStreamReader(socket.getInputStream()));
                //3.通过流对象进行发送和读取的操作
                System.out.println("请输入您想给服务器发送的数据:");
                //向服务端发送指定数据
                out.println(new Scanner(System.in).nextLine());
                out.flush();//把数据刷出去
                //读取回声数据
                System.out.println("服务器端响应的数据是:" + in.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
