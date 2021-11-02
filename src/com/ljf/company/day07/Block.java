package com.ljf.company.day07;

/**
 * @Author 龙江锋
 * @Date 2021/3/5 17:36
 * @Version 1.0
 *
 * 构造代码块与局部代码块
 * { 代码… }
 *
 * 1 构造代码块的特点
 * 1) 位置: 在类的内部,在方法的外部
 * 2) 作用: 用于抽取构造方法中的共性代码
 * 3) 执行时机: 每次调用构造方法前都会调用构造代码块
 * 4) 注意事项: 构造代码块优先于构造方法加载
 *
 * 2 局部代码块
 * 1) 位置: 在方法里面的代码块
 * 2) 作用: 通常用于控制变量的作用范围,出了花括号就失效
 * 3) 注意事项: 变量的作用范围越小越好,成员变量会存在线程安全的问题
 *
 *  * 总结:
 *  * 1.当创建对象时,程序会自动调动构造方法,但是如果有构造代码块,会先去执行构造代码块,再执行构造方法
 *  * 2.当通过对象调用方法时,会执行方法中的功能,如果方法中有局部代码块,就会执行局部代码块
 *  * 3.执行顺序: 构造代码块-->构造方法-->局部代码块[前提:调用方法(如果方法有局部代码块,局部代码块才会执行)]
 *  * 4.构造代码块的功能: 用于提取构造方法中的共性
 *  * 5.局部代码块的功能: 控制变量的作用范围
 */
public class Block {
    public static void main(String[] args) {

        /* 5.在main()中创建对象进行测试
        每次创建对象时/new时,都会执行一次构造代码块*/
        Teacher t  = new Teacher();
        Teacher t2 = new Teacher("大中华");
        Teacher t3 = new Teacher("123","456");

        t.study();
        t.teach();
        t2.study();
        t2.teach();
        t3.study();
        t3.teach();
    }
}


/**1.创建一个Teacher类用于测试*/
class Teacher{
    /**2.定义成员变量科目,全局生效*/
    String name;
    String subject;
    //6.定义构造代码块
    {
        /* 构造代码块的位置:类里方法外
         * 作用:用于提取构造方法中的共性内容
         * 执行时机:优先于构造方法执行*/
        subject = "Java培优";
        System.out.println("构造代码块");
    }
    
    //3.定义构造方法
    /** 3.1创建本类的无参构造*/
    public Teacher() {
        System.out.println("我是Teacher类的无参构造" + subject);
    }
    
    /** 3.2创建本类的含参构造*/
    public Teacher(String n){
        name = n;
        System.out.println("我是Teacher类的含参构造" + n + ":" + name);
    }

    /** 创建本类的全参构造*/
    public Teacher(String n , String s){
        name = n;
        subject = s;
        System.out.println("全参构造" + n + s + name + subject);
    }
    
    //4.定义普通方法
    /** 方法定义:修饰符 返回值类型 方法名(参数列表){方法体...}*/
    public void study(){
        //7.创建局部代码块
        /*局部代码块的位置:方法里
        * 作用:控制变量的作用范围(作用范围越小越好,因为越小越安全)
        * 执行时机:调用本方法时*/
        {
            int i = 10;
            System.out.println(i);
        }
        //System.out.println(i);//报错,因为超出i的作用范围，已经被释放
        System.out.println("正在学习...");
    }

    public void teach(){
        {}
        System.out.println("正在备课...");
    }
}
