package com.ljf.company.day13;

import java.io.*;
import java.util.Scanner;

/**
 * @Author 龙江锋
 * @Date 2021/3/12 18:39
 * @Version 1.0
 *
 * 本类用于完成文件的批量读取
 */
public class BatchCopy {
    public static void main(String[] args) {

        //1.提示并接收用户输入的要复制的源文件路径--复制啥
        System.out.println("请输入源文件路径:");
        String f = new Scanner(System.in).nextLine();
        //2.提示并接收用户输入的目标文件所在的位置--复制到哪
        System.out.println("请输入目标文件的路径:");
        String t = new Scanner(System.in).nextLine();

        //3.1根据源文件路径封装from文件对象
        File from = new File(f);
        //3.2根据目标文件路径封装to文件对象
        File to = new File(t);

        //3.3根据用户提供的路径完成文件的复制操作
        //自定义复制文件的方法--字节流--操作啥都行
        biteCopy(from,to);
    }

    /**批量读取文件复制*/
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
            /*需求:想要实现批量读取,使用的是read(byte[] b)重载的形式,可以按照数组的方式来读 */
            /*可以自定义数组,长度建议与源码保持一致,8*1024 = 8192*/
            int b;
            byte[] batch = new byte[8192];
            //只有没有数据时,才返回-1,跳出循环,读写结束
            while((b = in.read(batch)) != -1) {
                //将读到的数据写出到文件
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
}
