package com.ljf.company.day06;

/**
 * @Author 龙江锋
 * @Date 2021/3/4 18:53
 * @Version 1.0
 *
 * 概述:
 * 封装是隐藏对象的属性和实现细节,仅仅对外提供公共的访问方式,比如类和方法
 * 好处:
 * 1) 提高安全性
 * 2) 提高重用性
 *
 * private关键字
 * 是一个权限修饰符 ,可以用来修饰成员变量和成员方法.被私有化的成员只能在本类中访问
 */
public class Private {
    public static void main(String[] args) {
        //5.创建学生类对象--通过new关键字创建学生类对象
        Student student = new Student();
        //6.初步测试Student类对象student
        //可以通过"."来调用student对象的name属性,查看它的值
        System.out.println(student.name);

        student.study();//可以通过"."来调用Student对象的study()
        //7.给student对象的属性赋值
        student.name = "程序猿";
        student.sno = 666;
        student.age = 20;

        //student.subject = "Java培优";//subject封装后无法访问
        //8.查看赋值后的属性值
        System.out.println(student.name);
        System.out.println(student.sno);
        System.out.println(student.age);
        //System.out.println(student.subject);

        //10.通过Student类中提供的公共的subject属性的设置与访问方法来给subject属性赋值并查看
        student.setSubject("JavaCGB");
        System.out.println(student.getSubject());
        //student.eat();封装后无法访问
        student.study();
    }
}

//1.通过class关键字创建学生类--用来描述学生这一类型--属性+行为
/**
 * 封装:通过private关键字(权限修饰符)来修饰成员变量/成员方法
 * 被修饰的成员就实现了私有化,访问权限只能在本类中访问
 *
 * TIPS:如何封装?封装后的资源如何访问?
 * 我们可以使用private关键字来封装成员变量与方法
 * 如何访问私有资源?
 * 关于成员变量:
 * 1. setXxx – 对外提供公共的设置值方式
 * 2. getXxx – 对外提供公共的获取值方式
 * 关于成员方法:
 * 把私有方法放在公共方法里供外界调用即可
 */

class Student{
    //2.定义属性--成员变量
    /**姓名*/
    String name;
    /**学号*/
    int sno;
    /**年龄*/
    int age;
    //9.对成员变量进行封装
    /**科目*/
    private String subject;

    /**对外提供公共的属性值设置方式*/
    public void setSubject(String s) {
        subject = s;
    }

    /**对外提供公共的属性值查看方式*/
    public String getSubject() {
        return subject;
    }

    /**3.定义行为--方法*/
    public void study() {
        System.out.println("正在学习JAVA");
        /*我们可以在公共的方法里调用私有方法*/
        eat();
    }

    /**11.封装方法,只能在本类使用*/
    private void eat() {
        System.out.println("干饭人 干饭魂");
    }
}
