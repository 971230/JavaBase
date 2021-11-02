package com.ljf.company.day13;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author 龙江锋
 * @Date 2021/3/11 22:34
 * @Version 1.0
 * 字节流写出
 * 1.1 OutputStream抽象类
 *  此抽象类是表示输出字节流的所有类的超类.输出流接受输出字节并将这些字节发送到某个接收器.
 *  常用方法:
 *  Void close() 关闭此输出流并释放与此流相关的所有系统资源
 *  Void flush() 刷新此输出流并强制写出所有缓冲的输出字节
 *  Void write(byte[ ] b) 将b.length个字节从指定的byte数组写入此输出流
 *  Void write(byte[ ] b,int off ,int len) 将指定byte数组中从偏移量off开始的len个字节写入输出流
 *  Abstract void write(int b) 将指定的字节写入此输出流
 *
 * 1.2 FileOutputStream 子类
 *  直接插在文件上,直接写出文件数据
 *  构造方法(创建对象):FileOutputStream(String name)
 *
 * 创建一个向具有指定名称的文件中写入数据的文件输出流:FileOutStream(File file)
 *
 * 创建一个向指定File对象表示的文件中写入数据的文件输出流:FileOutStream(File file,boolean append)
 *      ------如果第二个参数为true,表示追加,不覆盖
 *
 * 创建一个向指定File对象表示的文件中写入数据的文件输出流,后面的参数是指是否覆盖原文件内容
 *
 * 1.3 BufferedOutputStream 子类
 * 该类实现缓冲的输出流,通过设置这种输出流,应用程序就可以将各个字节写入底层输出流中,
 * 而不必每次针对字节写出调用底层系统
 * 构造方法(创建对象):
 *
 * BufferedOutputStream(OutputStream out)
 * 创建一个新的缓冲输出流,用以将数据写入指定的底层输出流
 */
public class OutPutStream {
    public static void main(String[] args) {

        //method();//1.创建使用普通字节输出流对象输出数据
        method2();//2.创建使用高效字节输出流对象输出数据
    }

    /**高效字节输出流*/
    public static void method2() {

        //5.声明在此方法内部都生效的局部变量,并且局部变量需要初始化,对象的默认值是null
        //BufferedOutputStream out = null;也可以
        OutputStream out = null;
        try {

            //0.用来测试的路径必须是文件路径,不是文件夹路径,而且文件得存在
            //1.创建高效字节输出流对象
            //OutputStream out =new BufferedOutputStream(new FileOutputStream(new File("D:\\ready\\out.txt")));
            out = new BufferedOutputStream(new FileOutputStream("D:\\ready\\out.txt"));

            //2.开始写出数据
            //ascii码表存在对应关系:100-d
            out.write(100);
            //ascii码表存在对应关系:100-d
            out.write(100);
            //ascii码表存在对应关系:100-d
            out.write(100);
            //ascii码表存在对应关系:100-d
            out.write(100);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {/*3.要保证代码一定会被执行,就通通放在finally代码块中*/
            //4.释放资源
            try {
                assert out != null;
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**普通字节输出流*/
    public static void method() {
        //4.声明在此方法内部都生效的局部变量,并且局部变量必须初始化,对象的默认值是null
        //FileOutputStream out = null;也可以
        OutputStream out = null;
        try {
            //0.需要在windows环境下创建一个文件,路径:D:\ready\out.txt用来查看输出的数据
            //注意:指定的路径是文件路径,不是文件夹路径,而且文件得存在
            //1.创建字节输出流对象
            // new OutputStream();报错:原因:OutputStream是字节输出流的抽象父类,不能实例化
            // OutputStream out = new FileOutputStream(new File("D:\\ready\\out.txt"));
            out = new FileOutputStream("D:\\ready\\out.txt");

            //2.开始写出数据
            //ascii码表对应的关系:97--a
            out.write(97);
            //ascii码表对应的关系:98--b
            out.write(98);
            //ascii码表对应的关系:99--c
            out.write(99);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {/*如果要保证代码一定会执行,就通通放在finally代码块中*/
            //3.释放资源
            try {
                assert out != null;
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
