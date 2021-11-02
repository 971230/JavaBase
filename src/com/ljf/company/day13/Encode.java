package com.ljf.company.day13;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @Author 龙江锋
 * @Date 2021/3/12 18:55
 * @Version 1.0
 *
 * 编码转换流
 * 字节流:针对二进制文件
 * 字符流:针对文本文件,读写容易出现乱码的现象,在读写时,最好指定编码集为UTF-8
 *
 * 5.1 概述
 *       编码转换流(InputStreamReader/OutputStreamWriter)主要进行编码的转换,
 *       用来解决字符流读写乱码的问题
 *
 * 5.2     工具API学习
 * OutputStreamWriter :
 * OutputStreamWriter(OutputStream out)把传入的字节流转成字符流
 * OutputStreamWriter(OutputStream out ,String charsetName)把Unicode转成其他编码输出
 *
 * InputStreamReader :
 * InputStreamReader(InputStream in) 把传入的字节流转成字符流
 * InputStreamReader(InputStream in,String charsetName)读取其他编码转成Unicode
 */
public class Encode {
    public static void main(String[] args) {
        outPutStreamWriter();
        inputStreamReader();
    }

    public static void inputStreamReader() {
        //局部变量需要初始化
        InputStreamReader in = null;
        try {
            //1.创建对应的流对象
            //OutputStreamWriter对象--使用的是平台默认的编码--GBK
            /*保存和打开使用的是同一张默认gbk码表就不会出现乱码的问题*/
            //参数"1.txt",不是磁盘文件夹下的文件的路径,而是直接生成在工程下的和src同级的文件,需要F5多次刷新才能出来
            //out = new OutputStreamWriter(new FileOutputStream("1.txt"));//默认方式
            //参数"gbk",用来解决乱码,如果参数和保存是同一张码表就不会乱码,否则就乱码
            //比如,默认保存时使用的编码是gbk,参数也是gbk就不会乱码,如果参数是utf-8 iso-8859-1就会乱码
            //out = new OutputStreamWriter(new FileOutputStream("1.txt"),"gbk");
            //选择执行的码表是iso-8859-1
            //out = new OutputStreamWriter(new FileOutputStream("1.txt"), StandardCharsets.ISO_8859_1);
            //选择执行的码表是utf-8
            in = new InputStreamReader(new FileInputStream("1.txt"), StandardCharsets.UTF_8);

            //2.写出数据()会覆盖
            Object obj = in.read();
            System.out.println(obj);
            System.out.println("恭喜你!执行成功!");
        } catch (IOException e) {
            System.out.println("很抱歉!执行失败!");
            e.printStackTrace();
        }finally {//finally中的代码一定会被执行,关流的代码需要写到这里
            try {
                //3.释放资源
                assert in != null;
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void outPutStreamWriter() {
        //局部变量需要初始化
        OutputStreamWriter out = null;
        try {
            //1.创建对应的流对象
            //OutputStreamWriter对象--使用的是平台默认的编码--GBK
            /*保存和打开使用的是同一张默认gbk码表就不会出现乱码的问题*/
            //参数"1.txt",不是磁盘文件夹下的文件的路径,而是直接生成在工程下的和src同级的文件,需要F5多次刷新才能出来
            //out = new OutputStreamWriter(new FileOutputStream("1.txt"));//默认方式
            //参数"gbk",用来解决乱码,如果参数和保存是同一张码表就不会乱码,否则就乱码
            //比如,默认保存时使用的编码是gbk,参数也是gbk就不会乱码,如果参数是utf-8 iso-8859-1就会乱码
            //out = new OutputStreamWriter(new FileOutputStream("1.txt"),"gbk");
            //选择执行的码表是iso-8859-1
            //out = new OutputStreamWriter(new FileOutputStream("1.txt"), StandardCharsets.ISO_8859_1);
            //选择执行的码表是utf-8
            out = new OutputStreamWriter(new FileOutputStream("1.txt"), StandardCharsets.UTF_8);

            //2.写出数据()会覆盖
            out.write("观自在菩萨，行深般若波罗蜜多时");
            System.out.println("恭喜你!执行成功!");
        } catch (IOException e) {
            System.out.println("很抱歉!执行失败!");
            e.printStackTrace();
        }finally {//finally中的代码一定会被执行,关流的代码需要写到这里
            try {
                //3.释放资源
                assert out != null;
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


/*拓展
6.1 IO的继承结构
1. 主流分类
1) 按照方向进行分类:输入流 输出流(相对于程序而言,从程序写数据到文件中是输出)
2) 按照传输类型进行分类:字节流 字符流
3) 组合: 字节输入流 字节输出流 字符输入流 字符输出流
2. 学习方法:在抽象父类中学习通用的方法,在子类中学习如何创建对象

3.字节输入流:
--InputStream 抽象类,不能new,可以作为超类,学习其所提供的共性方法
       --FileInputStream 子类,操作文件的字节输入流,普通类
       --BufferedInputStream 子类,缓冲字节输入流,普通类

4.字符输入流
--Reader 抽象类,不能new,可以作为超类,学习其所提供的共性方法
       --FileReader,子类,操作文件的字符输入流,普通类
       --BufferedReader,子类,缓冲字符输入流,普通类

5.字节输出流:
--OutputStream 抽象类,不能new,可以作为超类,学习其所提供的共性方法
       --FileOutputStream 子类,操作文件的字节输出流,普通类
       --BufferedOutputStream 子类,缓冲字节输出流,普通类

6.字符输出流
--Writer 抽象类,不能new,可以作为超类,学习其所提供的共性方法
       --FileWriter,子类,操作文件的字符输出流,普通类
       --BufferedWriter,子类,缓冲字符输出流,普通类


6.2 BIO、NIO、AIO的区别
阻塞IO，BIO 就是传统的 java.io 包，它是基于流模型实现的，交互的方式是同步、阻塞方式，
    也就是说在读入输入流或者输出流时，在读写动作完成之前，线程会一直阻塞在那里，
    它们之间的调用时可靠的线性顺序。
    它的有点就是代码比较简单、直观；缺点就是 IO 的效率和扩展性很低，容易成为应用性能瓶颈。
非阻塞IO，NIO 是 Java 1.4 引入的 java.nio 包，提供了 Channel、Selector、Buffer 等新的抽象，
    可以构建多路复用的、同步非阻塞 IO 程序，同时提供了更接近操作系统底层高性能的数据操作方式。
异步IO，AIO 是 Java 1.7 之后引入的包，是 NIO 的升级版本，提供了异步非堵塞的 IO 操作方式，
所以人们叫它 AIO（Asynchronous IO），异步 IO 是基于事件和回调机制实现的，也就是应用操作之后会直接返回，
不会堵塞在那里，当后台处理完成，操作系统会通知相应的线程进行后续的操作。但目前还不够成熟，应用不多。*/
