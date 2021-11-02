package com.ljf.company.datastructure;

/**
 * @author 龙江锋
 */
public class SelectSort {
    /**
     * 选择排序算法 时间复杂度 N2 空间复杂度 1 不稳定
     *
     * @param array
     * @return
     */
    public static int[] main(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //记录最小元素
            int min = array[i];
            //记录最小元素位置
            int minIndex = i;
            //在未排序数组中找到最小元素和对应位置
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            //元素交换位置
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }
}
