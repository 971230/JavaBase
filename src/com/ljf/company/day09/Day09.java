package com.ljf.company.day09;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @Author 龙江锋
 * @Date 2021/3/7 20:59
 * @Version 1.0
 *
 * 异常
 * 1.1 概述
 * 用来封装错误信息的对象
 * 组成结构:类型 提示 行号
 *
 *
 * 1.2 异常的继承结构
 * Throwable : 顶级父类
 * -- Error : 系统错误,无法修复
 * -- Exception : 可以修复的错误
 * -- RunTimeException
 * -- ClassCastException
 * -- ClassNotFoundException
 * -- ...
 *
 * 1.3 异常处理
 * 当程序中遇到了异常,通常有两种处理方式:捕获或者向上抛出
 * 当一个方法抛出异常,调用位置可以不做处理继续向上抛出,也可以捕获处理异常

 * 1) 捕获方式：
 * try{
 * 需要捕获的代码
 * }catch(异常类型 异常名){
 * 处理方案
 * }
 *
 * 2) 抛出方式：
 * 在会发生异常的方法上添加代码：throws 异常类型
 * 例如：public static void main(String[] args)  throws Exception{
 * 本类用于测试异常入门案例
 *
 *总结8:如果方法抛出异常,那么谁调用谁需要解决(继续抛出/捕获解决)
 *  * 所以main()调用了method2(),也需要抛出异常
 *  * 注意,我们一般在main()调用之前捕获解决异常,而不是抛给main(),因为没人解决了
 */
public class Day09 {
    public static void main(String[] args) throws Exception {

        //1.创建method(),用来人为的暴露异常
        //method();
        //2.catchException(),用来进行异常的捕获
        //catchException();
        //3.throwException(),用来进行异常的抛出
        //throwException();
    }

    /*
    * 抛出的语法:
    * 在可能会抛出异常的方法上加throws 异常类型
    * 在抛出时,也可以使用多态,不管会发生什么异常,通通被Exception跑出去
    */

    /** public static void method3()
    throws ArithmeticException,InputMismatchException,Exception{
     */
    public static void throwException() throws Exception{

        //1.复写刚刚可能会发生异常的代码
        method();
    }

    /**
     * 捕获的语法:
     * try{
     * 可能会发生异常的代码
     * }catch(异常类型 异常参数名){
     * 如果捕获到异常的解决方案
     * }
     */
    public static void catchException() {

        //1.按照捕获语法编写try-catch结构
        /*总结4:try{}里放的是可能会发生异常的代码*/
        try {
            //2.复写刚刚可能会发生异常的代码
            method();

            /*总结5:如果发生异常被捕获,就被匹配对应的解决方案*/
        } catch (ArithmeticException e) {//3.1异常捕获1
            //3.2异常处理1
            System.out.println("除数不能为0!");
            method();

        /*总结6:由于程序中可能存在多种异常,所以catch可以配合多次使用*/
        } catch (InputMismatchException e) {//4.1异常捕获2
            //4.2异常处理2
            System.out.println("输入的类型不正确,请输入正确的整数类型!");
            method();

        /*总结7:如果还有上述两种异常之外的异常,用Exception匹配捕获
        * 这个就是多态最为经典的一种用法,我们不关心子类的类型
        * 只要是可解决异常,都是Exception的子类,多态会把这些异常当做父类来看,捕获,通过通用方案进行解决
        */
        }catch (Exception e) {
            System.out.println("请输入正确的整数!");
            method();
        }
        /*finally {
            System.out.println("资源回收块");
        }*/
    }

    public static void method() {

        //1.提示并接收用户输入的两个整数:
        System.out.println("请输入两个整数:");
        int a = new Scanner(System.in).nextInt();
        int b = new Scanner(System.in).nextInt();

        //2.输出除法运算的结果
        //2.1输入9.9 --java.util.InputMismatchException[输入不匹配异常]
        //2.2输入9/0 --java.lang.ArithmeticException: / by zero[算术异常,除0了]
        System.out.println(a / b);

        /*总结1:不要害怕BUG,真正的勇士敢于直面自己写的BUG*/
        /*总结2:学会看报错信息的错误提示,确定自己错误的方向*/
        /*总结3:学会看报错信息的行号提示,哪里报错点哪里,注意,源码不会错,看自己写的代码*/
    }
}
