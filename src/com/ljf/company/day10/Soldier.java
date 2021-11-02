package com.ljf.company.day10;

import java.util.Random;

/**
 * @Author 龙江锋
 * @Date 2021/3/11 15:48
 * @Version 1.0
 */
public class Soldier {

    /*定义属性-成员变量-可以不用初始化，默认值为0*/
    /**定义编号*/
    int id;
    /**定义血量*/
    int blood = 100;
    /**默认值null*/
    AK47 q;

    /**定义前进方法*/
    public void go(){
        //this是一个特殊引用，引用的是“当前对象”的地址，代表的是本类
        System.out.println(this.id + "号士兵前进");
    }

    /**定义攻击方法*/
    public void attack(){

        //模拟进攻掉血
        if (blood == 0){
            System.out.println("这是" + id + "号士兵的尸体");
            return;//方法结束
        }
        System.out.println(id + "号士兵前进");
        //生成随机数d用来表示掉血量[0,10)
        int d = new Random().nextInt(10);
        blood = blood - d;
        if (blood < 0){
            //如果血量变成了负数，归零
            blood = 0;
            System.out.println(id + "号士兵阵亡了");
            System.out.println("当前血量" + blood);
        }
    }
}


