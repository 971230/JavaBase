package com.ljf.company.day15;

import java.util.*;

/**
 * @Author 龙江锋
 * @Date 2021/3/15 19:53
 * @Version 1.0
 *
 * set接口
 * 1.1  概述
 * 1.     Set是一个不包含重复数据的Collection
 * 2.     Set集合中的数据是无序的(因为Set集合没有下标)
 * 3.     Set集合中的元素不可以重复 – 常用来给数据去重
 *
 * 1.2  Set集合的特点
 * 1.     数据无序且数据不允许重复
 * 2.     HashSet : 底层是哈希表，包装了HashMap，相当于向HashSet中存入数据时，会把数据作为K，
 *                  存入内部的HashMap中。当然K仍然不许重复。
 * 3.     set2 : 底层是TreeMap,也是红黑树的形式,便于查找数据
 */
public class Sets {
    public static void main(String[] args) {

        //1.创建对象
        //Set s = new Set();//报错,Set是接口,接口不可以实例化,也就是创建对象
        Set<String> set = new HashSet<>();

        //2.set集合数据存放测试
        //向set集合添加数据
        set.add("牛气冲天");
        //向set集合添加重复的数据
        set.add("牛气冲天");
        //向set集合添加重复的数据
        set.add("牛气冲天");
        //向set集合添加数据
        set.add("虎虎生威");
        //向set集合添加字符串String类型的null数据
        set.add("null");
        //向set集合添加数据null值
        set.add(null);


        /*总结1:set集合中的元素都是无序的*/
        /*总结2:set集合中的元素不能重复*/
        /*总结3:set集合中可以存放null元素,也只允许存放0-1个*/
        //查看set集合中的元素
        System.out.println(set);


        //3.set集合常用方法测试
        //set.clear();//清空Set集合
        //false,判断set集合中是否包含指定元素"小兔纸"
        System.out.println(set.contains("小兔纸"));
        //false,判断set集合对象与指定元素是否相等
        System.out.println(set.equals("牛气冲天"));
        //1961052313,获取当前set集合对象的哈希码
        System.out.println(set.hashCode());
        //false,判断当前集合是否为空
        System.out.println(set.isEmpty());
        //false,移除指定元素,没有"null"元素,所以返回false
        System.out.println(set.remove("null"));
        //true,成功移除指定元素null,所以返回true
        System.out.println(set.remove(null));

        System.out.println(set);
        //2,获取当前set集合的元素个数,类似数组长度
        System.out.println(set.size());
        //把集合中的元素放入数组中
        Object[] array = set.toArray();
        //使用数组工具类查看数组中的元素
        System.out.println(Arrays.toString(array));



        //4.集合间的操作
        Set<String> set2 = new HashSet<>();
        //给set2集合添加指定元素
        set2.add("小老许");
        set2.add("小流犊");
        set2.add("小脑斧");
        set2.add("小兔纸");
        System.out.println(set2);

        //true,把集合set2中的元素添加到set集合中,成功返回true
        System.out.println(set.addAll(set2));
        //true,判断set集合中是否包含set2集合中的所有元素,如果包含返回true
        System.out.println(set.containsAll(set2));
        //ture,移除set集合中属于set2集合的所有元素
        System.out.println(set.removeAll(set2));
        //false,判断set集合中是否包含set2集合中的所有元素,不包含返回false
        System.out.println(set.containsAll(set2));
        System.out.println(set.retainAll(set2));


        /*retainAll()方法是取两个集合直接的公共部分,谁调用,影响谁*/
        set.add("小海滕");
        set2.add("小海滕");
        //set没变
        System.out.println(set.retainAll(set));
        //set还剩set与set2的交集,set改变
        System.out.println(set.retainAll(set2));
        //set2还剩set2与set的交集,set2改变
        System.out.println(set2.retainAll(set));
        System.out.println(set);
        System.out.println(set2);


        //5.集合的迭代
        //5.1获取集合的迭代器
        Iterator<String> it = set2.iterator();
        //5.2判断集合是否有下个元素
        while(it.hasNext()) {
            //5.3如果有,进循环获取当前遍历到的元素
            //String s = it.next();
            System.out.println(it.next());
        }
    }
}
