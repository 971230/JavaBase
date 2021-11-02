package com.ljf.company.day15;

import java.util.Objects;

/**
 * @Author 龙江锋
 * @Date 2021/3/15 20:02
 * @Version 1.0
 */
public class Student {
    //1.提供对应对象的属性并进行封装

    private String name;
    private int age;
    private String addr;

    /*注意1:如果提供了含参/全参构造,需要手动添加无参构造,否则创建对象时必须传参*/
    /*注意2:我们可以通过快捷方式生成构造方法:右键--Source--Generate Constructor using fields...*/
    /**注意3:给对象的属性赋值,可以通过构造方法[创建对象时直接赋值]/set()[创建对象后调用公共的设置方法赋值]*/
    //2.1提供无参构造

    public Student() {
        System.out.println("我是无参构造");
    }

    /** 2.2提供含参构造*/
    public Student(String name, int age, String addr) {
        super();
        this.name = name;
        this.age = age;
        this.addr = addr;
        System.out.println("我是全参构造");
    }

    //3.提供公共的get()/set()

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**注意5:重写是为了能够看到对象的属性值*/
    //4.重写toString()

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", addr=" + addr + "]";
    }

    //5.重写hashCode() & equals()
    //重写hashCode():我们并不想使用自动计算出的哈希值,而是要根据对象的属性值进行计算,
    //如果两个对象的属性值都相同,想生成同一个哈希码
    //重写equals():我们想比较的不是对象的地址值(==),而是如果两个对象的属性值都一样,则返回true


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(addr, student.addr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, addr);
    }
}
