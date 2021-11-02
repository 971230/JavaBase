package com.ljf.company.day08;

/**
 * @Author 龙江锋
 * @Date 2021/3/7 20:49
 * @Version 1.0
 *
 * /**本类用于完成汽车设计综合案例
 *  * 分析:
 *  * 提取共性:生成汽车父类
 *  * 方法:启动方法 停止方法
 *  * 属性: 品牌 颜色
 *  * 具体事物:奔驰汽车 奥迪汽车--继承汽车父类,子类享有父类的公有属性和方法
 */
public class DesignCar {
    public static void main(String[] args) {

        //3.创建父类对象进行初步测试
        Car c = new Car();
        c.run();
        c.stop();
        //4.创建子类对象进行初步测试
        Benz c1 = new Benz();
        c1.run();
        c1.stop();
        System.out.println(c1.brand = "brand");
        System.out.println(c1.color = "color");
        //创建子类对象
        Audi c2 = new Audi();
        c2.run();
        c2.stop();
        //多态奔驰类对象
        Car a = new Benz();
        a.run();
        a.stop();
        System.out.println(a.brand = "Benz");
        System.out.println(a.color = "black");
        //多态Audi类对象
        Car a1 = new Audi();
        a1.run();
        a1.stop();
        System.out.println(a1.brand = "Audi");
        System.out.println(a1.color = "white");
    }
}

/**0.抽取奔驰类与奥迪类的共性,生成汽车父类*/
class Car{

    /*定义特征--属性/成员变量*/
    /**汽车品牌*/
    String brand;
    /**汽车颜色*/
    String color;

    /**定义行为--功能/成员方法*/
    public void run() {
        System.out.println("汽车启动....");
    }

    public void stop() {
        System.out.println("汽车停止....");
    }

}

//1.创建一个奔驰类
/**1.1继承汽车类,继承后,子类就具有父类的公有属性和功能了*/
class Benz extends Car{

    //5.如果想要修改父类的原有功能--方法的重写
    /** 5.1重写后,父类原有的功能并没有被修改,改的是子类自己的功能*/
    @Override
    public void run() {
        //5.2super应用在子类中,表示父类对象的引用Car super = new Car();
        super.run();
        System.out.println("汽车启动加速度UP UP UP....");
    }
}

//2.创建一个奥迪类
/**2.1继承汽车类,继承后,子类就具有父类的公有属性和功能了*/
class Audi extends Car{

    @Override
    public void stop() {
        System.out.println("汽车停止....要停的稳当一些哦~");
    }
}

/*
静态变量和实例变量的区别
在语法定义上的区别：静态变量前要加static关键字，而实例变量前则不加。
在程序运行时的区别：实例变量属于某个对象的属性，必须创建了实例对象，
其中的实例变量才会被分配空间，才能使用这个实例变量。静态变量不属于某个实例对象，而是属于类，
所以也称为类变量，只要程序加载了类的字节码，不用创建任何实例对象，
静态变量就会被分配空间，静态变量就可以被使用了。
总之，实例变量必须创建对象后才可以通过这个对象来使用，静态变量则可以直接使用类名来引用。

向上转型和向下转型
在JAVA中，继承是一个重要的特征，通过extends关键字，子类可以复用父类的功能，
如果父类不能满足当前子类的需求，则子类可以重写父类中的方法来加以扩展。
在应用中就存在着两种转型方式，分别是：向上转型和向下转型。

比如：父类Parent,子类Child
向上转型：父类的引用指向子类对象Parent p=new Child();
说明：向上转型时，子类对象当成父类对象，只能调用父类的功能，
如果子类重写了父类的方法就根据这个引用指向调用子类重写方法。

向下转型(较少)：子类的引用的指向子类对象，过程中必须要采取到强制转型。
Parent  p = new Child();//向上转型，此时，p是Parent类型
Child c = (Child)p;//此时，把Parent类型的p转成小类型Child
//其实，相当于创建了一个子类对象一样，可以用父类的，也可以用自己的
说明：向下转型时，是为了方便使用子类的特殊方法，也就是说当子类方法做了功能拓展，
就可以直接使用子类功能。 */
