package com.ljf.company.day07;

/**
 * @Author 龙江锋
 * @Date 2021/3/5 20:26
 * @Version 1.0
 */
public class Super {
    public static void main(String[] args) {
        //创建子类对象
        Son son = new Son();
        son.eat();
    }
}


/** 1.创建父类*/
class Father {
/** 4.在父类中定义两个属性*/
    int count = 0;
    int sum = 300;
}


/** 2.创建子类*/
class Son extends Father{
    /** 3.2在子类中定义成员变量*/
    int sum = 100;

    public void eat() {
        //3.1在子类的方法中定义局部变量
        int sum = 10;
        //10    ,3.3变量的就近原则,打印的是局部变量
        System.out.println(sum);
        //100   ,3.4使用this,调用的是成员变量sum
        System.out.println(this.sum);
        //0     ,4.1使用了父类的资源
        System.out.println(count);

        /*在子类中使用父类的sum资源,需要使用super.进行调用
        * super是表示父类的一个对象引用 Father super = new Father();*/
        //super.可以调用父类的资源(同名)  300
        System.out.println(super.sum);
        /*可以通过super这个关键字使用父类的内容,super代表的是父类的一个引用对象
        注意:在构造方法里,出现的调用位置必须是第一行*/
    }
}
