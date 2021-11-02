package com.ljf.company.datastructure;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 龙江锋
 * 冒泡排序:
 * 依次比较相邻的两个数，将小数放在前面，大数放在后面。
 * 即在第一趟：首先比较第1个和第2个数，将小数放前，大数放后。
 * 然后比较第2个数和第3个数，将小数放前，大数放后，如此继续，直至比较最后两个数，将小数放前，大数放后。
 * 此第一趟结束，将最大的数放到了最后。
 * 在第二趟：仍从第一对数开始比较（因为可能由于第2个数和第3个数的交换，使得第1个数不再小于第2个数），
 * 将小数放前，大数放后，一直比较到倒数第二个数（倒数第一的位置上已经是最大的），
 * 第二趟结束，在倒数第二的位置上得到一个新的最大数（其实在整个数列中是第二大的数）。
 * 如此下去，重复以上过程，直至最终完成排序。
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = createArray();
        //2.调用method()完成排序
        int[] newA = method(array);
        System.out.println("排序完毕:" + Arrays.toString(newA));
    }

    public static int[] createArray(){
        //创建一个无序的随机长度的数组
        int length = new Random().nextInt(10);
        int[] a = new int[length];
        for (int i = 0; i <= a.length-1; i++){
            a[i] = new Random().nextInt(100);
        }
        return a;
    }

    public static int[] method(int[] a) {
        //1.外层循环,控制比较的轮数,假设有n个数,最多比较n-1次
        //开始值:1 结束值:<= a.length-1 变化:++
        //控制的是循环执行的次数,比如5个数,最多比较4轮,<= a.length-1,最多取到4,也就是[1,4]4次
        for(int i = 1 ; i <= a.length-1 ; i++) {
            System.out.println("第" + i + "轮:");
            //2.内层循环:相邻比较+互换位置,控制每一轮比较的次数
            for(int j = 0; j < a.length-1; j++) {
                //相邻比较,a[j]代表的就是前一个元素,a[j+1]代表的就是后一个元素
                if(a[j] > a[j + 1]) {
                    //引入第三个变量来交换数据
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                    //查看一下
                    System.out.println("第" + (j + 1) + "次比较交换后:" + Arrays.toString(a));
                }
            }
            System.out.println("第" + i + "轮的结果:" + Arrays.toString(a));
        }
        //把排序好的数组a返回
        return a;
    }
}
