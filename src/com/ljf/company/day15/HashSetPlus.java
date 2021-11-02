package com.ljf.company.day15;

import java.util.HashSet;

/**
 * @Author 龙江锋
 * @Date 2021/3/15 20:05
 * @Version 1.0
 *
 * 本类用于给自定义对象去重测试
 *
 * *总结:
 * 1.如果想用set集合给自定义的对象去重,那么需要在自己的类中同时提供重写的hashCode()与equals()
 *      底层源码: if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k))))
 *      重写hashCode():我们并不想使用自动计算出的哈希值,而是要根据对象的属性值进行计算,
 *      如果两个对象的属性值都相同,想生成同一个哈希码
 *      重写equals():我们想比较的不是对象的地址值(==),而是如果两个对象的属性值都一样,则返回true
 *
 *      hashCode()和equals()的相关规定
 *      1.如果两个对象相等，则hashcode也一定相等
 *      2.两个对象相等，对两个equals()方法返回true
 *      3.两个对象有相同的hashcode值，他们也不一定相等
 *      4.综上.equals()方法被重写，则hashCode()必须重写
 *      5.hashCode()的默认行为是对堆上面的对象产生独特值。如果没有重写hashCode()，
 *        则该class的两个对象无论如何都不会相等(即使两个对象指向相同的数据)
 */
public class HashSetPlus {
    public static void main(String[] args) {

        //1.创建set集合对象
        HashSet<Student> set = new HashSet<>();
        //新版JDK中后面的泛型类型与尖括号都可以不写,三种方式皆可,想用哪个用哪个
        //Set<Student> set = new HashSet<>();
        //Set<Student> set = new HashSet();


        //2.1创建自定义对象
        Student s1 = new Student("tony",38,"BeiJin");
        Student s2 = new Student("susan",20,"ShangHai");
        Student s3 = new Student("Jack",3,"ShenZhen");


        //创建对象,与之前对象的属性值完全一致
        Student s4 = new Student("susan",20,"ShangHai");
        Student s5 = new Student("Jack",3,"ShenZhen");


        //3.查看两个对象的哈希码
        System.out.println("s2对象的哈希码:" + s2.hashCode());
        System.out.println("s4对象的哈希码:" + s4.hashCode());


        //2.2把自定义的student对象添加到set集合中
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        set.add(s5);

        /* 总结:
         * 重复的给set集合添加了属性相同的对象,为什么没有像之前那样去重呢?
         * 翻阅源码,得知:需要保证两个条件:
         * ①.保证对象拥有相同的哈希码值
         *      --底层默认使用的是Object提供的hashCode()来计算哈希码值,每次new对象,默认的哈希码值是不同的
         *      解决方案:如果想根据两个对象的属性值来计算哈希值,就需要重写hashCode(),保证对象拥有相同的hash码值
         *      (p.hash == hash &&((k = p.key) == key || (key != null && key.equals(k))))
         * ②.保证两个对象的equals()返回true
         *      --底层默认使用的是Object提供的逻辑,== 比较,也就是说当地址值相同时,才返回true
         *      解决方案:重写equals()
         */

        System.out.println(set);
    }
}
