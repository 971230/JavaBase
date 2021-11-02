package com.ljf.company.day15;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author 龙江锋
 * @Date 2021/3/15 20:11
 * @Version 1.0
 *
 * HashMap
 * 5.1 前言
 * HashMap的键要同时重写hashCode()和equals()
 *
 * hashCode()用来判定二者的hash值是否相同,重写后根据属性生成
 * equals()用来判断属性的值是否相同,重写后,根据属性判断
 *
 * --equals()判断数据如果相等,hashCode()必须相同
 * --equals()判断数据如果不等,hashCode()尽量不同
 *
 * 5.2概述
 *       HashMap底层是一个Entry[]数组,当存放数据时,会根据hash算法来计算数据的存放位置
 *       算法:hash(key)%n , n就是数组的长度,其实也就是集合的容量
 *       当计算的位置没有数据的时候,会直接存放数据
 *       当计算的位置,有数据时,会发生hash冲突/hash碰撞,解决的办法就是采用链表的结构,
 *       在对应的数据位置存放链表的头节点,对于这个链表来说,每次新加的节点会从头部位置开始加入,
 *       也就是说,数组中的永远是新节点.
 */
public class HashMaps {
    public static void main(String[] args) {

        //1.创建HashMap对象
        HashMap<Integer,String> hashMap = new HashMap<>(16);

        hashMap.put(1, "2");
        System.out.println(hashMap.get(1));

        /*
         * 源码摘抄:
         * static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
         * 初始容量为1<<4,相当于   1*(2^4) = 16
         * static final float DEFAULT_LOAD_FACTOR = 0.75f;
         * 默认的加载因子是0.75,也就是说容量达到了与初识容量的75%就开始扩容,按照2的次幂进行扩容
         *
         * 达到容量的加载因子后,就会重新开辟空间,重新计算所有对象的存储位置,也叫做rehash
         * 设置初始容量与加载因子要讲求相对平衡,如果加载因子过低,则rehash过于频繁,影响性能
         * 如果初始容量设置太高或者加载因子设置太高,影响查询效率
         * 过大的扩容因子会导致碰撞概率大大提升，过小扩容因子会造成存储浪费
         */

        /* ********************************************************************/
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 2);
        treeMap.put(2, 3);
        System.out.println(treeMap);

        /* ******************************************************************/
        //继承自hashMap，底层仍然是基于拉链式散列结构即由数组和链表或红黑树实现的。
        //另外LinkedHashMap在上面的结构基础上，增加了一条双向链表，使得上面的结构可以保证键值对的插入顺序。
        //同时对链表的响应操作，实现了访问顺序相关逻辑
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "2");
        linkedHashMap.put(2, "3");
        System.out.println(linkedHashMap);

        /* ****************************************************************/

        /*ConcurrentHashMap在保证线程安全的同时降低了锁的粒度，让并发操作效率更高*/
        //底层采用分段的数组加链表实现
        ConcurrentHashMap<Integer,String> concurrentHashMap
                = new ConcurrentHashMap<>(16);

        concurrentHashMap.put(1, "阿萨德");
        concurrentHashMap.put(2, "蛐蛐儿二无");


        System.out.println(concurrentHashMap);
        System.out.println(concurrentHashMap.mappingCount());

        /* ***************************************************************/

        Hashtable<Integer,String> hashtable = new Hashtable<>();
        hashtable.put(1,"1");
        System.out.println(hashtable.get(1));

        /* *******************************************************************/

        /*在SynchronizedMap内部维护了一个普通对象Map，还有排斥锁mutex
        * 我们在调用这个方法的时候就需要传入一个Map，可以看到有两个构造器，如果你传入了mutex参数，
        * 则将对象排斥锁赋值为传入的对象。如果没有，则将对象排斥锁赋值为this，
        * 即调用synchronizedMap的对象，就是上面的Map。创建出synchronizedMap之后，
        * 再操作map的时候，就会对方法上锁，
        * */

        Collections.synchronizedMap(new HashMap<>(16));

    }
}


/*
* HashMap扩容
    成长因子：
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

* HashMap是数组 + 链表 + 红黑树（JDK1.8增加了红黑树部分）实现的
*
*
* 前面的讲述已经发现，当你空间只有仅仅为10的时候是很容易造成2个对象的hashcode 所对应的地址是一个位置的情况。
* 这样就造成 2个 对象会形成散列桶（链表）。这时就有一个加载因子的参数，值默认为0.75 ，
* 如果你hashmap的空间有 100那么当你插入了75个元素的时候 hashmap就需要扩容了，
* 不然的话会形成很长的散列桶结构，对于查询和插入都会增加时间，因为它要一个一个的equals比较。
* 但又不能让加载因子很小，如0.01，这样显然是不合适的，频繁扩容会大大消耗你的内存。
* 这时就存在着一个平衡，jdk中默认是0.75，当然负载因子可以根据自己的实际情况进行调整。
********************************************************************************************
* HashMap中的put()和get()的实现原理
*
    ①、map.put(k,v)实现原理
    （1）、首先将k,v封装到Node对象当中（节点）。
    （2）、然后它的底层会调用K的hashCode()方法得出hash值。
    （3）、通过哈希表函数/哈希算法，将hash值转换成数组的下标，下标位置上如果没有任何元素，
          就把Node添加到这个位置上。
          如果说下标对应的位置上有链表。此时，就会拿着k和链表上每个节点的k进行equal。
          如果所有的equals方法返回都是false，那么这个新的节点将被添加到链表的末尾。
          如其中有一个equals返回了true，那么这个节点的value将会被覆盖。

    ②、map.get(k)实现原理
    (1)、先调用k的hashCode()方法得出哈希值，并通过哈希算法转换成数组的下标。
    (2)、通过上一步哈希算法转换成数组的下标之后，在通过数组下标快速定位到某个位置上。
        重点理解如果这个位置上什么都没有，则返回null。
        如果这个位置上有单向链表，那么它就会拿着参数K和单向链表上的每一个节点的K进行equals，
        如果所有equals方法都返回false，则get方法返回null。
        如果其中一个节点的K和参数K进行equals返回true，那么此时该节点的value就是我们要找的value了，
        get方法最终返回这个要找的value。
*/
