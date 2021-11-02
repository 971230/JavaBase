package com.ljf.company.day19;

/**
 * @Author 龙江锋
 * @Date 2021/3/21 16:32
 * @Version 1.0
 *
 * 内部类
 * 1.1 概述
 * 如果一个类存在的意义就是为另一个类使用，可以把这个类放入另一个类的内部。
 * 就是把类定义在类的内部的情况就可以形成内部类的形式。
 *
 * A类中又定义了B类，B类就是内部类。
 * B类可以当做A类的一个成员看待。
 *
 * class A{//外部类
 *     class B{//内部类：只为A类服务，可以看做是外部类的一个特殊成员
 *     }}
 *
 *     ！！特点！！
 * 1) 内部类可以直接访问外部类中的成员，包括私有成员
 * 2) 外部类要访问内部类的成员，必须要建立内部类的对象
 * 3) 在成员位置的内部类是成员内部类
 * 4) 在局部位置的内部类是局部内部类
 */
public class Inner1 {
    public static void main(String[] args) {

        //③.创建内部类对象,使用内部类的资源
        //外部类名.内部类名 变量名 = 外部类对象.内部类对象
        Outer.Inner oi = new Outer().new Inner();
        oi.get();
        oi.ok();
        oi.runs();
        //oi.go();私有的无法使用

        System.out.println(oi.count);

        //外部类和之前一样,创建对象直接调用
        new Outer().save();
    }
}

/**①.创建外部类 Outer*/
class Outer{

    String name;
    private int age;

    public void save() {
        System.out.println("Outer...save()");
        //⑤.外部类中可以使用内部类资源吗?
        //外部类想要使用内部类资源,必须先创建内部类对象,通过内部类对象来访问
        Inner in = new Inner();
        System.out.println(in.count);
        in.get();
    }

    /**②.创建成员内部类--类的特殊成员
         内部类根据位置不同,分为两种:成员内部类(类里方法外)/局部内部类(方法里)*/
    class Inner{
        int count = 10;
        String name = "海绵宝宝";
        public void get() {
            System.out.println("Inner...get()");
            //④.内部类可以使用外部类的资源吗?--可以!!!私有成员也可以!!!
            System.out.println(name);
            System.out.println(age);
            System.out.println(Outer.this.name);//同名时调用方式，前提是不要私有化
            //save();
        }
        //创建内部类的private成员方法
        private void go(){
            System.out.println("私有成员方法");
        }
        //创建内部类的private成员方法
        protected void runs(){
            System.out.println("内部类的protected成员方法");
        }
        //创建default普通方法
        void ok(){
            System.out.println("内部类的default成员方法");
        }
    }
}
