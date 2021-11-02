package com.ljf.company.day09;

/**
 * @Author 龙江锋
 * @Date 2021/3/7 21:11
 * @Version 1.0
 *
 * 访问控制符
 * 用来控制一个类，或者类中的成员的访问范围。
 ***********************************************************************
 *               类           包          子类          任意(不同包，无关类)
 * public        √            √           √             √
 * protected     √            √           √
 * default       √            √
 * private       √
 * TIPS:default是表示不写修饰符,默认,如果写default单词来修饰会报错
 ***********************************************************************
 *
 * ①、抽象类
 * Java中可以定义被abstract关键字修饰的方法,这种方法只有声明,没有方法体,叫做抽象方法.
 * Java中可以定义被abstract关键字修饰的类,被abstract关键字修饰的类叫做抽象类
 * 如果一个类含有抽象方法,那么它一定是抽象类
 * 抽象类中的方法实现交给子类来完成
 *
 * ②、抽象方法的格式
 * 权限修饰符 abstract 返回值类型 方法名(参数列表);
 *
 * ③、特点
 * 1) abstract可以修饰方法或者类
 * 2) 被abstract修饰的类叫做抽象类,被abstract修饰的方法叫做抽象方法
 * 3) 抽象类中可以没有抽象方法
 * 4) 如果类中有抽象方法,那么该类必须定义为一个抽象类
 * 5) 子类继承了抽象类以后,要么还是一个抽象类,要么就把所有抽象方法都重写
 * 6) 多用于多态中
 * 7) 抽象类不可以被实例化
 */
public class Abstract {
    public static void main(String[] args) {

        //创建多态对象进行测试
        BaseAnimal a = new Pig();
        a.eat();//调用抽象父类的普通方法
        a.play();//调用抽象父类的普通方法
        a.run();//调用抽象父类的抽象方法,具体实现看子类重写父类后的方法
        a.fly();//调用抽象父类的抽象方法,具体实现看子类重写父类后的方法

        /*5.抽象类可以被实例化/创建对象吗?---不可以!!!*/
        //BaseAnimal a2 = new BaseAnimal();
        //'Animal' is abstract; cannot be instantiated
    }
}

//1.创建父类
/**2.如果一个类中包含抽象方法,那么这个类必须声明成一个抽象类*/
abstract class BaseAnimal{

    /**3.创建普通方法--抽象类中可以有普通方法*/
    public void eat() {
        System.out.println("吃啥都行");
    }

    public void play() {
        System.out.println("玩啥都行");
    }

    //4.创建抽象方法
    /**1.没有方法体的方法叫做抽象方法,被abstract关键字修饰*/
    public abstract void fly();
    /**run*/
    public abstract void run();
}

//2.创建子类
/**3.1当子类继承了抽象父类后,要么变成一个抽象子类,要么实现父类的所有抽象方法
//3.2--abstract class Pig extends BaseAnimal{}*/
class Pig extends BaseAnimal {

    /*4.1子类继承了抽象父类以后,可以选择重写父类的所有抽象方法*/
    /*4.2如果没有重写父类的所有抽象方法,子类仍然需要是一个抽象类*/
    /**给方法做标记,表示这是一个重写的方法*/
    @Override
    public void fly() {
        System.out.println("重写父类的抽象方法fly()");
    }

    /**给方法做标记,表示这是一个重写的方法*/
    @Override
    public void run() {
        System.out.println("重写父类的抽象方法run()");
    }
}
