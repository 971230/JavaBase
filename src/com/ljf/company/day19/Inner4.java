package com.ljf.company.day19;

/**
 * @Author 龙江锋
 * @Date 2021/3/21 16:43
 * @Version 1.0
 */
public class Inner4 {
    public static void main(String[] args) {

        /* 如何使用内部类的资源呢?
         * 注意:直接调用外部类对象的show()是无法触发局部内部类功能的
         * 需要再外部类中创建内部类对象并且进行调用,才能触发内部类的功能
         * */

        //⑤.创建外部类对象调用show()
        //Outer4 outer4 = new Outer4();
        //outer4.show();
        //⑦.当在外部类show()中创建局部内部类对象并且进行功能调用后,内部类的功能才能被调用
        new Outer4().show();
    }
}

/**①.创建外部类Outer4*/
class Outer4{

    /**②.创建外部类的成员方法*/
    public void show() {
        /*③.创建局部内部类Inner4—-不太常用!!!
        位置:局部内部类的位置在方法里*/

        class Inner4 {
            //④.创建局部内部类的普通属性与方法
            String name;
            int age;
            public void eat() {
                System.out.println("我是Inner4的eat()");
            }
        }

        /*如何使用局部内部类的资源?*/
        //⑥.在show()里直接创建内部类对象
        Inner4 in = new Inner4();
        in.eat();
        System.out.println(in.name);
        System.out.println(in.age);
    }
}