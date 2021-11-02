package com.ljf.company.day20;

import java.io.*;

/**
 * @Author 龙江锋
 * @Date 2021/3/21 16:56
 * @Version 1.0
 * <p>
 * 读一行写一行案例
 * 这个类用来测试一行一行读取,一行一行写出
 */
public class TestInputOutput {
    public static void main(String[] args) {

        //method();//初步测试readLine()

        //method3();

        //method2();//改进

        method4();

    }

    public static void method2() {

        BufferedReader in = null;
        PrintWriter out = null;

        try {

            //1.读取一行数据,先拿到读取数据的流,注意文件需要自己在win创建
            in = new BufferedReader(new FileReader("D:\\b.txt"));

            //2.定义变量,记录每行读取到的数据
            String line;

            //3.设置循环读取数据,只要有数据就一直读取
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            //4.一行行写出数据:PrintWriter
            out = new PrintWriter(new FileWriter("D:\\b.txt"));
            out.println("java");
            out.println("hello");
            out.flush();//为了防止有数据没有发送过去,可以刷一下
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //5.释放资源
                assert out != null;
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void method() {
        try {
            //1.读取一行数据,先拿到读取数据的流,注意文件需要自己在win创建
            BufferedReader in = new BufferedReader(new FileReader("D:\\b.txt"));

            //2.调用readLine方法进行测试
            String line = in.readLine();
            String line2 = in.readLine();
            String line3 = in.readLine();

            //测试1:b.txt没有数据时,readLine()返回null
            //测试2:b.txt有数据,而且是1整行数据,readLine()可以返回整行全部数据
            //测试3:b.txt有数据,而且是多行数据,readLine()只可以返回第1行全部数据
            /* 原因:readLine()在读取数据时,会读取特殊标记,换行符\r\n,读到换行符就结束
             * 结论:readLine()只可以读取1整行数据,如果是多行数据,需要多次调用，没有数据是为null
             * */
            //3.打印测试结果
            System.out.println(line);
            System.out.println(line2);
            System.out.println(line3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void method3(){

        /*有几行读几行*/
        try {
            BufferedReader in = new BufferedReader(new FileReader("D:\\b.txt"));
            while (in.readLine() != null){
                System.out.println(in.readLine());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void method4(){
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            /*读*/
            in = new BufferedReader(new FileReader("D:\\b.txt"));
            /*写*/
            out = new PrintWriter(new FileWriter("D:\\a.txt"));
            String data = "";
            while ((data = in.readLine()) != null){
                out.write(data);
            }
            out.flush();
            System.out.println("成功");
        }catch (Exception e){
            System.out.println("失败");
            e.printStackTrace();
        }
        finally {
            try {
                assert out != null;
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            try {
                in.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
