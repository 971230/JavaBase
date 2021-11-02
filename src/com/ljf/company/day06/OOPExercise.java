package com.ljf.company.day06;

/**
 * @Author 龙江锋
 * @Date 2021/3/4 19:12
 * @Version 1.0
 * 本类用于进行OOP综合练习
 *
 * 创建对象的流程
 * Person p = new Person();短短这行代码发生了很多事情
 * 1.     把Person.class文件加载进内存
 * 2.     在栈内存中，开辟空间，存放引用变量p
 * 3.     在堆内存中，开辟空间，存放Person对象
 * 4.     对成员变量进行默认的初始化
 * 5.     对成员变量进行显示初始化
 * 6.     执行构造方法（如果有构造代码块，就先执行构造代码块再执行构造方法）
 * 7.     堆内存完成
 * 8.     把堆内存的地址值赋值给变量p ，p就是一个引用变量，引用了Person对象的地址值
 */
public class OOPExercise {
    public static void main(String[] args) {
        //6.调用无参构造创建对象,无参构造默认存在，但有参数的构造方法一旦被创建，无参构造默认不创建
        //如果自定义了含参构造，默认的无参会被覆盖，需手动添加，
        //我们创建丰富的构造方法，就是为了给外界提供创建对象的多种方式
        Teacher teacher = new Teacher();

        //7.由于private将Teacher类中的属性都封装了,外界无法直接使用,所以需要使用set()/get()
        //teacher.name;//报错:The field Teacher.name is not visible
        //如果没有设置值或者是设置没有成功，获取的是默认值null
        System.out.println(teacher.getName());
        System.out.println(teacher.getGender());
        System.out.println(teacher.getAge());
        System.out.println(teacher.getSalary());

        teacher.setName("鲁智深");
        teacher.setGender("男");
        teacher.setAge(30);
        teacher.setSalary(1000.0);

        System.out.println(teacher.getName());
        System.out.println(teacher.getGender());
        System.out.println(teacher.getAge());
        System.out.println(teacher.getSalary());

        //8.直接调用全参构造来创建对象并且给对象的全属性赋值
        Teacher t2 = new Teacher("李逵","壮汉",28,300);
        System.out.println(t2.getName() + t2.getAge() + t2.getGender() + t2.getSalary());
    }
}

/**1.创建Teacher类*/
class Teacher{/*1.属性  2.get()/set() 3.构造方法*/

    /* 2.1提供属性
       2.2对属性进行封装--通过private关键字进行封装*/
    /** 姓名*/
    private String name;
    /** 性别*/
    private String gender;
    /** 年龄*/
    private int age;
    /** 薪水*/
    private double salary;

    /* 如果什么构造方法都没有添加,默认会存在无参构造
     * 我们创建了丰富的构造方法,是为了给外界提供创建本类对象的多种方式
     * 如果自定了含参构造,默认的无参构造会被覆盖,注意手动添加哦
     * 构造方法：与类同名，且没有返回值类型的方法，连void都没有
     * 构造方法作用：用来创建对象
     * 构造方法使用：创建对象时立即使用*/

    //构造方法没有返回值类型的方法，连void都没有
    /** 3.添加无参构造方法*/
    public Teacher() {
        System.out.println("我是无参构造");
    }

    /** 4.添加全参构造方法，类里的所有属性都是这个构造方法的参数*/
    public Teacher(String n,String g,int a,double s) {

        //5.在构造方法中为成员变量进行赋值
        //n是局部变量也就是用户调用此构造传入的参数,把参数赋值给成员变量name
        name = n;
        gender = g;
        age = a;
        salary = s;
        System.out.println("我是全参构造");
    }


    /**2.3需要给外界提供公共的属性设置与访问方式*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
