package com.ljf.company.day11;

import java.util.Objects;

/**
 * @Author 龙江锋
 * @Date 2021/3/11 18:16
 * @Version 1.0
 *
 * 拓展
 * 8.1 ==和equals的区别
 * 1.当使用==比较时，如果相比较的两个变量是引用类型，那么比较的是两者的物理地值（内存地址），
 *   如果相比较的两个变量都是数值类型，那么比较的是具体数值是否相等。
 *
 * 2.当使用equals()方法进行比较时，比较的结果实际上取决于equals()方法的具体实现
 *   众所周知，任何类都继承自Object类，因此所有的类均具有Object类的特性，比如String、integer等，
 *   他们在自己的类中重写了equals()方法，此时他们进行的是数值的比较，而在Object类的默认实现中，
 *   equals()方法的底层是通过==来实现的。
 */


public class Equals {

    public static void main(String[] args) {

        Person p1 = new Person("凹凸曼",16);
        Person p2 = new Person("凹凸曼",16);

        //false,new了两个对象,p1和p2保存的地址值不同
        System.out.println(p1 == p2);
        //true,name是String类型,保存在常量池中,值是同一个
        System.out.println(p1.name == p2.name);
        //true,age是int基本类型,保存的值都是18
        System.out.println(p1.age == p2.age);


        //第一次测试:结果false,使用的是Object默认的逻辑,也是用==来比较的
        //第二次测试:结果true,重写equals()后,就会使用子类重写后的功能,
        //true  也就是说此时比较的不再是地址,而是类型&属性值
        System.out.println(p1.equals(p2));

        String str = null;
        //会抛空指针异常
        //System.out.println(str.equals("null"));
        //可以翻转调用
        System.out.println("null".equals(str));
        //不会抛空指针异常(JDK7加入的工具类)
        System.out.println(Objects.equals(p1,p2));
    }
}

/** 1.创建Person类*/
class Person {

    String name;
    int age;

    public Person() {
        System.out.println("我是手动添加的无参构造");
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    //需求:比较两个对象的属性值,如果属性值都一样,就是"同一个对象",要求equals返回true
    /**    关于hashCode和equals的处理，遵循如下规则：
     * 1)  只要覆写equals，就必须覆写hashCode。
     * 2)  因为Set存储的是不重复的对象，依据hashCode和equals进行判断，
     *     所以Set存储的对象必须覆写这两个方法。
     * 3)  如果自定义对象作为Map的键，那么必须覆写hashCode和equals。
     *     说明：String已覆写hashCode和equals方法，所以我们可以愉快地使用String对象作为key来使用*/
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Person other = (Person) obj;
        if (age != other.age) {
            return false;
        }
        if (name == null) {
            return other.name == null;
        } else {
            return name.equals(other.name);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
