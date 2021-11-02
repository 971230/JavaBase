package com.ljf.company.day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @Author 龙江锋
 * @Date 2021/3/15 18:46
 * @Version 1.0
 *
 * ArrayList
 * 4.1 概述
 *    1. 存在java.util包中
 *    2. 内部是用数组结构存放数据,封装数组的操作,每个对象都有下标
 *    3. jdk1.7中(饿汉式):在初始化ArrayList时会创建一个长度为10的数组,每次进行数组扩容时，扩容为原来的1.5倍
 *       jdk1.8中(懒汉式--节省内存):在初始化ArrayList时，不会创建数组,在第一次进行数据添加时才会创建一个长度为10的数组
 *    4. 查询快,增删数据效率会低
 *
 * 4.2 创建对象
 *        ArrayList() 构造一个初始容量为10的空序列
 *        源码摘抄:int newCapacity = oldCapacity + (oldCapacity >> 1);
 *        解释:数组的新容量 = 旧容量/2的一次方 --相当于原来的1.5倍扩容
 */
public class ArrayLists {
    public static void main(String[] args) {

        //1.创建对象,使用的是无参构造,底层会自动帮我们创建数组存放对象,并且数据的初始容量是10
        //可以用指定的初始容量构造一个空列表，int initialCapacity参数
        ArrayList<String> list = new ArrayList<>();

        //2.放入数据进行测试常用方法
        //向集合中添加元素
        list.add("100");
        list.add("200");
        list.add("300");
        list.add("400");
        list.add("300");
        list.add("200");

        //在指定下标处新增元素
        list.add(0,"777");
        System.out.println(list);


        //list.clear();//清空集合
        //System.out.println(list);

        //true,判断集合是否包含元素300
        System.out.println(list.contains(300));
        //777,获取集合中指定下标位置上的元素
        System.out.println(list.get(0));
        //2,判断集合中指定元素第一次出现的下标
        System.out.println(list.indexOf(200));
        //6,判断集合中指定元素最后一次出现的下标
        System.out.println(list.lastIndexOf(200));
        //false,判断集合是否为空
        System.out.println(list.isEmpty());
        //100,移除集合中指定下标对应着的元素,移除成功,返回被移除的元素
        System.out.println(list.remove(1));

        /*
         *Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 300, Size: 6
         *这是根据下标来删除元素的,而此集合没有下标300,最大下标为6,所以会数组下标越界
         *System.out.println(list.remove(300));--错误
         *如果想根据具体的元素内容移除元素,需要先把int类型的数据转成Integer数据类型
         */
        //true,最好使用下标操作
        System.out.println(list.remove(300));
        System.out.println(list.remove(Integer.valueOf(300)));

        System.out.println(list);
        //更改集合中对应下标上元素的值
        System.out.println(list.set(2, "77"));

        System.out.println(list);

        System.out.println(list.size());
        //将集合元素存入数组,打印数组的具体值
        System.out.println(Arrays.toString(list.toArray()));



        //4种迭代方式
        //方式1:for循环

        System.out.println("方式1");
        //开始:0   结束:最大下标(集合长度-1)  变化:++
        for (int i = 0; i < list.size(); i++) {
            //根据下标获取对应下标位置上的元素
            System.out.print(list.get(i));
        }
        //逆序遍历
        for (int i = list.size() - 1; i >= 0; i--){
            System.out.println(list.get(i));
        }

        //方式2:增强for循环
        System.out.println("方式2");
        //遍历list集合,每次循环得到的元素是Integer类型的i
        for (String i : list) {
            //打印每次循环到的集合元素
            System.out.print(i);
        }

        //方式3:Iterator
        /*1.获取迭代器  2.判断是否还有元素(一般用来做循环条件)  3.获取当前遍历到的元素*/
        System.out.println("方式3");

        //获取集合用来迭代的迭代器,此迭代器是继承自Collection接口中的
        Iterator<String> iterator = list.iterator();
        //通过迭代器来判断集合中是否还有元素,如果有,继续迭代,如果没有,结束循环
        while(iterator.hasNext()) {
            //获取当前遍历到的集合元素
            //String num = it.next();
            //打印当前遍历到的集合元素
            System.out.print(iterator.next());
        }

        //方式4:ListIterator
        System.out.println("方式4");
        //获取集合用来迭代的迭代器,此迭代器是List接口中的迭代器
        ListIterator<String> listIterator = list.listIterator();
        //通过迭代器来判断集合中是否还有元素,如果有继续迭代,如果没有,结束循环
        while(listIterator.hasNext()) {
            //获取当前遍历到的集合元素
            //String s2 = it2.next();
            //打印当前遍历到的集合元素
            System.out.print(listIterator.next());
        }
    }
}
