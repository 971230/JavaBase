package com.ljf.company.day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;


/**
 * @Author 龙江锋
 * @Date 2021/3/12 19:06
 * @Version 1.0
 *
 * Collection接口
 * 前言:
 *       Java语言的java.util包中提供了一些集合类,这些集合类又称之为容器
 *       提到容器不难想到数组,集合类与数组最主要的不同之处是,数组的长度是固定的,集合的长度是可变的
 *       数组的访问方式比较单一,插入/删除等操作比较繁琐,而集合的访问方式比较灵活
 *       常用的集合类有List集合,Set集合,Map集合,其中List集合与Set集合继承了Collection接口,
 *       各个接口还提供了不同的实现类.
 *
 *
 * 2.1  概述
 * 集合的英文名称是Collection,是用来存放对象的数据结构,而且长度可变,可以存放不同类型的对象,
 * 并且还提供了一组操作成批对象的方法.Collection接口层次结构 中的根接口,接口不能直接使用,
 * 但是该接口提供了添加元素/删除元素/管理元素的父接口公共方法.
 * 由于List接口与Set接口都继承了Collection接口,因此这些方法对于List集合和Set集合是通用的.
 *
 * 2.2 集合的继承结构
 * Collection接口
 *        --List 接口 : 数据是有下标的,所以数据是有序的,可以存重复值
 *               --ArrayList子类
 *               --LinkedList子类
 *        --Set 接口 : 数据是没有下标的,所以数据是无序的,不可以存重复的值
 *               --HashSet子类
 *        --Map 接口 : 键值对的方式存数据
 *               --HashMap子类
 */

public class Collections {
    public static void main(String[] args) {

        //1.创建Collection接口相关对象
        //Collection c = new Collection();//报错,因为Collection是接口不能实例化new

        /*1.<Integer>是泛型,用来约束集合中的元素的类型,只能写引用类型,不能是基本类型*/
        Collection<Integer> c = new ArrayList<>();

        //2.1测试常用方法--对于单个集合的方法
        //向集合中添加元素
        c.add(100);
        c.add(200);
        c.add(300);
        c.add(400);
        c.add(500);
        //直接打印查看集合中的元素
        System.out.println(c);

        //c.clear();//清空集合中的所有元素
        //System.out.println(c);

        //true,判断集合中是否包含元素300
        System.out.println(c.contains(300));
        //127240651,返回集合对应的哈希码值
        System.out.println(c.hashCode());
        //false,判断集合是否为空
        System.out.println(c.isEmpty());
        //true,移出集合中的元素100,移出成功返回true
        System.out.println(c.remove(100));
        //[200, 300, 400, 500],100被成功移除
        System.out.println(c);
        //4,获取集合的元素个数/类似数组长度
        System.out.println(c.size());
        //false,判断c是否与200相等
        System.out.println(c.equals(200));


        /*接返回值类型快捷键:Shift+alt+L*/
        //把集合中的元素放入数组
        Object[] array = c.toArray();
        //使用数组的工具类查看数组中的元素内容
        System.out.println(Arrays.toString(array));


        //2.2测试常用方法--集合间的操作
        Collection<Integer> c2 = new ArrayList<>();

        //给c2集合添加元素
        c2.add(2);
        c2.add(4);
        c2.add(6);
        //[2, 4, 6],直接打印查看c2集合的内容
        System.out.println(c2);

        //把c2集合添加到c集合中
        c.addAll(c2);
        //[200, 300, 400, 500, 2, 4, 6],追加操作
        System.out.println(c);
        //false,没有保存c2元素
        System.out.println(c.contains(c2));
        //true,查看c集合是否包含c2集合中的所有元素
        System.out.println(c.containsAll(c2));
        //ture,提取c和c2的交集,直接修改集合
        System.out.println(c.retainAll(c2));
        //true,删除c集合中属于c2集合的所有元素
        System.out.println(c.removeAll(c2));
        //[200, 300, 400, 500],查看c集合删除c2集合后的结果,正确删除
        System.out.println(c);
        //System.out.println(c.retainAll(c2));//true,删除c集合
        //System.out.println(c);//[]


        //2.3 用来遍历/迭代集合中的元素 Iterator<E> iterator()
        /*
         * 1.如何获取迭代器 c.iterator()
         * 2.判断集合是否有下个元素 it.hasNext()
         * 3.获取当前迭代到的元素 it.next()
         */
        Iterator<Integer> it = c.iterator();
        //通过iterator迭代器,循环获取集合中的元素
        while(it.hasNext()) {
            //hasNext()用来判断集合中是否有下个元素,有就返回true,继续循环取值
            //next()用来获取迭代到的元素
            Integer num = it.next();
            System.out.println(num);
        }
    }
}
