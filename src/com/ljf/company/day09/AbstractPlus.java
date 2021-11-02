package com.ljf.company.day09;

/**
 * @Author 龙江锋
 * @Date 2021/3/7 21:19
 * @Version 1.0
 *
 *本类用于测试抽象类的构造函数的用法
 *
 *  * 总结:
 *  * 1.抽象类中可以有构造方法
 *  * 2.父类的构造方法要优先于子类执行
 *  * 3.抽象类中构造方法存在的目的,不是为了创建抽象类本身的对象,而是为了创建子类对象时使用
 */
public class AbstractPlus {
    public static void main(String[] args) {

        //4.创建多态对象进行测试
        BaseAnimals a = new Dogs();

        Dogs b = new Dogs();

        //5.测试抽象类是否可以创建对象?--不能!!
        //BaseAnimals a2 = new BaseAnimals();
    }
}

/** 1.创建抽象父类*/
abstract class BaseAnimals{

    /**3.创建抽象类的构造函数*/
    public BaseAnimals() {//如果此处传参,会覆盖无参构造,子类super就报错了
        System.out.println("BaseAnimals...构造方法");
    }
}


/**2.创建子类*/
class Dogs extends BaseAnimals{

    /**6.创建子类无参构造,无参构造默认存在*/
    public Dogs() {
        //super();//隐藏着super();先访问父类的构造方法,再执行自己的功能
        System.out.println("Dogs...构造方法");
    }
}
