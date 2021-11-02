package com.ljf.company.day12;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Author 龙江锋
 * @Date 2021/3/11 14:54
 * @Version 1.0
 *
 * BigDecimal/IO
 * 1 BigDecimal/BigInteger
 *
 * 1.1 概述
 * BigDecimal：常用来解决精确的浮点数运算
 * BigInteger： 常用来解决超大的整数运算
 *
 * 1.2 创建对象
 *    BigDecimal(double val)
 *    将double转换为BigDecimal,后者是double的二进制浮点值十进制表示形式,有坑!
 *    BigDecimal(String val)
 *    将String类型字符串的形式转换为BigDecimal
 *
 * 1.3  常用方法
 * Add(BigDecimal bd) : 做加法运算
 * Subtract(BigDecimal bd) : 做减法运算
 * Multiply(BigDecimal bd) : 做乘法运算
 * Divide(BigDecimal bd) : 做除法运算,除不尽时会抛异常
 * Divide(BigDecimal bd,保留位数,舍入方式) : 除不尽时使用
 * setScale(保留位数,舍入方式) : 同上
 * pow(int n) : 求数据的几次幂
 */
public class BigDecimals {
    public static void main(String[] args) {

        //method();//使用 + - * / 完成运算,暴露浮点数运算不精确的问题
        method2();//使用BigDecimal来解决浮点数运算不精确的现象
    }

    public static void method2() {//20:45接着继续,大家抓紧时间完成,一会我们进IO啦
        //1.提示并接收用户输入的两个小数
        System.out.println("请输入您要计算的两个小数:");
        double a = new Scanner(System.in).nextDouble();
        double b = new Scanner(System.in).nextDouble();


        //2.创建工具类对象,把基本类型的a和b交给工具类对象BigDecimal来保存
        /*计算机是二进制的。浮点数没有办法用二进制进行精确表示。
        我们的CPU表示浮点数由两个部分组成：指数和尾数，这样的表示方法一般都会失去一定的精确度，
        有些浮点数运算也会产生一定的误差*/
        /*1.最好不要使用double作为构造函数的参数,不然还会产生不精确的现象,有坑!!!!*/
        /*2.最好使用重载的,参数类型是String的构造函数,默认double转String,直接拼个空串就可以*/
        BigDecimal bd1 = new BigDecimal(a + "");
        BigDecimal bd2 = new BigDecimal(b + "");

        //3.通过BigDecimal上的方法,做精确运算
        //3.1定义对象来保存结果
        BigDecimal bd3 = bd1.add(bd2);

        //3.2 add(BigDecimal bd) : 做加法运算
        System.out.println(bd3);

        //3.3 subtract(BigDecimal bd) : 做减法运算
        bd3 = bd1.subtract(bd2);
        System.out.println(bd3);

        //3.4 multiply(BigDecimal bd) : 做乘法运算
        bd3 = bd1.multiply(bd2);
        System.out.println(bd3);

        //3.5 add(BigDecimal bd) : 做除法运算
        /*java.lang.ArithmeticException,除法运算,除不尽时会抛异常*/
        //--方案一
        //bd3 = bd1.divide(bd2);
        /*divide(m,n,o) --m是要除以哪个对象保存的值,n要保留几位,o是舍入方式,最常使用的是四舍五入*/
        //方案二:
        bd3 = bd1.divide(bd2, 30, BigDecimal.ROUND_HALF_UP);
        System.out.println(bd3);
    }

    public static void method() {

        //1.提示并接收用户输入的两个小数
        System.out.println("请输入您要计算的两个小数:");
        double a = new Scanner(System.in).nextDouble();
        double b = new Scanner(System.in).nextDouble();

        //2.做运算
        //不精确
        System.out.println( a + b );
        //不精确
        System.out.println( a - b );
        //不精确
        System.out.println( a * b );
        //不精确
        System.out.println( a / b );
    }
}
/*舍入方式解析
ROUND_HALF_UP 四舍五入,五入 如:4.4结果是4; 4.5结果是5
ROUND_HALF_DOWN 五舍六入,五不入 如:4.5结果是4; 4.6结果是5
ROUND_HALF_EVEN 公平舍入(银行常用)
比如:在5和6之间,靠近5就舍弃成5,靠近6就进位成6,如果是5.5,就找偶数,变成6
ROUND_UP 直接进位,不算0.1还是0.9,都进位
ROUND_DOWN 直接舍弃,不算0.1还是0.9,都舍弃
ROUND_CEILING(天花板) 向上取整,取实际值的大值
朝正无穷方向round 如果为正数，行为和round_up一样，如果为负数，行为和round_down一样
ROUND_FLOOR(地板) 向下取整,取实际值的小值
朝负无穷方向round 如果为正数，行为和round_down一样，如果为负数，行为和round_up一样
 */
