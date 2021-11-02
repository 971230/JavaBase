package com.ljf.company.day08;

/**
 * @Author 龙江锋
 * @Date 2021/3/7 20:33
 * @Version 1.0
 *
 * 多态
 * 4.1  概念
 * 多态指同一个实体同时具有多种形式
 * 它是面向对象程序设计（OOP）的一个重要特征。
 * 主要是指同一个对象，在不同时刻，代表的对象不一样，指的是对象的多种形态。
 * 好处是：可以把不同的子类对象都当作父类来看，可以屏蔽不同子类对象之间的差异，写出通用的代码，
 *        做出通用的编程，统一调用标准。
 * 水果有两种形态：水果和苹果,不关心买回来的是苹果还是西瓜,只要是水果就行
 *
 * class Animal{//1.定义父类Animal
 * ....eat(){syso("吃啥都行")}
 * }
 *
 * class Cat extends Animal{//2.1定义子类Cat
 * ....eat(){syso("吃小鱼干")}
 * }
 *
 * class Dog extends Animal{//2.2定义子类Dog
 * ....eat(){syso("吃肉骨头")}
 * }
 *
 * class Pig extends Animal{//2.3定义子类Pig
 * ....eat(){syso("吃菜叶子")}
 * }
 *
 * main(){
 *
 * //3.创建子类对象
 * Cat c = new Cat();//小猫是小猫
 * Dog d = new Dog();//小狗是小狗
 * Pig p = new Pig();//小猪是小猪
 *
 * //4.创建多态对象(父类引用指向子类对象/编译看左边,运行看右边)
 * Animal a1 = new Cat();//小猫是小动物
 * Animal a2 = new Dog();//小狗是小动物
 * Animal a3 = new Pig();//小猪是小动物
 * }
 *
 * 4.2  特点
 * 1) **多态的前提1：是继承**
 * 2) **多态的前提2：要有方法的重写**
 * 3) 父类引用指向子类对象,如：Animal a = new Cat();
 * 4) 多态中，编译看左边，运行看右边
 */
public class Polymorphic {
    public static void main(String[] args) {

        //5.创建父类对象进行测试
        Animal a = new Animal();
        a.eat();//小动物Animal吃啥都行~~~~

        // a.jump();//父类无法使用子类的特有方法:
        // Cannot resolve method 'jump' in 'Animal'
        // 6.创建子类对象进行测试
        Cat c = new Cat();
        c.eat();//小猫cat爱吃小鱼干~~~--调用重写后的功能
        c.jump();//小猫Cat跳的老高了!!
        System.out.println(c.a);

        //!!!!!8.创建多态对象进行测试
        /*口诀1: 父类引用 指向 子类对象*/
        /*口诀2: 编译(保存)看左边,运行(测试)看右边*/
        Animal a2 = new Cat();
        //父类的属性可以使用
        System.out.println(a2.a);
        //子类基础父类的方法
        a2.walk();
        //System.out.println(a2.b);//子类属性用不了

        /*eat()是使用的父类的声明Animal,但是使用的是子类的实现方式cat()*/
        a2.eat();//小猫cat爱吃小鱼干~~~子类中重写的eat()
        /*多态的出现:是为了统一调用标准,向父类看齐,父类提供的功能才能用,子类特有的功能用不了
         *父类提供的功能：继承过来的方法和重写的方法*/
        //a2.jump();//The method jump() is undefined for the type Animal

        Animal a3 = new Tiger();
        a3.eat();//老虎吃肉
        //a3.capture();//The method capture() is undefined for the type Animal
    }
}


/**1.创建父类*/
class Animal{
    /**3.定义父类中的成员方法*/
    int a;
    public void eat() {
        System.out.println("小动物Animal吃啥都行~~~~");
    }
    public void walk(){
        System.out.println("走路");
    }
}


/**2.创建子类*/
class Cat extends Animal{
    int b;
    //4.重写父类中的方法--对父类的代码进行功能修改
    //重写: 方法签名保持一致(返回值类型 方法名(参数列表) ) & 权限修饰符>=父类权限修饰符

    @Override
    public void eat() {
        System.out.println("小猫cat爱吃小鱼干~~~");
    }

    /** 7.定义子类特有的方法*/
    public void jump() {
        System.out.println("小猫Cat跳的老高了!!");
    }
}

class Tiger extends Animal{

    @Override
    public void eat(){
        System.out.println("老虎吃肉");
    }
    public void capture(){
        System.out.println("捕捉");
    }
}

/*
* 多态的好处
1) 多态可以让我们不用关心某个对象到底具体是什么类型,就可以使用该对象的某些方法
2) 提高了程序的可扩展性和可维护性

class Animal{//1.定义父类Animal
....eat(){syso("吃啥都行")}
}

class Cat extends Animal{//2.1定义子类Cat并且重写了父类的eat()
....eat(){syso("吃小鱼干")}
}

class Dog extends Animal{//2.2定义子类Dog并且重写了父类的eat()
....eat(){syso("吃肉骨头")}
}

class Pig extends Animal{//2.3定义子类Pig并且重写了父类的eat()
....eat(){syso("吃大白菜")}
}

public class TeatEat{
//这种写法不好,虽然每种小动物都可以eat(),调用自己对应类型参数的eat()
//但是程序写死了,每个eat()只能让一种小动物来吃,如果有很多种,就得写很多的eat()
//而且除了很多已知的动物以外,未知的该怎么写呢?public void eat(? ?){...}
//接收的参数类型是Cat类型,所以小猫可以吃了,而且只有小猫可以吃
*
public void eat(Cat cat){...}
//接收的参数类型是Dog类型,所以小狗可以吃了,而且只有小狗可以吃
public void eat(Dog dog){...}
//接收的参数类型是Pig类型,所以小猪可以吃了,而且只有小猪可以吃
public void eat(Pig pig){...}
...不止有很多动物,还有一些未知的动物

解决方案:多态:不关心子类类型,把子类当做父类来看--可以写出更加通用的代码

public void eat(Animal a){...}//方法的参数不再是子类类型,而是父类类型
main(){
eat(new Dog());//调用时的参数类型只要是父类型的子类即可
}
}*/
