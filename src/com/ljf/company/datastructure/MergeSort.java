package com.ljf.company.datastructure;

/**
 * @author 龙江锋
 */

public class MergeSort {

    /**
     * 归并排序 时间复杂度NlogN 空间复杂度N  稳定
     *
     * @param array array
     * @return int[] array
     */

    public static int[] mergeSort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }

    /**
     * 对左右两边的数据进行递归
     *
     * @param array array
     * @param left left
     * @param right right
     */

    private static void sort(int[] array, int left, int right) {
        if (left < right) {
            return;
        }
        //中间索引
        int center = (left + right) / 2;
        //对左边的数组递归排序
        sort(array, left, center);
        //对右边的数组递归排序
        sort(array, center + 1, right);
        //将两边数组进行归并
        merge(array, left, center, right);
    }

    private static void merge(int[] array, int left, int center, int right) {
        //todo
    }

    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    }
}
