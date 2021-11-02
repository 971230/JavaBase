package com.ljf.company.day19;

/**
 * @Author 龙江锋
 * @Date 2021/3/21 16:41
 * @Version 1.0
 *
 * 被static修饰
 *
 * 静态资源访问时不需要创建对象,可以通过类名直接访问
 * 访问静态类中的静态资源可以通过”. . . ”链式加载的方式访问
 */
public class Inner3 {
    public static void main(String[] args) {

        /* ******************如何访问内部类的show()?***********************/
        //④.创建内部类对象访问show()
        //方式一:按照之前的方式,创建内部类对象调用show()
        //Outer3.Inner3 oi = new Outer3().new Inner3();
        //oi.show();
        //方式二:创建匿名内部类对象访问show()
        //new Outer3().new Inner3().show();

        /* ***************现象:当内部类被static修饰以后,new Outer3()报错*****/
        //⑥.用static修饰内部类以后,上面的创建语句报错,注释掉
        //通过外部类的类名创建静态内部类对象
        Outer3.Inner3 oi = new Outer3.Inner3();
        oi.show();

        //⑦.匿名的内部类对象调用show()
        new Outer3.Inner3().show();

        //⑨.访问静态内部类中的静态资源--链式加载
        Outer3.Inner3.play();
    }
}

/**①.创建外部类Outer3*/
class Outer3{

    //②.创建成员内部类Inner3
    /**⑤.内部类被static修饰—并不常用!浪费内存!*/
    static class Inner3{
        //③.定义成员内部类中普通的成员方法
        public void show() {
            System.out.println("我是Inner3类的show()");
        }

        //⑧.定义成员内部类的静态成员方法(前提是这个内部类用static修饰)
        public static void play() {//Inner classes cannot have static declarations
            System.out.println("我是Inner3的play()");
        }
    }
}
