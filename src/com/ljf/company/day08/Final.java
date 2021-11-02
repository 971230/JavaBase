package com.ljf.company.day08;

/**
 * @Author 龙江锋
 * @Date 2021/3/7 20:18
 * @Version 1.0
 *
 * final
 * 3.1  概念
 * 1)  是java提供的一个关键字
 * 2)  final是最终的意思
 * 3)  final可以修饰类，方法，成员变量
 *     初衷：java出现继承后，子类可以更改父类的功能，当父类功能不许子类改变时,
 *     可以利用final关键字修饰父类。
 *
 * 3.2  特点
 * 1) 被final修饰的类，不能被继承
 * 2) 被final修饰的方法，不能被重写,可以重载
 * 3) 被final修饰的变量是个常量，值不能被改变
 * 4) 常量的定义形式：final 数据类型 常量名 = 值
 */
public class Final {
    public static void main(String[] args) {

        //5.创建子类对象进行测试
        Son4 son4 = new Son4();
        //父类没有被final修饰，则可以被继承
        son4.work();

        //s.name = "123";//final修饰的name属性不可以重新赋值:
        //The final field Father4.name cannot be assigned
        //可以使用父类中final修饰的成员变量，但是不可以修改
        System.out.println(son4.name);
    }
}

//1.创建父类
/**1.final表示最终,可以用来修饰类,那么被final修饰的类无法被继承,也就是没有子类--最终类
final class Father4{//Son4类不可以成为最终类Father4的子类:
 Cannot inherit from final 'com.ljf.company.day08.Father4'*/
class Father4{

    //3.创建成员变量
    /**2.final可以修饰成员变量,被final修饰的变量不可以被修改--常量*/
    final String name = "打工人";

    //4.创建成员方法
    /**3.final可以修饰成员方法,但是被final修饰的方法是最终实现,子类无法重写*/
    public final void work() {
        System.out.println("Father4...打工魂");
    }
}

/**2.创建子类*/
class Son4 extends Father4{
    //子类无法重写父类中被final修饰的方法：work()
    /*public void work() {
    //'work()' cannot override 'work()' in 'com.ljf.company.day08.Father4';
    //overridden method is final
     System.out.println("Son4...打工人要利用计算机打工");
    }*/
}
