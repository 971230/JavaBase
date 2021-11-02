package com.ljf.company.examination;

/**
 * @author 项海涛
 */
public class ShoppingCar {

    Commodity[] com;

    /**带参数的构造方法*/
    public ShoppingCar(int size){
        com = new Commodity[size];
    }

    /**控制购物车的长度，以及存储空间*/
    int count = 0;

    /**添加购物车的方法*/
    public void putCommodity(Commodity commodity){
        //判断购物车是否已满,不判断会空指针异常
        if(count >= com.length){
            System.out.println("购物车已满");
            return;
        }
        //添加商品
        com[count++] = commodity;
    }

    /** 用户取购物车商品时，计算商品总价的方法*/
    public double sumCommodity(){
        double result = 0.0;
        //循环遍历购物车中所有的商品
        for (Commodity commodity : com) {
            //在商品结算之前，进行商品是否存在的严重，保证程序逻辑严谨性。
            if (commodity != null) {
                //计算商品总价
                result += commodity.getcPrice();
            }
        }
        //返回商品总价
        return result;
    }
}
