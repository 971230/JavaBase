package com.ljf.company.day14;

import java.util.*;

/**
 * @Author 龙江锋
 * @Date 2021/3/12 19:15
 * @Version 1.0
 *
 * List接口
 * 3.1  概述
 * 有序的collection(也称为序列).此接口的用户可以对列表中的每个元素的插入位置进行精确的控制,
 * 用户可以根据元素的整数索引(在列表中的位置)来访问元素,并搜索列表中的元素.
 *
 * 3.2  特点
 * 1.     元素都有下标
 * 2.     数据是有序的
 * 3.     允许存放重复的元素
 */
public class Lists {
    public static void main(String[] args) {

        //1.创建List接口对象,注意此处创建的多态对象,List是接口,不能直接实例化
        //注意导包:java.util...导包快捷键:Ctrl+Shift+O
        List<String> list = new ArrayList<>();

        //2.测试继承自Collection接口的方法
        //向集合中添加元素
        list.add("大力娃");
        list.add("千顺娃");
        list.add("铁头娃");
        list.add("喷火娃");
        list.add("喷水娃");
        list.add("隐身娃");
        list.add("小紫娃");

        //查看集合中的所有元素
        System.out.println(list);

        //list.clear();清空集合
        //System.out.println(list);//[],集合已清空
        System.out.println("**********我是一个无情的分界线**************");


        //判断是否包含元素"大哥"
        System.out.println(list.contains("大力娃"));
        //false,判断list对象是否与"铁头娃"相等
        System.out.println(list.equals("铁头娃"));
        //
        System.out.println("铁头娃".equals(list));
        //获取集合的哈希码值
        System.out.println(list.hashCode());
        //判断集合是否为空
        System.out.println(list.isEmpty());
        //移除集合中的元素"五哥"
        System.out.println(list.remove("喷水娃"));
        //查看集合中的内容
        System.out.println(list);
        //获取集合的元素个数,类似于数组的长度
        System.out.println(list.size());

        //将集合中的元素存入数组中,打印需要使用数组的工具类Arrays
        //[大哥, 二哥, 三哥, 四哥, 六哥, 七弟]
        System.out.println(Arrays.toString(list.toArray()));



        //3.List接口的特有方法  -- 都是可以根据索引来操作的方式
        //追加在最后
        list.add("小蝴蝶");

        System.out.println(list);
        //在指定索引处添加指定的元素
        list.add(1,"蝎子精");

        System.out.println(list);
        //根据指定下标获取对应的元素
        System.out.println(list.get(2));

        list.add(3,"小蝴蝶");

        System.out.println(list);
        //获取指定元素第一次出现的索引
        System.out.println(list.indexOf("小蝴蝶"));
        //获取指定元素最后一次出现的索引
        System.out.println(list.lastIndexOf("小蝴蝶"));
        //删除指定索引的元素
        System.out.println(list.remove(6));
        //修改指定索引处位置的值
        System.out.println(list.set(0, "妖精蛇"));
        System.out.println(list);


        //截取子集合,[2,6)含头不含尾,不改变原集合
        List<String> subList = list.subList(2, 6);
        System.out.println(subList);

        //4.集合间的操作
        List<String> list2 = new ArrayList<>();

        list2.add("1");
        list2.add("2");
        list2.add("3");
        //把list2集合添加到list集合中
        System.out.println(list.addAll(list2));
        //把list2集合添加到list集合的指定位置处
        System.out.println(list.addAll(1,list2));
        System.out.println(list );
        //判断list集合是否有一个叫list2的元素
        System.out.println(list.contains(list2));
        //判断list集合是否包含list2集合中的所有元素
        System.out.println(list.containsAll(list2));
        //删除list集合中list2集合中的所有元素
        System.out.println(list.removeAll(list2));
        System.out.println(list);
    }
}

