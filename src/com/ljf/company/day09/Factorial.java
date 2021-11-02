package com.ljf.company.day09;

import java.util.Scanner;

/**
 * @Author 龙江锋
 * @Date 2021/3/10 16:44
 * @Version 1.0
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println("请输入：");
        int a = new Scanner(System.in).nextInt();
        //int result = method(a);
        System.out.println(method(a));
    }

    public static int method(int n) {
        //int a = n;
        //必须设置最简问题,不然容易栈溢出
        if (n == 1){
            return 1;
        }else {
            //递归,在方法内部继续调用方法本身
            return n * method(n-1);
        }
    }
}
