package com.ljf.company.day10;

import java.util.Random;

/**
 * @Author 龙江锋
 * @Date 2021/3/11 16:37
 * @Version 1.0
 */
public class AK47 {

    /**子弹*/
    int bullets = 100;
    /**加子弹的方法*/
    public void load(){
        this.bullets = 100;
        System.out.println("弹夹装满");
    }

    public void fire(){
        if (bullets == 0){
            System.out.println("没有子弹了");
            return;
        }
        //随机产生发射子弹的数量
        int r = new Random().nextInt(10);
        //要发射的子弹数量要比现有的子弹数量多
        if(r > bullets){
            //剩下几颗子弹就打几颗子弹
            r = bullets;
        }
        bullets = bullets - r;
        for (int i = 0; i < r; i++){
            System.out.print("突");
        }
        System.out.println("*****");
        if (bullets == 0){
            System.out.println("弹夹没有子弹");
        }
    }
}
