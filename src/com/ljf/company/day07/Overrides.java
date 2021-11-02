package com.ljf.company.day07;

/**
 * @Author 龙江锋
 * @Date 2021/3/6 19:44
 * @Version 1.0
 *
 *
 * 方法重写Override
 * 1) 继承以后,子类就拥有了父类的功能
 * 2) 在子类中,可以添加子类特有的功能,也可以修改父类的原有功能
 * 3) 子类中方法的签名与父类完全一样时,会发生覆盖/复写的现象
 * 4) 格式要求:方法的返回值 方法名 参数列表 要完全一致,就方法体是重写的
 * TIPS: 父类的私有方法不能被重写,子类在重写父类方法时,修饰符
 * 子类重写父类方法时,子类修饰符要大于等于父类修饰符的权限
 *
 * 总结:
 * 1.方法重写的意义:是在不修改源代码的前提下,完成业务的修改
 * 2.重写的要求:子类的方法声明(返回值类型 方法名(参数列表) )和父类的一模一样
 * 3.重写并没有改变父类原有的业务,只是子类的业务进行了修改
 */

public class Overrides {
    public static void main(String[] args) {

        /*3.创建子类对象进行测试*/
        Son2 s = new Son2();
        /*1.子类继承了父类,可以使用父类的所有功能,
        执行重写后子类的eat()方法*/
        s.eat();
        /*2.继承后,子类不仅可以使用父类的功能,还可以拥有自己特有的功能,实现功能的拓展*/
        s.study();
        Father2 f = new Father2();
        f.eat();
    }
}

/** 1.创建父类*/
class Father2 {
    public void eat() {
        System.out.println("爸爸爱吃肉");
    }
    private void unlock(){
        System.out.println("爸爸会开锁");
    }
}

/** 2.创建子类*/
class Son2 extends Father2 {

    /** 4.1提供子类特有的功能*/
    public void study() {
        System.out.println("快过年了,学学包饺子吧!");
    }

    /* OCP原则:面向功能修改关闭,面向拓展开放--只允许功能拓展,不允许修改原来的代码*/
    // 5.对父类功能进行修改--不允许直接修改父类原有的业务
    // 功能修改--方法的重写Override
    /* 3.重写:和父类的方法签名[返回值类型&方法名&参数列表]保持一致 void eat()一模一样,
         修改的是子类的功能,父类的功能并没有发生改变*/
    /* 4.重写时,子类必须有权限去重写父类的功能,父类的私有方法无法被重写
         方法的修饰符 >= 父类的修饰符*/

    @Override
    public void eat() {
        System.out.println("儿子爱吃蔬菜");
    }
    /*@Override
    public void unlock(){
        System.out.println("不允许重写私有方法");
    }*/
}
