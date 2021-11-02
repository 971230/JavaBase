package com.ljf.company.day12;

import java.io.*;

/**
 * @Author 龙江锋
 * @Date 2021/3/11 20:18
 * @Version 1.0
 *
 * 字节流读取
 * 字节流是由字节组成的,字符流是由字符组成的.
 * Java里字符由两个字节组成.字节流是基本，主要用在处理二进制数据。
 * 流式传输主要指将整个音频和视频及三维媒体等多媒体文件经过特定的压缩方式解析成一个个压缩包，
 * 由视频服务器向用户计算机顺序或实时传送。在采用流式传输方式的系统中，
 * 用户不必像采用下载方式那样等到整个文件全部下载完毕，
 * 而是只需经过几秒或几十秒的启动延时即可在用户的计算机上利用解压设备对压缩的A/V、3D等多媒体文件
 * 解压后进行播放和观看。此时多媒体文件的剩余部分将在后台的服务器内继续下载。
 *
 * 4.1 InputStream抽象类
 * 此抽象类是表示字节输入流的所有类的超类/抽象类,不可创建对象哦
 *
 *    常用方法：
 *    abstract  int read() 从输入流中读取数据的下一个字节
 *    int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中
 *    int read(byte[] b, int off, int len) 将输入流中最多 len 个数据字节读入 byte 数组,
 *    off表示存时的偏移量
 *    void close() 关闭此输入流并释放与该流关联的所有系统资源
 *
 * 4.2 FileInputStream子类
 * 直接插在文件上，直接读取文件数据
 * 创建对象
 *
 * FileInputStream(File file)—直接传文件对象
 * 通过打开一个到实际文件的连接来创建一个 FileInputStream，
 *   该文件通过文件系统中的 File 对象 file 指定FileInputStream(String pathname)—传路径
 * 通过打开一个到实际文件的连接来创建一个 FileInputStream，
 *   该文件通过文件系统中的路径名 name 指定
 *
 * 4.3 BufferedInputStream子类
 * BufferedInputStream 为另一个输入流添加一些功能，即缓冲输入以及支持 mark 和 reset 方法的能力。
 * 在创建 BufferedInputStream 时，会创建一个内部缓冲区数组(默认8k大小)。在读取或跳过流中的字节时，
 * 可根据需要从包含的输入流再次填充该内部缓冲区，一次填充多个字节。
 *
 * 创建对象
 * BufferedInputStream(InputStream in)
 * 创建一个 BufferedInputStream 并保存其参数，即输入流 in，以便将来使用。
 */
public class In {
    public static void main(String[] args) {
        //method();//字节流的读取
        method2();//高效字节流的读取
    }

    public static void method2() {
        InputStream in = null;
        try {
            //1.创建高效字节流的读取对象
            //BufferedInputStream是高效的读取流,原因在于底层维护了一个byte[]
            //InputStream in = new BufferedInputStream(new FileInputStream(new File("D:\\ready\\1.txt")));
            in = new BufferedInputStream(new FileInputStream("D:\\ready\\1.txt"));

            //2.开始读取,read()每次读取一个字节,如果读取到了数据的末尾,返回-1
            //System.out.println( in.read() );//97
            //System.out.println( in.read() );//98
            //System.out.println( in.read() );//99
            //System.out.println( in.read() );//-1
            //System.out.println( in.read() );//-1


            //3.开始读取,read()每次读取一个字节,所以我们现在需要重复的读取读取文件中的所有字节
            //3.1定义变量,记录读到的数据
            int b;

            //3.2开始循环,直到没有内容,结束循环
            while((b = in.read()) != -1) {
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

    public static void method() {
        InputStream in = null;
        try {
            //1.创建字节流的读取对象
            //InputStream in = new InputStream();//报错:原因:InputStream是字节流读取的父类,而且是抽象类,不能new
            //传入的是File对象
            //InputStream in = new FileInputStream(new File("D:\\ready\\1.txt"));
            //传入的是路径,保证此路径下的文件是存在的且有内容
            in = new FileInputStream("D:\\ready\\1.txt");


            //2.开始读取,read()每次读取一个字节,如果读取到了数据的末尾,返回-1
            //97
            //System.out.println(in.read());
            //98
            //System.out.println( in.read() );
            //99
            //System.out.println( in.read() );
            //-1
            //System.out.println( in.read() );
            //-1
            //System.out.println( in.read() );


            //3.需求:重复的读取文件中的所有字节
            int b;//3.1定义变量,记录读到的数据
            //3.2返回值为-1的时候,表示没有数据了,循环结束
            while((b = in.read()) != -1) {
                //3.3打印每次循环读取到的内容
                System.out.println(b);
            }
        } catch (IOException e) {
            //打印错误信息
            e.printStackTrace();
        }finally {//finally中的代码一定会执行
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
