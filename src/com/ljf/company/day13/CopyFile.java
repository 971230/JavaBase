package com.ljf.company.day13;

import java.io.*;
import java.util.Scanner;

/**
 * @Author 龙江锋
 * @Date 2021/3/12 18:35
 * @Version 1.0
 *
 * 本类用于测试文件复制
 * 需求: 接收用户输入的文件路径来进行复制,复制到用户指定的路径下
 */
public class CopyFile {
    public static void main(String[] args) {
        //1.提示并接收用户输入的要复制的源文件路径--复制啥
        System.out.println("请输入源文件路径:");
        //导包的快捷键:Ctrl+Shift+O  接收返回值:Alt+Shift+L
        String f = new Scanner(System.in).nextLine();

        //2.提示并接收用户输入的目标文件所在的位置--复制到哪
        System.out.println("请输入目标文件的路径:");
        String t = new Scanner(System.in).nextLine();

        //3.1根据源文件路径封装from文件对象
        File from = new File(f);
        //3.2根据目标文件路径封装to文件对象
        File to = new File(t);
        //3.3根据用户提供的路径完成文件的复制操作
        //自定义复制文件的方法--字符流--只能操作字符相关文件
        //characterCopy(from,to);
        //自定义复制文件的方法--字节流--操作啥都行
        biteCopy(from,to);
    }

    /**自定义复制文件的方法--字节流--操作文件都行*/
    public static void biteCopy(File from, File to) {
        //定义在整个方法中都生效的字节输入流对象,注意是局部变量,需要初始化,对象的默认值是null
        InputStream in = null;
        //定义在整个方法中都生效的字节输出流对象,注意是局部变量,需要初始化,对象的默认值是null
        OutputStream out = null;
        try {
            //1.读取from文件--操作文件的是字节输入流
            in = new BufferedInputStream(new FileInputStream(from));
            //2.写出到to文件--操作文件的是字节输出流
            out = new BufferedOutputStream(new FileOutputStream(to));

            //3.边读边写
            //定义变量b,记录读取到的数据
            int b;
            //只有没有数据时,才返回-1,跳出循环,读写结束
            while( (b = in.read()) != -1 ) {
                //将读到的数据b写出到文件
                out.write(b);
            }
            System.out.println("恭喜您!文件复制成功!");
        } catch (IOException e) {
            System.out.println("很抱歉!文件复制失败!");
            e.printStackTrace();//打印错误信息
        }finally {
            //释放资源
            try {
                assert out != null;
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**自定义复制文件的方法--字符流--只能操作字符相关文件*/
    public static void characterCopy(File from, File to) {//字符流操作
        //定义在整个方法中都生效的字符输入流对象,注意是局部变量,需要初始化,对象的默认值是null
        Reader in = null;
        //定义在整个方法中都生效的字符输出流对象,注意是局部变量,需要初始化,对象的默认值是null
        Writer out = null;
        try {
            //1.读取from文件--获取字符流输入对象
            in = new BufferedReader(new FileReader(from));
            //2.写出到to文件中--获取字符流输出对象
            out = new BufferedWriter(new FileWriter(to));
            //3.边读边写
            //定义变量,保存读到的数据
            int b;
            //当没有数据时,返回-1,读取循环结束
            while( (b = in.read()) != -1 ) {
                //将本轮循环读取到的内容写出
                out.write(b);
            }
            System.out.println("恭喜您!文件复制完成!");
        } catch (IOException e) {
            System.out.println("很抱歉!文件复制失败!");
            e.printStackTrace();//正常打印报错信息
        } finally {//finally是try-catch结构中一定会执行的部分,也就是如果有必须执行到的代码,可以写在这

            /* 1.流资源必须释放,释放的是之前使用过程中所有流对象
             * 2.关流是有顺序的,注意,后出现的流先释放,为了不影响代码*/
            //4.释放资源
            try {//用来关闭字符输出流,先关闭
                assert out != null;
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {//用来关闭字符输入流,后关闭
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
