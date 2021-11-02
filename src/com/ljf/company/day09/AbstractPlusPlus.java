package com.ljf.company.day09;

/**
 * @Author 龙江锋
 * @Date 2021/3/7 21:24
 * @Version 1.0
 *
 * 本类用于测试抽象类中的成员
 * 抽象类中的构造函数通常在子类对象实例化时使用
 */
public class AbstractPlusPlus {
    public static void main(String[] args) {

        //7.创建多态对象进行测试
        BaseFruit f = new Apple();
        //10
        System.out.println(f.sum);

        //f.name = "lemon";
        //常量的值不能被修改The final field BaseFruit.name cannot be assigned
        System.out.println(f.name);
        f.clean();
        f.eat();//吃啥水果都行
        f.eat2();//Apple.eat2...吃啥水果都行
    }
}

/**1.创建抽象父类--水果类*/
abstract class BaseFruit{
    /*1.抽象类中可以有成员变量吗?--可以!!!*/
    /**3.1创建抽象父类成员变量*/
    int sum = 10;

    /*2.抽象类中可以有成员常量吗?--可以有,但是值无法修改*/
    /**3.2创建抽象父类成员常量*/
    final String name = "banana";

    /* 3.抽象类中可以有普通方法吗?--可以!!
     *   抽象类中可以都是普通方法吗?--可以,即没有抽象方法
     * 4.如果一个类中都是普通方法,这个类为什么还要被声明成抽象类呢?
     *   原因:抽象类不可以创建对象,如果不想让外界创建本类的对象,可以把普通类声明成一个抽象类*/
    //4.创建抽象父类普通方法

    public void eat() {
        System.out.println("吃啥水果都行");
    }

    public void eat2() {
        System.out.println("eat2...吃啥水果都行");
    }

    //5.创建抽象父类抽象方法
    /**5.抽象类中可以有抽象方法,一旦类中有抽象方法,这个类就必须被声明成抽象类*/
    public abstract void clean();
}


/**6.当一个类继承了父类,父类是一个抽象类时
 * 子类需要重写抽象父类中的所有抽象方法,如果不重写,就需要把自己变成一个抽象子类*/
//解决方案一:把自己变成一个抽象子类
//abstract class Apple extends BaseFruit{
//解决方案二:重写抽象父类的所有抽象方法
//2.创建子类--苹果类

class Apple extends BaseFruit{

    /**重写普通方法eat2()*/
    @Override
    public void eat2() {
        System.out.println("Apple.eat2...吃啥水果都行");
    }

    //6.重写父类的抽象方法clean()
    /**重写标记,表示子类重写/实现了父类的抽象方法clean*/
    @Override
    public void clean() {
        System.out.println("苹果还是需要好好洗洗再吃的");
    }
}
