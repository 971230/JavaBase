package com.ljf.company.day04;

/**
 * @author 龙江锋
 */
public class Day04 {

    /**入口函数main()方法结束，程序结束*/
    public static void main(String[] args) {
        System.out.println(1);

        //重载:在一个类中有多个同名的方法&方法的参数列表不同(个数不同/类型不同)
        //参数列表指的是参数的类型顺序和个数,而不是参数名
        //(int a,int b)和(int b,int a)—不属于重载
        //(int a,String b)和(String b,int a)—属于重载
        //方法的调用是根据方法名+参数列表来调用的
        method1();
        method2(20);
        method3("123",3);
        int result = method4(2,9);
        System.out.println(method4(3,8));
        System.out.println(result);
        System.out.println(2);

        //重载调用
        /*（1） 方法重载是让类以统一的方式处理不同类型数据的一种手段。多个同名函数同时存在，
         * 具有不同的参数个数/类型。重载Overloading是一个类中多态性的一种表现。
         *（2） Java的方法重载，就是在类中可以创建多个方法，它们具有相同的名字，但具
         * 有不同的参数和不同的定义。调用方法时通过传递给它们的不同参数个数和参数类型
         * 来决定具体使用哪个方法, 这就是多态性。
         *（3） 重载的时候，方法名要一样，但是参数类型和个数不一样，返回值类型可以相同
        也可以不相同。无法以返回型别作为重载函数的区分标准。*/
        method();
        method(20);
        method("海绵宝宝",3);
        method(100,100);
    }

    /**方法的修饰符 方法的返回值 方法名(参数类型 参数名){方法体...}*/
    public static int method4(int i, int j) {
        //通过return关键字把运算结果返回给调用位置
        return i + j;
    }

    /***/
    public static void method3(String name, int age) {
        System.out.println(name + "今年" + age + "岁");
    }

    /**method2()用来测试方法的参数
    方法的修饰符 方法的返回值 方法名(参数类型 参数名){方法体...}*/
    public static void method2(int num) {
        System.out.println(num * num);
    }

    /**创建method()测试方法的调用顺序
    //方法的修饰符 方法的返回值 方法名(参数列表){方法体...}*/
    public static void method1() {
        System.out.println(3);
        System.out.println(4);
        System.out.println(5);
    }

    //*******************重载*****************
    /**创建method(int i,int j)*/
    public static void method(int i, int j) {
        System.out.println(i + j);
    }

    /**创建method(String s,int i)*/
    public static void method(String s, int i) {
        System.out.println(s + "今年" + i + "岁啦");
    }

    /**创建method()*/
    public static void method() {
        System.out.println("哈哈哈哈我没有参数");
    }

    /**创建method(int num)*/
    public static void method(int num) {
        System.out.println(num * num);
    }
}
