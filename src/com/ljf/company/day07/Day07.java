package com.ljf.company.day07;

/**
 * @Author 龙江锋
 * @Date 2021/3/4 20:15
 * @Version 1.0
 *
 * 1 构造方法
 * 1.1  概念
 * 构造方法是一种特殊的方法,它是一个与类同名且没有返回值类型的方法
 * 对象创建就是通过构造方法完成的,主要功能是完成对象的创建或者对象的初始化
 * 当类创建对象(实例化)时,会自动调用构造方法
 * 构造方法与普通方法一样也可以重载.
 *
 * 1.2  形式
 * 与类同名,且没有返回值类型,可以含参也可以不含参
 * 修饰符 方法名([参数列表]){  注意:方法名与类名一样
 * 代码…..
 * }
 */
public class Day07 {
    public static void main(String[] args) {
        //5.创建Person类的对象进行测试
        /*1.每次new(实例化)对象时会自动调用构造方法;调用无参构造*/
        Person p = new Person();
        System.out.println(p.name);
        System.out.println(p.age);
        System.out.println(p.address);
        p.study();
        p.eat();
        //调用一个参数的构造方法
        Person p2 = new Person("海绵宝宝");
        System.out.println(p2.name);
        System.out.println(p2.age);
        System.out.println(p2.address);
        p2.study();
        p2.eat();
        //调用全参构造方法
        Person p3 = new Person("派大星",123,"海底");
        System.out.println(p3.name);
        System.out.println(p3.age);
        System.out.println(p3.address);
        p3.study();
        p3.eat();
    }
}

/**1.创建Person类,用来描述人这一类型*/
class Person{
    //2.属性--创建成员变量
    /**姓名*/
    String name;
    /**年龄*/
    int age;
    /**地址*/
    String address;

    public void study(){
        System.out.println("123");
    }

    /*2.默认存在无参构造,当new Person()会自动触发此无参构造*/
    /*3.构造方法也存在重载的现象:方法的重载:在同一个类中,方法名相同且参数列表不同的现象*/
    //普通方法的定义:修饰符 返回值类型 方法名 (参数列表){ 方法体  }
    //构造方法的定义:修饰符 方法名 (参数列表){ 方法体  } --方法名与类名一致

    /** 6.1创建无参构造--当new Person()时,会触发*/
    public Person() {
        System.out.println("我是Person类的无参构造");
    }

    /*快速向下复制:Ctrl+Alt+向下键*/
    /*4.当只提供了含参构造,默认的无参构造会被覆盖,所以在创建重载的构造方法时,一定注意手动添加无参构造*/
    /** 6.2创建1个参数的构造*/
    public Person(String n) {
        //把用户的参数值传值给name
        name = n;
        System.out.println("我是Person类的1个参数的构造方法" + n);
    }

    /** 6.3创建全参构造--定义了几个属性,就传几个参数,new Person("派大星",3,"海底");会触发*/
    public Person(String n,int a,String addr) {
        //n是局部变量,name是成员变量,把用户传的参数值n赋值给成员变量name
        name = n;
        //a是局部变量,age是成员变量,把用户传的参数值a赋值给成员变量age
        age = a;
        //addr是局部变量,address是成员变量,把用户传的参数值addr赋值给成员变量address
        address = addr;
        System.out.println("我是Person类的全参构造" + n + a + addr);
    }

    /** 3.行为--创建方法*/
    public void eat() {
        System.out.println("到点啦,该点夜宵啦~");
    }
    /*TIPS:关于构造函数怎么记忆
    特点:方法名与类名相同,且没有返回值类型
    执行时机:创建对象时立即执行
    默认会创建无参构造,但是,如果自定了含参构造,默认的无参构造会被覆盖,注意要手动添加哦*/
}
