package com.ljf.company.day13;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @Author 龙江锋
 * @Date 2021/3/11 22:40
 * @Version 1.0
 *
 * 字符流写出
 * 2.1 Writer 抽象类
 *    写入字符流的抽象类
 *
 * 常用方法:
 * Abstract void close() 关闭此流,但要先刷新它
 * Void write(char[ ] cbuf) 写入字符数组
 * Void write(int c) 写入单个字符
 * Void write(String str) 写入字符串
 * Void write(String str,int off,int len) 写入字符串的某一部分
 * Abstract void write(char[] cbuf,int off,int len)写入字符数组的某一部分
 *
 * 2.2 FileWriter 子类
 * 用来写入字符文件的便捷类,此类的构造方法假定默认字符编码和默认字节缓冲区大小都是可接受的.
 * 如果需要自己自定义这些值,可以先在FileOutputStream上构造一个OutputStreamWriter.
 *
 * 构造方法(创建对象):FileWriter(String filename)
 * 根据给定的文件名构造一个FileWriter对象:FileWriter(String filename,boolean append)
 * 根据给定的文件名以及指示是否附加写入数据的boolean值来构造FileWriter
 *
 * 2.3 BufferedWriter子类
 * 将文本写入字符输出流,缓冲各个字符,从而提供单个字符,数组和字符串的高效写入.
 * 可以指定缓冲区的大小,或者接受默认的大小,在大多数情况下,默认值就足够大了
 *
 * 构造方法(创建对象):BufferedWriter(Writer out)
 * 创建一个使用默认大小输出缓冲区的缓冲字符输出流
 *
 *
 * 本类用于测试字符流输出数据
 *
 * 总结:
 * 效率:BufferedWriter > FileWriter
 *
 *效率不同的原因:
 *    private static int defaultCharBufferSize = 8192;
 *    因为BufferedWriter底层维护了一个char[],默认大小就是8k
 *    写出时,把数据填满数组后再一次性保存到磁盘中,比一个一个传输字符这种模式快,
 *    减少了程序和磁盘的交互次数,程序执行效率大大提高
 */
class Writers {
    public static void main(String[] args) {
        //method();//用来测试普通字符输出流对象输出数据
        method2();//用来测试高效字符输出流对象输出数据
    }

    /**高效字符输出流*/
    public static void method2() {
        //BufferedWriter out = null;//也可以
        Writer out = null;
        try {
            /*1.创建高效流对象
            out = new BufferedWriter(new FileWriter(new File("D://ready//out.txt")));
            out = new BufferedWriter(new FileWriter("D://ready//out.txt"));//默认状态,不追加*/
            //追加数据,也就是不覆盖原数据
            out = new BufferedWriter(new FileWriter("D://ready//out.txt",true));

            //2.开始写出数据
            out.write(100);
            out.write("io");
            out.write("append");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //3.关流
                assert out != null;
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**普通字符输出流*/
    public static void method() {
        //为了整个方法都可以使用out,所以要在此处先声明,并且由于out是局部变量,所以需要初始化null
        //FileWriter out = null;//也可以
        Writer out = null;
        try {
            //0.需要在windows环境下创建一个文件,路径:D:\ready\out.txt,用来查看输出的数据
            //1.创建普通字符输出流对象
            //new Writer();//报错,原因:Writer是抽象类,不能实例化,也就是new对象
            //out = new FileWriter(new File("D:\\ready\\out.txt"));
            //out = new FileWriter("D:\\ready\\out.txt");默认覆盖原文件内容

            /* 需求:保持原有的数据,在不改变原数据的基础上,在它的末尾追加新的数据*
             * 此构造方法的第二个参数表示:是否覆盖写出文件中的原有内容
             * 默认是覆盖,如果不想覆盖,则需要设置第二个参数append的值为true*/

            out = new FileWriter("D:\\ready\\out.txt",true);

            //2.输出数据
            //输出单个字母e
            out.write(101);
            //输出单个字母a
            out.write(97);
            //输出单个字母d
            out.write(100);
            //输出字符串hello
            out.write("hello");
            //输出字符串qwerty
            out.write("qwerty");
            //如果数据量太少,可能会存在数据没有写出的情况,需要刷一下数据
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                //3.关闭资源
                assert out != null;
                out.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
