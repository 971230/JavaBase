package com.ljf.company.day19;

/**
 * @Author 龙江锋
 * @Date 2021/3/21 16:35
 * @Version 1.0
 *
 * 成员内部类
 *  被private修饰
 *
 * 总结:
 * 成员内部类被Private修饰以后,无法被外界直接创建创建对象使用
 * 所以可以创建外部类对象,通过外部类对象间接访问内部类的资源
 *
 * 本类用来测试成员内部类被private修饰
 */
public class Inner2 {
    public static void main(String[] args) {

        /*怎么使用内部类Inner2的资源?*/
        //4.创建内部类Inner2对象进行访问
        //Outer2.Inner2 oi = new Outer2().new Inner2();
        //oi.eat();
        //oi.runs();
        //oi.ok();
        //oi.go();

        /*如果Inner2被private修饰,无法直接创建对象该怎么办?*/
        //7.先创建外部类对象,调用全局访问点，间接访问私有内部类的资源
        new Outer2().getInner2Eat();
    }
}

/**①.创建外部类Outer2*/
class Outer2{

    /**6.提供外部类公共的全局访问点,在方法内部创建Inner2内部类对象,调用内部类方法*/
    void getInner2Eat() {
        //外部类可以访问内部类的私有成员,但要先创建对象
        Inner2 in = new Inner2();
        in.eat();
        in.go();
        in.ok();
        in.runs();
    }

    //2.1创建成员内部类Inner2
    /*成员内部类的位置:类里方法外*/
    /**5.成员内部类,被private修饰私有化,无法被外界访问*/
    private class Inner2 {
        //3.创建内部类的public成员方法
        public void eat() {
            System.out.println("我是Inner2的eat()");
        }
        //创建内部类的private成员方法
        private void go(){
            System.out.println("私有成员方法");
        }
        //创建内部类的private成员方法
        protected void runs(){
            System.out.println("内部类的protected成员方法");
        }
        //创建default普通方法
        void ok(){
            System.out.println("内部类的default成员方法");
        }
    }
}
