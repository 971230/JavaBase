package com.ljf.company.day08;

/**
 * @Author 龙江锋
 * @Date 2021/3/7 19:47
 * @Version 1.0
 *
 * static
 * 1.1  概念
 * 是java中的一个关键字,用于修饰成员（成员变量和成员方法）
 *
 * 1.2  特点
 * 1)  可以修饰成员变量与成员方法
 * 2)  随着类的加载而加载，优先于对象加载
 * 3)  只加载一次,就会一直存在,不再开辟新空间,直到类消失才一起消失
 * 4)  静态资源也叫做类资源,全局唯一,被全局所有对象共享
 * 5)  可以直接被类名调用
 * 6)  静态只能调用静态，非静态可以随意调用
 * 7)  static不能和this或者super共用，因为有static时可能还没有对象
 */
public class Day08 {
    public static void main(String[] args) {

        /*3.静态资源可以通过类名直接调用*/
        /*4.静态资源是优先于对象加载的,随着类的加载而加载,比对象先加载进入内存,
        没对象也可以直接被类名调用*/
        //4.通过类名直接调用静态资源进行测试,无需创建对象
        System.out.println(Student.name);
        Student.study();
        
        //3.创建对象进行测试,非静态要创建对象
        Student s = new Student();
        System.out.println(s.age);
        //s.study();错，可以通过类名直接调用
        s.speak();
        Student.study();

        //6.通过s对象修改name属性的值
        Student.name = "黄桃罐头";
        //System.out.println(s.name);错，可以通过类名直接调用
        System.out.println(Student.name);

        //5.测试多个对象访问静态资源
        Student s2 = new Student();
        System.out.println(s2.age);
        //System.out.println(s2.name);错
        System.out.println(Student.name);
    }
}

/** 1.创建学生类*/
class Student{

    //2.定义属性和方法
    /*1.可以使用static关键字将普通资源修饰成静态资源，全局唯一，全局共享*/
    /**2.static可以用来修饰成员变量/方法,一般写在权限修饰符之后*/
    static String name = "海绵宝宝";
    int age = 1;
    public static void study() {
        System.out.println("别闹,我学JAVA呢~~~");
    }
    public void speak(){
        System.out.println("speak");
    }
}
