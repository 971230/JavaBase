package com.ljf.company.day08;

/**
 * @Author 龙江锋
 * @Date 2021/3/7 19:58
 * @Version 1.0
 *
 * 本类用于测试静态的调用关系
 *
 * //总结:
 * //1.静态资源只能调用静态资源
 * //2.非静态资源既可以调用静态资源,也可以调用非静态资源
 */
public class Static {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        //静态方法调用
        teacher.teach();
        Teacher.sleep();
        Teacher.eat();
        //静态属性调用
        System.out.println(teacher.name);
        System.out.println(Teacher.age);

        People.interClass();
        People p = new People();
        //p.interClass();静态方法直接用类名调用
        p.run();
    }

    static class People{
        public static void interClass(){
            System.out.println("内部类");
        }
        public void run(){
            System.out.println("run");
        }
    }
}


/**1.创建Teacher类*/
class Teacher {
    /**1.1定义普通资源*/
    String name;
    public void teach() {
        /*①.普通资源能否调用静态资源?--可以!!!*/
        sleep();//普通资源可以调用静态方法
        //普通资源可以调用静态属性
        System.out.println(age);
        System.out.println("正在教学中....");
    }

    /**1.2定义静态资源
    定义静态属性*/
    static int age;
    public static void sleep() {//定义静态方法
        /*②.静态资源能否调用普通资源?--不可以!!!
        teach();//静态方法不可以调用非静态方法*/
        //System.out.println(name);//静态方法不可以调用非静态属性
        System.out.println("再累也要好好休息哦~~~");

        /*③.静态资源能否调用静态--可以!!!*/
        //静态资源可以调用静态属性
        System.out.println(age);
        eat();//静态资源可以调用静态方法
    }

    public static void eat() {
        System.out.println("到饭点了,干饭去!");
    }
}
