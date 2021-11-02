package com.ljf.company.day17;

/**
 * @Author 龙江锋
 * @Date 2021/3/22 16:49
 * @Version 1.0
 *
 * 断点调试：
 */
public class OOPTest {
    public static void main(String[] args) {
        /*①、循环*/
        /*for (int i = 0; i <= 10; i++){
            System.out.println(i);
        }*/
        System.out.println(f(10));


    }
    
    /**②、递归*/
    public static int f(int n){
        if (n == 1){
            return 1;
        }else {
            return n*f(n - 1);
        }
    }
}


