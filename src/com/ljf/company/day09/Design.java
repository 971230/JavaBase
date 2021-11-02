package com.ljf.company.day09;

/**
 * @Author 龙江锋
 * @Date 2021/3/7 21:27
 * @Version 1.0
 *
 * 程序设计: 分析老师示例—面向抽象编程
 * 具体事物: 培优班老师 高手班老师
 * 共性: 讲课 备课
 */
public class Design {
    public static void main(String[] args) {
        BaseTeacher ct = new CgbTeacher();
        BaseTeacher at = new ActTeacher();
        ct.ready();
        ct.teach();
        at.ready();
        at.teach();
    }
}

//生活中的事物 -- 类
//特征 -- 属性 & 行为 -- 方法
//把所有的共性内容向上提取形成父类
/**2.类中含有抽象方法,这个类必须变成抽象类*/
abstract class BaseTeacher{
    int id;
    String name;

    /**备课方法*/
    public void ready() {
        System.out.println("正在备课");
    }
    /*讲课方法*/
    /**1.没有方法体的方法叫做抽象方法,用abstract修饰*/
    public abstract void teach();
}


/**培优班老师--主打电商项目*/
class CgbTeacher extends BaseTeacher{

    @Override
    public void teach() {
        System.out.println("正在讲课...电商项目");
    }
}


/**高手班老师--基础加强+框架加强+高新技术*/
class ActTeacher extends BaseTeacher{

    @Override
    public void teach() {
        System.out.println("正在讲课...基础加强+框架加强+高新技术");
    }
}
