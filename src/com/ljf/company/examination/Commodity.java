package com.ljf.company.examination;

/**
 * @author 龙江锋
 *
 * 用户购买多件商品，并添加购物车，根据物价表计算商品总价，
 *  * 先商场推出活动，商品总价达到1000打7折，总价900打8折，总价800打7折
 *  * 结算找零
 *  * 1.for(;;){}
 *  * 2.数组：商品类型
 *  * 3.商品应该封装成对象，商品名称(name)，商品价格(price),商品数量(count)
 *  * 4.if判断
 *  * 5.运算符
 */
public class Commodity {
    /**商品名*/
    private String cName;
    /**商品价格*/
    private double cPrice;
    /**商品数量*/
    private int cCount;

    /** 无参的构造方法*/
    public Commodity() {
    }

    /** 有参的构造方法*/
    public Commodity(String cName, double cPrice, int cCount) {
        this.cName = cName;
        this.cPrice = cPrice;
        this.cCount = cCount;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public double getcPrice() {
        return cPrice;
    }

    public void setcPrice(double cPrice) {
        this.cPrice = cPrice;
    }

    public int getcCount() {
        return cCount;
    }

    public void setcCount(int cCount) {
        this.cCount = cCount;
    }
}
