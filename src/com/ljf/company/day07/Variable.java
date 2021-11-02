package com.ljf.company.day07;

/**
 * @Author 龙江锋
 * @Date 2021/3/5 17:31
 * @Version 1.0
 *
 * 变量
 * 2.1  概念
 * 可以改变的数，称为变量。在Java语言中，所有的变量在使用前必须声明。
 * 一般通过“变量类型 变量名 = 变量值 ;”这三部分来描述一个变量。如:int a = 3 ;
 * 变量的使用原则：就近原则,即尽量控制变量的使用范围到最小
 *
 * 2.2  局部变量
 * 位置: 定义在方法里或者局部代码块中
 * 注意: 必须手动初始化来分配内存.如:int i = 5;或者int i; i = 5;
 * 作用域: 也就是方法里或者局部代码块中,方法运行完内存就释放了
 *
 * 2.3  成员变量
 * 位置: 定义在类里方法外
 * 注意: 不用初始化,也会自动被初始化成默认值
 * 作用域: 整个类中,类消失了,变量才会释放
 */
public class Variable {

    public static void main(String[] args) {
        Moggy m = new Moggy();
        m.eat();
        m.run();
    }
}

class Moggy{

    //2.定义成员变量:
    //1)位置:类里方法外
    //2)无需手动初始化,会自动赋予对应类型的默认值
    //3)作用域:在整个类中生效,类消失,变量才会消失

    /**创建成员变量*/
    static int count;
    /**3.变量有一个使用的原则:就近原则
     * 不能加static，加了下面用this就调用不了*/
    int sum = 9;

    public void eat(){
        //1.定义局部变量:
        //1)位置:在方法里/局部代码块里
        //2)必须手动初始化
        //3)作用域:在方法/局部代码块中,对应的代码执行完局部变量就被释放
        //定义在方法中的局部变量sum
        int sum = 10;
        //变量的就近原则:使用的都是自己附近的变量,10
        System.out.println(sum);
        System.out.println(count);

        //可以通过this关键在来调用成员变量,前提:成员变量与局部变量同名时
        //如果不使用this指定,那么打印100,因为变量的就近原则,使用的是局部变量sum
        //通过this.访问了本类的成员变量sum
        System.out.println(this.sum);
        //System.out.println(Moggy.sum);如果成员变量的sum被加了static，就是这样使用
    }

    public void run(){
        //局部变量i只能在循环中使用
        for (int i = 0; i < this.sum; i++) {
            System.out.println(i);
        }
    }
    //System.out.println(i);
    //报错:无法引用变量i:Cannot resolve symbol 'i'
}
