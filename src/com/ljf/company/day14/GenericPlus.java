package com.ljf.company.day14;

/**
 * @Author 龙江锋
 * @Date 2021/3/12 19:04
 * @Version 1.0
 */
public class GenericPlus {
    public static void main(String[] args) {

        //需求:打印指定数组中的所有元素
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        print(a);

        String[] b = {"大哥", "二哥", "三哥", "四哥", "五哥", "六哥", "小弟"};
        print(b);

        Double[] c = {6.0, 6.6, 6.66, 6.666, 6.6666};
        print(c);
    }

    /*1.泛型可以实现通用代码的编写,使用E表示元素的类型是Element类型 -- 可以理解成神似多态*/
     /**2.泛型的语法要求:如果在方法上使用泛型,必须两处同时出现,
      * 一个是传入参数的类型,一个是返回值前的泛型类型,表示这是一个泛型*/
    public static <E> void print(E[] element) {
        for(E d :element) {
            System.out.println(d);
        }
    }


//    public static void print(Double[] c) {
//        for(Double d : c) {
//            System.out.println(d);
//        }
//    }
//    public static void print(String[] b) {
//        for(String s : b) {
//            System.out.println(s);
//        }
//    }
//
//    public static void print(Integer[] a) {
//        //使用普通循环遍历数组比较复杂,引入高效for循环
//        //普通循环的好处是可以控制循环的步长(怎么变化)
//        int x = 2;
//        for (int i = 0; i < a.length; i = i + x) {
//            System.out.println(a[i]);
//        }
//        /*
//        * 高效for/foreach循环--如果只是单纯的从头到尾的遍历,使用增强for循环
//        * 好处:比普通的for循环写法简便,而且效率高
//        * 坏处:没有办法按照下标来操作值,只能从头到尾依次遍历
//        * 语法:for(1 2 : 3){代码块} 3是要遍历的数据
//        *      1是遍历后得到的数据的数据类型 2是遍历起的数据名(要遍历的数据)
//        */
//        for(Integer i : a) {
//            System.out.println(i);
//        }
//    }
}
