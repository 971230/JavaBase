package com.ljf.company.day15;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * @Author 龙江锋
 * @Date 2021/3/15 19:59
 * @Version 1.0
 *
 *    HashSet
 * 2.1  概述
 * 底层是哈希表,包装了HashMap,相当于向HashSet中存入数据时,
 * 会把数据作为K存入内部的HashMap中,其中K不允许重复,允许使用null.
 */
public class HashSets {
    public static void main(String[] args) {

        //1.创建HashSet对象
        HashSet<Integer> set = new HashSet<>();


        //2.向HashSet集合添加元素
        set.add(100);
        set.add(200);
        set.add(300);
        set.add(200);
        set.add(200);
        set.add(400);
        set.add(500);

        /*总结1:HashSet中的元素没有顺序,且不允许重复*/
        //[400, 100, 500, 200, 300]
        System.out.println(set);


        //3.测试常用方法
        //set.clear();//清空set集合
        //true,判断集合是否包含指定元素
        System.out.println(set.contains(200));
        //false,判断集合是否为空
        System.out.println(set.isEmpty());
        //true,移除集合中的指定元素
        System.out.println(set.remove(100));
        System.out.println(set.size());


        //4.迭代set集合
        //获取集合的迭代器用来遍历
        Iterator<Integer> it = set.iterator();
        //判断集合中是否有下一个元素,没有则跳出循环
        while(it.hasNext()) {
            //获取当前遍历到的元素
            Integer num = it.next();
            //打印当前遍历到的元素
            System.out.println(num);
        }

        //treeSet:有序唯一，红黑树
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);

        System.out.println(treeSet);

        treeSet.remove(1);
        System.out.println(treeSet);


        //是hashSet的子类，并且其内部是通过LinkedHashMap来实现的
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("1");
        linkedHashSet.add("2");
        System.out.println(linkedHashSet);
    }
}
