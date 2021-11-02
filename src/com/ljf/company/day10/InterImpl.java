package com.ljf.company.day10;

/**
 * @Author 龙江锋
 * @Date 2021/3/8 22:26
 * @Version 1.0
 *
 * 本类作为Inter接口的实现类
 *
 * 1.实现类如果想用接口的功能,要和接口发生实现关系,通过关键字implements*
 * 2.1 方案一:如果实现类实现了接口以后,可以把自己变成一个抽象子类
 * public abstract class Day10_InterImpl implements Day10{
 * 2.2 方案二:实现类实现了接口以后,可以重写接口中的所有抽象方法
 */
public class InterImpl implements Day10{

    /** 作为标记,表示实现了父接口的抽象方法*/
    @Override
    public void eat() {
        System.out.println("吃火锅");
    }
    /** 作为标记,表示实现了父接口的抽象方法*/
    @Override
    public void play() {
        System.out.println("玩代码");
    }
}
