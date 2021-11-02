package com.ljf.company.examination;

import java.util.Scanner;

/**
 *  用户购买多件商品，并添加购物车，根据物价表计算商品总价，
 *  现在商场推出打折活动（）计算找零。
 *  1:商品的实体类，Commodity   商品名称CName，商品价格：CPrice,商品数量：CCount
 *  2:购物车的实体类，ShoppingCar 购物车：Commodity[] 购物车。 putCommodity（）；
 *  3:够买商品，并添加到购物车。
 *  4：计算商品总价，进行打折。
 *  5:用户付款，并结算找零
 * @author 项海涛
 */

public class Process {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ShoppingCar shoppingCar = new ShoppingCar(10);
        buyCommodity(shoppingCar);
        double result = shoppingCar.sumCommodity();
        double discountPrice = discount(result);
        settlement(discountPrice);
    }

    /**计算找零的方法。*/
    private static void settlement(double discountPrice) {
        System.out.println("您需要支付的折扣后的价格为" + discountPrice);
        System.out.println("请您刷脸支付：");
        double price = sc.nextDouble();

        //判断我输入的金额是否满足我结算的需求。
        if(price >= discountPrice){
            System.out.println("结算成功");
        }else{
            System.out.println("钱不够，你想白嫖？再付一次");
            double priceAgain = sc.nextDouble();
            System.out.println("钱够了，也就是支付" + priceAgain + "块钱");
        }
    }

    /** 打折的方法*/
    private static double discount(double result) {

        double discountPrice = 0;
        if(result > 10000 ){
            System.out.println("大8折");
            discountPrice = result * 0.8;
        }else if(result > 5000){
            System.out.println("大9折");
            discountPrice = result * 0.9;
        }else if(result > 1000){
            System.out.println("大95折");
            discountPrice = result * 0.95;
        }else{
            discountPrice = result;
        }
        return discountPrice;
    }

    /** 购买商品的方法*/
    private static void buyCommodity(ShoppingCar shoppingCar) {

        System.out.println("请您选择您要选购的商品");
        System.out.println("1.苹果，金额：100");
        System.out.println("2.鸡蛋，金额：80");
        System.out.println("3.黄光，金额：150");
        System.out.println("4.鸡胸肉，金额：998");
        System.out.println("5.肥宅快乐水，金额：10000");
        //无论如何，只要进了我的门，就得买点东西出去。
        do {
            int id = sc.nextInt();
            //选择够买的商品
            switch (id) {
                case 1:
                    // 苹果   100 创建商品嘞，吧商品信息不全
                    Commodity apple = new Commodity("苹果",100,1);
                    //添加购物车
                    shoppingCar.putCommodity(apple);
                    break;
                case 2:
                    Commodity egg = new Commodity("鸡蛋",80,1);
                    shoppingCar.putCommodity(egg);
                    break;
                case 3:
                    Commodity cucumber = new Commodity("黄瓜",150,1);
                    shoppingCar.putCommodity(cucumber);
                    break;
                case 4:
                    Commodity chickenfeed = new Commodity("鸡胸肉",998,1);
                    shoppingCar.putCommodity(chickenfeed);
                    break;
                case 5:
                    Commodity cool = new Commodity("肥宅快乐水",10000,1);
                    shoppingCar.putCommodity(cool);
                    break;
                default:
                    //如果商品不存在给个友好的提示
                    System.out.println("无此商品");
                    break;
            }

            //判断用户是否继续选择商品，用来结束选择商品的循环。
            System.out.println("是否继续选择商品？Y/N");
            String result = sc.next();
            if("Y".equals(result)) {
                continue;
            }else{
                break;
            }
        }while(true);
    }
}
