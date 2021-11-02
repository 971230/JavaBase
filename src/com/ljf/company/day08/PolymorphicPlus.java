package com.ljf.company.day08;

/**
 * @Author 龙江锋
 * @Date 2021/3/7 20:40
 * @Version 1.0
 *
 * 多态的使用
 * 5.1 特点
 * 1) 成员变量: 使用的是父类的
 * 2) 成员方法: 由于存在重写现象,所以使用的是子类的
 * 3) 静态成员: 随着类的加载而加载,谁调用就返回谁的
 *
 * 不关心具体的子类类型，使用时更灵活
 */
public class PolymorphicPlus {
    public static void main(String[] args) {

        //3.创建子类对象进行测试
        Dog d = new Dog();
        //20
        System.out.println(d.sum);
        d.eat();//小狗要吃肉骨头~
        //d.play();错，play是已经被static修饰
        Dog.play();//小狗爱打滚

        //4.创建多态对象进行测试
        /*2.父类引用指向子类对象*/
        /*3.编译看左边,能用的功能必须都是父类提供的*/
        /*总结1:多态中,成员变量使用的都是父类的*/
        Animals a = new Dog();
        //10   成员变量使用的都是父类的
        System.out.println(a.sum);
        /*总结2:多态中,成员方法使用的是父类的方法声明,子类的方法体(方法实现)*/
        a.eat();//小狗要吃肉骨头~子类重写父类的方法
        Animals.play();//玩啥都行
    }
}

/**1.创建父类与成员变量*/
class Animals {
    int sum = 10;
    /**5.1创建父类的成员方法*/
    public void eat() {
        System.out.println("吃啥都行");
    }

    /**6.1在父类创建一个静态play方法,不可以重写*/
    public static void play() {
        System.out.println("玩啥都行");
    }
}

/*1.多态的前提:继承 + 重写,不重写没有意义*/
/**2.创建子类与成员变量*/
class Dog extends Animals {

    int sum = 20;

    /**5.2在子类中重写父类的eat()*/
    @Override
    public void eat() {
        System.out.println("小狗要吃肉骨头~");
    }

    //6.2在子类中创建一个静态play方法
    /**注意!!!静态资源属于类,不存在重写现象,只是两个类中有同样声明的方法而已,不属于重写*/
    public static void play() {
        System.out.println("小狗爱打滚");
    }
}
