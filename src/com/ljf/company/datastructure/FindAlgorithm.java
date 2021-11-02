package com.ljf.company.datastructure;

import java.util.Scanner;

/**
 * @author 龙江锋
 * 适用场景：顺序存储结构且按有序排列，这也是它的缺点。
 * 循环实现
 * * */

    class BinaryAlgorithm{
        public static void main(String[] args) {
            int[] array = {1, 4, 8, 16, 45, 48, 78};
            System.out.println("请输入想要查找的数值：");
            Scanner sc = new Scanner(System.in);
            int key = sc.nextInt();
            int s = binSearch1(key, array);
            if (s == -1) {
                System.out.println("没有这个数据");
            } else {
                System.out.println("查到数据下标为" + s);
                System.out.println("查到数据为第" + (s + 1) + "个数");
            }
        }


    /**循环实现二分算法*/
    public static int binSearch1(int key, int[] array) {
        //第一个下标
        int low = 0;
        //最后一个下标
        int height = array.length - 1;
        int middle = 0;
        //防越界
        if (key < array[low] || key > array[height] || low > height) {
            return -1;
        }
        //因为是顺序有序排列，所以我们可以用key和middle比较
        while (low <= height) {
            middle = (low + height) / 2;
            if (array[middle] > key) {
                //比要查找的关键字大则关键字在中间值左边
                height = middle - 1;
            } else if (array[middle] < key) {
                //比要查找的关键字小则关键字在中间值右边
                low = middle + 1;
            } else {
                return middle;
            }
        }
        //最后什么没找到返回-1
        return -1;
    }
}

class BinaryAlgorithm2 {
        public static void main(String[] args) {
            int[] array = {1,4,8,16,45,48,78};
            System.out.println("请输入想要查找的数值：");
            Scanner sc=new Scanner(System.in);
            int key=sc.nextInt();
            int low=0;
            int high=array.length-1;
            int s=binSearch2(array,key,low,high);
            if(s==-1){
                System.out.println("没有这个数据");
            }else{
                System.out.println("查到数据下标为"+s);
                System.out.println("查到数据为第"+(s+1)+"个数");
            }
    }

    /**递归实现二分算法*/
    public static int binSearch2(int[] arr, int key, int low, int high){

        if(key < arr[low] || key > arr[high] || low > high){
            return -1;
        }
        //初始中间位置
        int middle = (low + high) / 2;
        if(arr[middle] > key){
            //比关键字大则关键字在左区域
            return binSearch2(arr, key,low,middle-1);
        }else if(arr[middle] < key){
            //比关键字小则关键字在右区域
            return binSearch2(arr, key,middle+1,high);
        }else {
            return middle;
        }
    }


    /**
     * 二分查找算法 - 前提数组升序 ，如果是降序 就把向右查找的条件换成 target<array[mid] 就可以了
     *
     * @param array
     * @param target
     * @return
     */
    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int mid;
        while (low <= high) {
            mid = (high - low) / 2 + low;
            if (array[mid] == target) {
                return mid;
                //向右查找
            } else if (target > array[mid]) {
                low = mid + 1;
            } else { //向左查找
                high = mid - 1;
            }
        }
        return -1;
    }


}
