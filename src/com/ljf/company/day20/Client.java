package com.ljf.company.day20;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author 龙江锋
 * @Date 2021/3/21 16:53
 * @Version 1.0
 *
 * 本类用来表示Socket网络编程案例的客户端
 *
 *  * 完成步骤分析:
 *  * 1.指定要连接的服务器
 *  * 2.给服务器发送hello
 */
public class Client {
    public static void main(String[] args) throws Exception {
        final int frequency = 5;

        /* 注意:
         * 1.使用Socket需要导包java.net.Socket
         * 2.此操作会抛出异常
         * 3.如果使用的是本机的IP,地址是固定值,用来测试时使用127.0.0.1
         * */

        //①.指定要连接的服务器,需要同时指定服务器的IP & Port
        Socket socket = new Socket("127.0.0.1",1230);
        System.out.println("客户端已启动，与服务器连接成功！请发送数据");

        //②.给服务器端发送数据
        OutputStream out = socket.getOutputStream();
        //把要输出的数据字符串转变成byte[]的形式进行输出
        String input = new Scanner(System.in).nextLine();
        out.write(input.getBytes());
        //把流里的数据刷新给服务器
        out.flush();

        //④.读取从服务器端返回的数据
        InputStream in = socket.getInputStream();
        for (int i = 0; i < frequency; i++) {

            //为了显示字符而不是数字,强制类型转换成char
            char c = (char) in.read();
            //不换行展示获取到的数据
            System.out.print(c);
        }
        //③.释放资源
        out.close();
        socket.close();
    }
}
