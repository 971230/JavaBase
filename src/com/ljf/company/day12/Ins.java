package com.ljf.company.day12;

import java.io.*;

/**
 * @Author 龙江锋
 * @Date 2021/3/11 20:23
 * @Version 1.0
 *
 * 字符流读取
 * 常用于处理纯文本数据
 *
 * 5.1 Reader抽象类
 * 用于读取字符流的抽象类。
 *
 * 常用方法：
 *   int read() 读取单个字符
 *   int read(char[] cbuf) 将字符读入数组
 *   abstract  int read(char[] cbuf, int off, int len) 将字符读入数组的某一部分
 *   int read(CharBuffer target) 试图将字符读入指定的字符缓冲区
 *   abstract  void close() 关闭该流并释放与之关联的所有资源
 *
 * 5.2 FileReader子类
 * 用来读取字符文件的便捷类。此类的构造方法假定默认字符编码和默认字节缓冲区大小都是适当的。要自己指定这些值，可以先在 FileInputStream 上构造一个 InputStreamReader。
 *
 * 创建对象
 *   FileReader(String fileName) 在给定从中读取数据的文件名的情况下创建一个新 FileReader
 *   FileReader(File file)  在给定从中读取数据的 File 的情况下创建一个新 FileReader
 *
 * 5.3 BufferedReader子类
 * 从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。
 * 可以指定缓冲区的大小，或者可使用默认的大小。大多数情况下，默认值就足够大了。
 *
 * 创建对象
 *   BufferedReader(Reader in)  创建一个使用默认大小输入缓冲区的缓冲字符输入流
 */
public class Ins {
    public static void main(String[] args) {

        //method();//普通字符流读取
        method2();//高效字符流读取
    }

    /**①.测试普通字符流的读取对象*/
    public static void method() {
        //FileReader in = null;也可以
        Reader in = null;
        try {
            //.创建用来读取的普通字符流的读取对象
            //Reader in = new Reader();//Reader是字符流读取的父类,而且是一个抽象类,不能new
            //Reader in = new FileReader(new File("D:\\ready\\1.txt"));//传入的是file对象
            //传入的是路径
            in = new FileReader("D:\\ready\\1.txt");


            //2.开始读取,read()每次读取一个字符,如果读取到了数据的末尾,返回-1
            //System.out.println(in.read());//97
            //System.out.println(in.read());//98
            //System.out.println(in.read());//99
            //System.out.println(in.read());//100
            //System.out.println(in.read());//-1

            //3.需求:重复的读取文件中的所有内容
            //3.1定义变量,记录读取到的数据
            int b;
            //3.2循环读取文件中所有内容,只要不是-1,就表示还有数据,继续循环
            while( (b = in.read()) != -1) {
                System.out.println(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //4.释放资源
                assert in != null;
                in.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**②.测试高效字符流的读取对象*/
    public static void method2() {
        //BufferedReader in = null;也可以
        Reader in = null;
        try {
            //.创建高效的字符流的读取对象
            //Reader in = new Reader();//Reader是字符流读取的父类,而且是一个抽象类,不能new
            /*BufferedReader是高效的字符读取流,原因是底层维护了一个char[],默认的容量也是8*1024字节8k*/
            //in = new BufferedReader(new FileReader((new File("D\\ready\\1.txt"))));/传入的是file对象
            //传入的是路径
            in = new BufferedReader(new FileReader("D\\ready\\1.txt"));


            //2.开始读取,read()每次读取一个字符,如果读取到了数据的末尾,返回-1
            //System.out.println(in.read());//97
            //System.out.println(in.read());//98
            //System.out.println(in.read());//99
            //System.out.println(in.read());//100
            //System.out.println(in.read());//-1

            //3.需求:重复的读取文件中的所有内容
            //3.1定义变量,记录读取到的数据
            int b;
            //3.2循环读取文件中所有内容,只要不是-1,就表示还有数据,继续循环
            while( (b = in.read()) != -1) {
                System.out.println(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //4.释放资源
                assert in != null;
                in.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
