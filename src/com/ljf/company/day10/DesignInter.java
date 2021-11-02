package com.ljf.company.day10;

/**
 * @Author 龙江锋
 * @Date 2021/3/8 22:38
 * @Version 1.0
 *
 * 本类用于设计老师类,面向接口编程
 */
public class DesignInter {
    public static void main(String[] args) {
        Teacher2 t = new CgbTeacher2();
        t.ready();//主打电商项目
        t.teach();//备课电商项目
        Teacher2 t1 = new BaseActTeacher2() {
            @Override
            public void ready() {
                System.out.println("ready");
            }

            @Override
            public void teach() {
                System.out.println("teach");
            }
        };
        t1.ready();//ready
        t1.teach();//teach
    }
}

//抽取共性,形成抽象层--体现接口--定义规
/**1.通过interface关键字定义接口*/
interface Teacher2{
    /*2.接口中的方法都是抽象方法,可以简写public abstract*/
    /**备课方法*/
    void ready();
    /**讲课方法*/
    void teach();
}

/*3.实现类要使用接口的功能,需要建立实现关系*/
/**创建培优老师实现类*/
class CgbTeacher2 implements Teacher2{

    @Override
    public void ready() {
        System.out.println("主打电商项目");
    }

    @Override
    public void teach() {
        System.out.println("备课电商项目");
    }
}

/**创建高手班老师实现类*/
abstract class BaseActTeacher2 implements Teacher2{  }
