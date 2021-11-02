package com.ljf.company.day12;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Author 龙江锋
 * @Date 2021/3/11 20:09
 * @Version 1.0
 *
 * 2.IO简介
 * 2.1 继承结构
 * In/out 相对于程序而言的输入(读取)/输出(写出)的过程.
 * 在java中,根据处理的数据单位不同,分为字节流和字符流
 * 字节流 : 针对二进制文件,字节流读取单个字节，字节流用来处理二进制文件(图片、MP3、视频文件)
 * 字符流 : 针对文本文件,读写容易出现乱码的现象,在读写时,最好指定编码集为UTF-8
 *          字符流读取单个字符(一个字符根据编码的不同，对应的字节也不同，
 *          如 UTF-8 编码是 3 个字节，中文编码是 2 个字节。)
 *          字符流用来处理文本文件(可以看做是特殊的二进制文件，使用了某种编码，人可以阅读)。
 *
 *          简而言之，字节是个计算机看的，字符才是给人看的。
 *
 *    Java.io包下:
 *    File
 *    字节流:针对二进制文件
 *
 *    InputStream
 *       --FileInputStream
 *       --BufferedInputStream
 *       --ObjectInputStream
 *
 *    OutputStream
 *       --FileOutputStream
 *       --BufferedOutputStream
 *       --ObjectOutputStream
 *
 * 字符流:针对文本文件
 *
 * Reader
 *    --FileReader
 *    --BufferedReader
 *    --InputStreamReader
 *
 * Writer
 *    --FileWriter
 *    --BufferedWriter
 *    --OutputStreamWriter
 *    --PrintWriter一行行写出
 *
 * 2.2  Stream流的概念
 * *  数据的读写可以抽象成数据在管道中流动
 * *  流只能单方向流动
 * *  输入流用来读取 -> in
 * *  输出流用来写出 -> out
 * *  数据只能从头到尾顺序的读写一次
 *
 *
 * 3.File文件流
 * 3.1概述
 *       封装一个磁盘路径字符串,对这个路径可以执行一次操作
 *       可以封装文件路径、文件夹路径、不存在的路径
 *
 * 3.2创建对象
 *    File(String pathname)通过将给定路径名字符串转换为抽象路径名来创建一个新的File实例
 *    new File(“d:/abc/a.txt”);
 *    new File(“d:/abc”,”a.txt”);
 */
public class Files {
    public static void main(String[] args) throws IOException {

        //1.创建File文件对象
        //参数是具体的路径,这个路径可以是文件路径,也可以是文件夹路径
        //注意:此处需要自己手动的在D盘下创建对应目录以及1.txt文件,并在1.txt文件中添加内容

        /*\在代码中具有特殊的意义,所以想要真正表示这是一个斜杠,需要用\进行转义*/
        //创建的是java对象
        File file = new File("D:\\ready\\1.txt");


        //2.测试常用方法
        //2.1文件与文件夹属性
        //16--获取指定文件的字节量
        System.out.println(file.length());
        //true -- 判断指定文件是否存在
        System.out.println(file.exists());
        //true -- 判断指定内容是否为文件
        System.out.println(file.isFile());
        //false --判断指定内容是否为文件夹
        System.out.println(file.isDirectory());
        //1.txt -- 获取指定文件的名字
        System.out.println(file.getName());
        //D:\ready --获取指定文件的上级,父级目录
        System.out.println(file.getParent());
        //D:\ready\1.txt  --获取指定内容的绝对路径
        System.out.println(file.getAbsolutePath());


        //2.2创建与删除
        file = new File("D:\\ready\\2.txt");

        //如果指定创建文件的文件夹不存在,会报错:java.io.IOException: 系统找不到指定的路径。
        //file = new File("D:\\Error\\2.txt");
        /*可能会发生错误,所以需要抛出异常IOException*/
        //在windows中创建不存在的文件,2.txt被自动创建成功
        //true
        System.out.println(file.createNewFile());


        file = new File("D:\\ready\\m");
        //创建不存在的单级文件夹,m文件夹自动创建成功
        //true
        System.out.println(file.mkdir());

        file = new File("D:\\ready\\a\\b\\c");
        //创建不存在的多级文件夹,a\b\c被自动创建成功
        //true
        System.out.println(file.mkdirs());


        //删除文件或者删除空的文件夹,c文件夹被删除
        //true
        System.out.println(file.delete());
        file = new File("D:\\ready\\a");
        //由于a目录里还有b目录,不为空,所以删除不了a目录
        //false
        System.out.println(file.delete());



        //文件列表
        file = new File("D:\\ready");

        /* 查看文件夹中的所有文件的名称,返回值类型是String[]*/
        String[] listName = file.list();
        //[1.txt, 2.txt, a, m]
        System.out.println(Arrays.toString(listName));

        /*列出文件夹中所有的文件夹和文件对象,返回值是File[],每个数组元素都是file对象,操作性强*/
        File[] fs = file.listFiles();
        //[D:\ready\1.txt, D:\ready\2.txt, D:\ready\a, D:\ready\m]
        System.out.println(Arrays.toString(fs));
        assert fs != null;
        System.out.println(fs[0].length());
    }
}
