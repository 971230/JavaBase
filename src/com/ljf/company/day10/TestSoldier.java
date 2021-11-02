package com.ljf.company.day10;

import java.util.Scanner;

/**
 * @Author 龙江锋
 * @Date 2021/3/11 15:48
 * @Version 1.0
 */
public class TestSoldier {
    /**创建main方法*/
    public static void main(String[] args) {
        //创建士兵对象
        //soldier是引用变量，引用的是第一个士兵对象
        Soldier s = new Soldier();
        s.id = 8888;
        s.go();
        //soldiers是引用变量，引用的是第二个士兵对象
        Soldier soldiers = new Soldier();
        soldiers.id = 8889;
        soldiers.go();
        soldiers.attack();

        s.q = new AK47();
        //AK47 c1 = s.q;
        s.q.fire();//
        s.q.load();//

        AK47 ak47 =new AK47();
        System.out.println("按回车射击，输入load装载子弹");
        ak47.fire();

        while (true){
            String sc = new Scanner(System.in).nextLine();
            if ("load".equals(sc)){
                ak47.load();
            }
            //不是就开火
            ak47.fire();
        }
    }
}
