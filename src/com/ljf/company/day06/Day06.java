package com.ljf.company.day06;

/**
 * @Author 龙江锋
 * @Date 2021/3/1 17:47
 * @Version 1.0
 *
 * 核心任务:面向对象 类 对象 封装
 * 拓展任务:对象创建流程 匿名对象
 ********************************************************************************
 *
 * 面向对象的三大特征
 * 1) 封装性，把相关的数据封装成一个“类”组件
 * 2) 继承性，是子类自动共享父类属性和方法，这是类之间的一种关系
 * 3) 多态性，增强软件的灵活性和重用性
 *********************************************************************************
 *
 *   类
 * 1)  Java语言最基本单位就是类，类似于类型。
 * 2)  类是一类事物的抽象。
 * 3)  可以理解为模板或者设计图纸。
 **********************************************************************************
 *
 *   对象
 * 每个对象具有三个特点：对象的状态，对象的行为和对象的标识。
 * 1) 对象的状态用来描述对象的基本特征。
 * 2) 对象的行为用来描述对象的功能。
 * 3) 对象的标识是指对象在内存中都有一个唯一的地址值用来和其他对象区分开来。
 * 4) 类是一类事物的抽象，对象是具体的实现。
 **********************************************************************************
 *
 * 类和对象的关系
 * 1) 计算机语言来怎么描述现实世界中的事物的? 属性 + 行为
 * 2) 那怎么通过java语言来描述呢?通过类来描述一类事物,把事物的属性当做成员变量,把行为当做方法
 * ********************************************************************************
 *
 * Java把内存分成5大区域，我们重点关注栈和堆。
 * 1.  一般来讲局部变量存在栈中，方法执行完毕内存就被释放
 * 2.  对象(new出来的东西)存在堆中，对象不再被使用时，内存才会被释放
 * 3.  每个堆内存的元素都有地址值
 * 4.  对象中的属性都是有默认值的
 * TIPS: 栈与队列指的是一种数据的结构。
 *  栈： 先进后出（FILO -- First In Last Out）
 *  队列： 先进先出（FIFO -- First In First Out）
 * ********************************************************************************
 *
 * 在一个java文件中可以写多个class,但是被public修饰的只能有一个,而且这个类的名字就是文件名
 */

public class Day06 {
    public static void main(String[] args) {
        //2.在main()中通过new关键字来创建对应类的对象
        /*创建对象时，内存中发生了什么？
        ①、在栈内存中开辟一块空间，存放引用类型p，并把p压入栈低；先进后出
        ②、在堆内存中开辟一块空间，存放phone对象，new出来的对象
        ③、完成对象的初识化，并赋予默认值
        ④、把初始化完毕的对象赋予唯一的地址值
        ⑤、把地址值交给引用变量类型p存放*/
        Phone p = new Phone();
        //3.通过.来完成对象功能的调用
        p.call();
        p.message();
        p.learn();//加static的方法无法被调用
        //4.通过.来查看对象的属性值
        System.out.println(p.brand);
        System.out.println(p.price);
        System.out.println(p.size);
        System.out.println(p.color);

        //5.创建内部类的第二个对象
        Phone q = new Phone();
        //5.1调用模板里的功能
        q.call();
        q.message();
        q.learn();//加static的方法无法被调用

        //5.2给对象的属性设置值
        //就是先到栈内存中找到q中保存的唯一的地址值
        //然后根据地址值找到对应的Phone对象,并对其对应的属性值进行修改
        q.brand = "HUAWEI";
        q.price = 8888.88;
        q.size = 5.6;
        q.color = "中国红";

        //5.3通过.来查看对象的属性值
        System.out.println(q.brand);
        System.out.println(q.price);
        System.out.println(q.size);
        System.out.println(q.color);

        //创建外部类对象声明
        Person l = new Person();
        //调用
        l.run();
        l.walk();
        l.sing();
        //赋值
        l.name = "123";
        l.age = 2;
        l.sex = 0;
        //打印
        System.out.println(l.name);
        System.out.println(l.age);
        System.out.println(l.sex);
    }

    /*java里面static一般用来修饰成员变量或方法。但有一种特殊用法是用static修饰内部类，
    普通类是不允许声明为静态的，只有内部类才可以。
    被static修饰的内部类可以直接作为一个普通类来使用，而不需实例一个外部类
    需要注意的是当一个内部类没有使用static修饰的时候，是不能直接使用内部类创建对象，
    须要先使用外部类对象点new内部类对象及(外部类对象.new 内部类（）)*/

    /** 1.通过class关键字创建手机类--用来描述手机这一类事物--特征+行为(属性+功能)
     * 类是一类事物的抽象,只抽象的规定这一类事物的特征和行为
     * static可以用来区分成员变量、方法是属于类本身还是属于类实例化后的对象
     * 有static修饰的成员属于类本身，没有static修饰的成员属于类的实例。
     */
    static class Phone {//内部类Phone，没有使用static修饰的内部类不能直接创建对象
        //特征(属性)--类的成员变量来描述--位置:类里方法外，无需手动初始化。
        String brand;//品牌
        double price;//价格
        double size; //尺寸
        String color;//颜色

        //行为(功能)--类的方法来描述--修饰符 返回值类型 方法名(参数列表){方法体}
        public void call() {
            System.out.println("正在打电话");
        }

        public void message() {
            System.out.println("正在发短信");
        }

        public void learn() {
            System.out.println("正在看直播");
        }
        // 加static的方法无法被调用
        // public static void game(){System.out.println("正在玩游戏");}
    }
}

/**
* ①、static修饰的类只能为内部类，普通类无法用static关键字修饰。
* static修饰的内部类相当于一个普通的类，访问方式为（  new 外部类名.内部类的方法() ）
*/
class Person {
    /**
     * 匿名对象:
     * 没有名字的对象，是对象的简化表示形式。
     * 使用场景：
     * 当被调用的对象只调用一次时（多次会创建多个对象浪费内存）
     */

    String name;
    int age;
    int sex;
    public static void main(String[] args) {
        //不需要new一个phone()
        new Day06.Phone();//创建了一个对象调方法
        new Day06.Phone();//又创建了一个对象调方法
    }

    public void run(){
        System.out.println("run");
    }

    public void walk(){
        System.out.println("walk");
    }

    public void sing(){
        System.out.println("sing");
    }
}


/* 外部类
 * ②、如果没有用static修饰内部类，则只能按如下方式调用：需要先new 一个外部类实例
 * 普通内部类的访问方式为 （外部类对象.new 内部类方法()）
 */
/*class Person{
    public static void main(String[] args) {
        Day06 oc = new Day06();
        oc.new Phone();
    }
}

 ③、静态变量和实例变量的区别：
 static修饰的变量为静态变量，静态变量在内存中只有一份存储空间，静态变量不属于某个实例对象，
 被一个类中的所有对象所共享，属于类，所以也叫类变量，可以直接通过类名来引用。
 实例变量属于某个固定对象所私有，实例变量的使用必须先创建一个类的实例，然后通过这个实例来引用使用。

 ④、static关键字加载顺序问题：
 静态变量和静态块的加载都是在类加载器加载完成以后加载到一块固定内存区，按代码编写的顺序依次加载。
*/
