package com.ljf.company.day20;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author 龙江锋
 * @Date 2021/3/21 16:49
 * @Version 1.0
 *
 * Socket
 * 也叫套接字编程,应用程序可以通过它发送或者接受数据,可对其像打开文件一样打开/关闭/读写等操作.
 *
 *       套接字允许应用程序将I/O插入到网络中,并与网络中的其他应用程序进行通信.
 *       网络套接字是IP地址与端口号TCP协议的组合
 *       Socket就是为网络编程提供的一种机制,通信的两端都有Socket
 *       网络通信其实就是Socket之间的通信,数据在两个Socket之间通过I/O进行传输.
 **************************************************************************************
 *
 * 服务器端
 * 3.1 ServerSocket
 *       在服务器端选择一个端口号,在指定端口上等待客户端发起连接
 *
 * 构造方法:
 * ServerSocket(int port) 创建绑定到特定端口的服务器套接字
 *
 * 常用方法:
 * Socket accept() 侦听并接收到此套接字的连接
 * void close() 关闭此套接字
 *
 * 启动服务:
 * ServerSocket ss = new ServerSocket(端口号);
 * 等待客户端发起连接,连接后会建立起通道:Socket socket = ss.accept();
 *************************************************************************************
 *
 * 客户端
 * 4.1 Socket
 *       我们经常使用的就是客户端
 *
 * 构造方法:
 * Socket(String host,int port) 创建一个流套接字,并将其连接到指定主机上的指定端口号
 *
 * 常用方法:
 * InputStream getInputStream() 返回此套接字的输入流
 * OutputStream getOutputStream() 返回此套接字的输出流
 * void close() 关闭此套接字
 *
 * 新建Socket对象,连接指定IP指定的端口
 * Socket s = new Socket(IP,port);
 *
 * 从Socket获取双向的流:
 * InputStream in = s.getInputStream();
 * OutputStream out = s.getOutputStream();
 *********************************************************************************
 *
 * 本类用来表示Socket网络编程案例的服务器端
 *
 *  * 完成步骤分析:
 *  * 1.启动服务器
 *  * 2.接收客户端的连接请求
 *  * 3.接收客户端发来的数据
 *测试注意事项:先启动服务器端,再启动客户端
 */
public class Server {
    public static void main(String[] args) throws Exception {
        final int frequency = 5;

        /* 注意:
         * 1.使用ServerSocket需要导包java.net.ServerSocket
         * 2.此操作会抛出异常
         * 3.指定的端口号范围是:0-65535,而0-1024是系统端口号,不能指定
         * */
        //①.启动服务器,指定端口号为1230,等待客户端的连接
        ServerSocket serverSocket = new ServerSocket(1230);
        System.out.println("服务器已开启！等待客户端发送数据");
        //②.等待接收客户端的连接请求,并建立数据通信通道(等待连接和建立通道)
        Socket socket = serverSocket.accept();

        System.out.print("已接收，请输入想回复的数据：");
        //③.获取到读取流,接收并读取客户端发来的数据(接收并读取)
        InputStream in = socket.getInputStream();

        //通过循环挨个读取显示读到的内容
        for(int i = 0; i < frequency; i++) {
            //int b = in.read();//此方法读取的结果是把字符转成数字
            //为了直接显示读取到的字符,需要强制类型转换(大转小,int转char)
            //不满足5个字符read()会死等，必须输入5个字符才可以
            char data = (char) in.read();
            //print()同行输出,注意细节哦
            System.out.print(data);
        }

        //⑤.给客户端发送数据
        OutputStream out = socket.getOutputStream();
        String input = new Scanner(System.in).nextLine();
        out.write(input.getBytes());
        //刷新数据
        out.flush();

        //④.释放资源
        /*注意关流的顺序,后出现的先关闭*/
        in.close();
        serverSocket.close();


        /* close()和flush()的区别？
         * A:close()关闭流对象，但是先刷新一次缓冲区，关闭之后，流对象不可以继续再使用了。
         * B:flush()仅仅是刷新缓冲区(一般写字符时要用,因为字符是先进入的缓冲区)，流对象还可以继续使用
         * */
    }
}
