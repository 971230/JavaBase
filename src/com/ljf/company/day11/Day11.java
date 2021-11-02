package com.ljf.company.day11;

import java.util.Objects;

/**
 * @Author 龙江锋
 * @Date 2021/3/11 14:53
 * @Version 1.0
 *
 * API概念
 * API（Application Programming Interface，应用程序接口）是一些预先定义的函数。
 * 目的是提供应用程序与开发人员基于某软件可以访问的一些功能集，
 * 但又无需访问源码或理解内部工作机制的细节.
 *
 * API是一种通用功能集,有时公司会将API作为其公共开放系统,也就是公司制定自己的系统接口标准,
 * 当需要进行系统整合,自定义和程序应用等操作时,公司所有成员都可以通过该接口标准调用源代码.
 *
 *
 * Java.util包是java中的工具包,包含各种实用工具类/集合类/日期时间工具等各种常用工具包
 * import java.util.Scanner;
 * import java.util.Arrays;
 *
 * java.lang包是java的核心,包含了java基础类,
 * 包括基本Object类/Class类/String类/基本数学类等最基本的类
 * 这个包无需导入,默认会自动导入
 * import java.lang.Object;
 * import java.lang.String;
 * import java.lang.StringBuilder/StringBuffer;
 * 正则表达式
 * 包装类等等
 *
 *
 * Object
 * 2.1 概念
 *       Object类是所有Java类的祖先,也就是说我们所说的”顶级父类”
 *      存在于java.lang.Object,这个包不需要我们手动导包
 *      每个类都使用Object作为超类.所有对象(包括数组)都实现这个类的方法.
 *      在不明确给出超类的情况下,Java会自动把Object类作为要定义类的超类.
 *
 *
 * 2.2 常用方法介绍
 * 2.2.1 toString()
 *    本方法用于返回对应对象的字符串表示.
 *
 * 2.2.2 hashCode()
 *    本方法用于返回对应对象的哈希码值
 *    TIPS:哈希码是一种算法,使不同的对象有不同的哈希码值,但是也有相同的情况,我们称之为”哈希碰撞”
 *
 * 2.2.3 equals()
 *    本方法用于指示其他某个对象是否与当前对象”相等”
 */
public class Day11 {
    public static void main(String[] args) {

        /*测试toString():返回该对象的字符串表示*/
        //3.创建Student对象
        Student s = new Student("jack", 18);

        //4.打印学生对象,查看属性值是否赋值成功
        //第一次测试:打印结果:cn.tedu.api.Student@60357d4,s对象的地址值
        /*查看源码的方式:按住Ctrl键,鼠标移动到目标上即可*/
        //原因:在打印对象的s时,底层会自动调用Object类中的toString(),本来的实现方式就是打印地址值
        //public String toString()
        // {return getClass.getName() + "@" +Integer.toHexString(hashCode());}


        //6.再次打印学生对象s
        //第二次测试:结果:Student [name=jack, age=18]
        //原因:重写了Object的toString()后,就可以打印对象的属性值了
        System.out.println(s);
        //Student{name='jack', age=18},可以省略toString()，结果一样
        System.out.println(s.toString());

        /*测试hashCode():返回对象在内存中的哈希码值*/
        //7.调用下查看hashCode()的结果
        //460141958
        System.out.println(s.hashCode());

        //8.创建对象s2与s对象属性值相同
        Student s2 = new Student("jack", 18);

        //第一次测试:结果:false(还没有重写equals()，底层用的==比较地址值，一定不一样)
        //底层:用了==进行对象间的比较,==比较的是两个对象的地址值,s与s2是两个对象.
        //    地址值不同,所以返回false
        //public boolean equals(Object obj) {return (this == obj);}
        //需求:比较s和s2对象,如果属性值相同,就认为是用一个对象,并让equals()返回true
        //第二次测试:结果:true
        //false，没有重写equals时
        System.out.println(s.equals(s2));
        //true
        System.out.println(s.equals2(s2));
    }
}

/** 1.创建Student类并定义属性*/
class Student {

    String name;
    int age;

    /**2.生成构造方法
    方式一:右键,选择Generate,选择Constructor*/
    public Student() {}//添加了含参构造后,记得手动添加无参构造
    public Student(String name, int age) {
        super();//默认存在
        this.name = name;
        this.age = age;
    }

    /**5.重写toString(),查看对象的属性值,否则会使用Object中的默认实现,查看对象的地址值
    方式一:右键,选择Generate,选择toString()...*/
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**9.重写equals()
    需求:比较s和s2对象,如果属性值相同,就认为是用一个对象,并让equals()返回true
    自己写的*/
    public boolean equals2(Object obj) {
        //判断,如果是学生,咱俩比较,如果连学生都不是,就返回false--匹配种类
        //同一个类型的对象间比较：instanceof判断是不是此类型或此类型的超类
        if(obj instanceof Student) {
            //把obj强转成Student类型,因为想用子类的特有属性,如果不转,只能用父类的属性
            Student argsStudent = (Student)obj;
            //判断:如果当前对象this和参数对象argsStudent,他们的属性&属性值完全一样,就返回true
            return this.name.equals(argsStudent.name) && this.age == argsStudent.age;
        }
        return false;
    }

    /**自动生成equals() and hashcode()
    方式一:右键,选择Generate,选择equals() and hashcode()*/
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

