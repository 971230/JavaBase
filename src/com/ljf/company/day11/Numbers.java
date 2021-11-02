package com.ljf.company.day11;

/**
 * @Author 龙江锋
 * @Date 2021/3/11 18:09
 * @Version 1.0
 *
 * 包装类
 * 把基本类型进行包装，提供更加完善的功能。
 * 基本类型是没有任何功能的,只是一个变量,记录值,而包装类可以有更加丰富的功能
 *
 * 6.1  与基本类型的对应关系
 *
 * 6.2  Number
 * 数字包装类的抽象父类。
 * 提供了各种获取值的方式。
 *
 * 6.2.1 子类
 *
 * 6.2.2 常用的方法
 *
 * 6.3  Integer
 * 6.3.1 创建对象
 * 1. new Integer(5);
 * 2. Integer.valueOf(5);
 * 在Integer类中，包含256个Integer缓存对象，范围是 -128到127。
 * 使用valueOf()时，如果指定范围内的值，访问缓存对象，而不新建；如果指定范围外的值，直接新建对象。
 *
 * 6.3.2 常见方法
 * static int parseInt(String s)  将字符串参数作为有符号的十进制整数进行解析
 */
public class Numbers {
    public static void main(String[] args) {

        //①.创建int基本类型的包装类Integer的对象方式1
        /*1.Integer包装类的默认值是null*/
        Integer i0;
        Integer i1 = new Integer(5);

        //②.创建int基本类型的包装类Integer的对象方式2
        /*2.Integer有一个高效的效果(-128~127)
         * 因为静态的valueOf(),相同的数据只会存一次,后续再存都会使用已经存过的数据*/

        Integer i2 = Integer.valueOf(127);
        Integer i3 = Integer.valueOf(127);

        Integer i4 = Integer.valueOf(300);
        Integer i5 = Integer.valueOf(300);

        //false,== 比较的是地址值
        System.out.println(i1.equals(i2));
        //true,是Integer,并且是在(-128~127)范围内,相同数据只存一次
        System.out.println(i2.equals(i3));
        //false,是Integer,但是不在(-128~127)范围内,所以存了两次,两个对象
        System.out.println(i4.equals(i5));

        //3.创建Double对象
        Double d1 = new Double(3.4);
        Double d2 = Double.valueOf(3.4);
        Double d3 = Double.valueOf(3.4);


        //false,只有Integer包装类有高效的效果
        System.out.println(d2.equals(d3));
        //4.测试常用方法
        //原因:parseInt()已经把字符串8000转换成了int类型的数字8000,可以参与运算
        //8010,执行了加法运算
        System.out.println(Integer.parseInt("8000") + 10);
        //3.2,执行了加法运算
        System.out.println(Double.parseDouble("2.2") + 1);
    }
}
