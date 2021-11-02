package com.ljf.company.day10;

/**
 * @Author 龙江锋
 * @Date 2021/3/8 22:32
 * @Version 1.0
 */
public class UserInter {
    public static void main(String[] args) {

        //3.在main()中创建多态对象进行测试
        /* 问题:子类创建对象时,会自动调用父类的构造方法,但是现在的父级是个接口
         * 接口里没有构造方法,那子类中super()调用的是什么呢?
         * 结论:子类默认继承了顶级父类Object,super()会自动调用Object的无参构造*/
        Inter2 in = new Inter2Impl();
        in.eat();
        in.eat2();
        /*结论2.1:接口中的变量实际上都是静态常量,可以通过类名直接调用*/
        System.out.println(Inter2.AGE);
        /*结论2.2:接口中的变量实际上都是静态常量,不能被重新赋值*/
        //Inter2.AGE = 20;//Cannot assign a value to final variable 'AGE'
    }
}


/**1.创建接口*/
interface Inter2{
    /*1.接口里有构造方法吗?--没有!!!*/
    //public Inter2() {}
    /*2.接口里可以有成员变量吗?--没有!!!*/
    /**静态常量,实际上:final static int age = 10;*/
    int AGE = 10;
    /**3.接口中可以有抽象方法吗?--可以!!!*/
    public abstract void eat2();
    /**可以简写--会自动拼接public abstract*/
    void eat();
}


/**2.创建接口的实现类*/
class Inter2Impl extends Object implements Inter2 {

    public Inter2Impl() {
        super();//默认先调用顶级父类Object的无参构造方法
        System.out.println("我是Inter2Impl的无参构造");
    }

    /**4.如果接口中添加了抽象方法,实现类中需要实现所有未实现的抽象方法*/
    @Override
    public void eat2() {
        System.out.println("eat2()");
    }

    @Override
    public void eat() {
        System.out.println("eat()");
    }
}
