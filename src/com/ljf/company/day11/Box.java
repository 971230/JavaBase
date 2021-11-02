package com.ljf.company.day11;

/**
 * @Author 龙江锋
 * @Date 2021/3/11 18:14
 * @Version 1.0
 *
 * 自动装箱和自动拆箱
 * 7.1  概述
 * 自动装箱：把 基本类型 包装成对应的 包装类型 的过程
 * Integer a = 5;//a是引用类型，引用了包装对象的地址。
 * 编译器会完成对象的自动装箱：Integer a = Integer.valueOf(5);
 *
 *
 * 自动拆箱：从包装类型的值，自动变成 基本类型的值
 * int i = a;//a现在是包装类型，没法给变量赋值，需要把5取出来。
 * 编译器会完成自动拆箱：int i = a.intValue();
 */
public class Box {
    public static void main(String[] args) {

        //1.定义包装类型的数据
        //之前的方式:创建包装类型的两种方式(区别):
        //①Integer引用类型变量a中储存在堆中开辟的空间的地址，地址中储存100
        Integer i11 = new Integer(127);
        //②直接调用Integer的属性valueOf,将int类型的10，隐式加包为Integer类型的10
        // 再将转化后的10储存在Integer引用类型变量a中
        Integer i22 = Integer.valueOf(127);

        Integer a = new Integer(100);
        Integer b = new Integer(100);
        Integer c = Integer.valueOf(100);
        Integer d = Integer.valueOf(100);
        Integer e = Integer.valueOf(1000);
        Integer f = Integer.valueOf(1000);

        //false,a/b只是存储了地址值
        System.out.println(a == b);
        //ture
        System.out.println(c == d);
        //false,有加包范围
        System.out.println(e == f);

        /*
        public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
        }

        Integer类型中的valueOf类的源代码
        该代码表示valueOf的隐士加包是有范围的只能加包-128~127，超过这个范围将用new Integer的方法。
        因此将代码中的100改为1000，两个输出将都是false，而且所用的方法也一样都是在堆中调用一个地址用来储存值，
        Integer类型的变量，储存地址
        */


        //现在的方式:
        /*1.自动装箱:编译器会自动把基本类型int数据5,包装成包装类型Integer,然后交给i1保存
         * 自动装箱底层发生的代码:Integer.valueOf(5);
         * valueOf()的方向:int --> Integer*/

        //不会报错,这个现象就是自动装箱
        Integer i1 = 5;

        /*2.自动拆箱:编译器会自动把包装类型的5,拆掉箱子,变回到基本类型数据5
         * 自动拆箱底层发生的代码:i1.intValue()
         * intValue()的方向:Integer --> int*/
        //不会报错,这个现象就是自动拆箱
        int i2 = i1;
    }
}
