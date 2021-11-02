package com.ljf.company.day15;

import java.util.*;

/**
 * @Author 龙江锋
 * @Date 2021/3/15 20:08
 * @Version 1.0
 *
 * Map接口
 * 3.1 概述
 *       Java.util接口Map<K,V>
 *       类型参数 : K - 表示此映射所维护的键  V – 表示此映射所维护的对应的值
 *       也叫做哈希表、散列表. 常用于键值对结构的数据.其中键不能重复,值可以重复
 *
 * 3.2 特点
 *       1. Map可以根据键来提取对应的值
 *       2. Map的键不允许重复,如果重复,对应的值会被覆盖
 *       3. Map存放的都是无序的数据
 *       4. Map的初始容量是16,默认的加载因子是0.75
 *
 * TIPS:源码摘抄:
 * static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
 * 初始容量1<<4,相当于1*(2^4),也就是16
 * static final float DEFAULT_LOAD_FACTOR = 0.75f;
 * 默认的加载因子是0.75f,也就是存到75%开始扩容,按照2的次幂进行扩容
 *
 *
 * 3.3 继承结构
 *
 * 3.4 常用方法
 * 学习Collection接口中的方法即可
 *  void clear()  从此映射中移除所有映射关系（可选操作）。
 *  boolean containsKey(Object key)  如果此映射包含指定键的映射关系，则返回 true。
 *  boolean containsValue(Object value)  如果此映射将一个或多个键映射到指定值，则返回 true。
 *  Set<Map.Entry<K,V>> entrySet()  返回此映射中包含的映射关系的 Set 视图。
 *  boolean equals(Object o)  比较指定的对象与此映射是否相等。
 *  V get(Object key)  返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。
 *  int hashCode()  返回此映射的哈希码值。
 *  boolean isEmpty()  如果此映射未包含键-值映射关系，则返回 true。
 *  Set<K> keySet()  返回此映射中包含的键的 Set 视图。
 *  V put(K key, V value) 将指定的值与此映射中的指定键关联（可选操作）。
 *  void putAll(Map<? extends K,? extends V> m)从指定映射中将所有映射关系复制到此映射中（可选操作）。
 *  V remove(Object key)  如果存在一个键的映射关系，则将其从此映射中移除（可选操作）。
 *  int size()  返回此映射中的键-值映射关系数。
 *  Collection<V> values()返回此映射中包含的值的 Collection 视图。
 */
public class Maps {
    public static void main(String[] args) {

        //1.创建Map对象
        //map中的数据要符合映射规则,一定注意要同时指定K和V的数据类型
        //至于K和V需要指定成什么类型的数据,取决于你的具体需求
        //HashMap(int initialCapacity, float loadFactor):构造一个空 HashMap具有指定的初始容量和加载因子。
        Map<Integer,String> map = new HashMap<>(32, (float) 0.8);

        //2.常用方法测试
        //添加数据,需要同时指定K和V
        //向map集合添加数据
        map.put(9527, "白骨精");
        map.put(9528, "黑熊精");
        map.put(9528, "唐三藏");
        map.put(1, "者行孙");
        map.put(2, "行者孙");
        map.put(null,"1");
        map.put(null,null);
        map.put(5,null);

        /*
         * 总结1:Map存放的都是无序数据
         * 总结2:Map中的key不可以重复,如果重复,此Key对应的值会被覆盖
         * map打印结果: {null=1, 1=者行孙, 2=行者孙, 5=null, 9527=白骨精, 9528=唐三藏}
         */

        //查看map集合中的元素
        System.out.println(map);

        //map.clear();//清空map集合
        //true,判断当前map集合是否包含指定的key
        System.out.println(map.containsKey(9527));
        //false,判断当前map集合是否包含指定的value
        System.out.println(map.containsValue("土地老儿"));
        //false,判断"者行孙"与map是否相等
        System.out.println(map.equals("者行孙"));
        //者行孙,根据对应的key来获取对应的value
        System.out.println(map.get(1));
        //84598429,获取当前map集合的哈希码
        System.out.println(map.hashCode());
        //false,判断当前map集合是否为空
        System.out.println(map.isEmpty());
        //者行孙,删除map中key对应的value,正确删除后返回被删除元素
        System.out.println(map.remove(1));
        //null,没有拿到任何元素,根据指定的key获取对应value
        System.out.println(map.get(1));
        //5,获取集合中元素的个数
        System.out.println(map.size());
        //把map中的所有value收集起来放到collection中
        Collection<String> values = map.values();
        //[白骨精, 唐三藏]
        System.out.println(values);



        //对map集合进行迭代
        /*方式一
         * 遍历map中的数据,需要把map集合转换成set集合
         * Set<K> keySet() : 把map集合中的所有的key存到set集合中
         */

        Set<Integer> a = map.keySet();

        //想要遍历set集合,需要先拿到集合的迭代器对象
        Iterator<Integer> it = a.iterator();

        //判断集合中是否有下个元素,如果有,继续迭代,如果没有,跳出循环
        while(it.hasNext()) {
            //依次获取/set集合中的每一个key
            Integer key = it.next();
            //通过key获取对应的value
            String value = map.get(key);
            System.out.println("{" + key + "," + value + "}");
        }

        /*方式二
         * 遍历map中的数据,需要把map集合转换成set集合
         * Set<Entry<Integer,String>> entrySet() : 把map集合中的一组key&value数据整体放入set中
         * 一对儿 K,V 是一个Entry
         */

        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        //遍历set集合,得到每个Entry对象
        //获取此set集合对应的迭代器对象it2
        Iterator<Map.Entry<Integer, String>> it2 = entrySet.iterator();

        while(it2.hasNext()) {
            Map.Entry<Integer, String> entry = it2.next();
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println("[" + key + ":" + value + "]");
        }
    }
}
