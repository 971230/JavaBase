package com.ljf.company.datastructure;

/**
 * @author 龙江锋
 */
public class QuickSort {
    /**
     * 快速排序算法 时间复杂度 NlogN 空间复杂度 logN 不稳定
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static int[] quickSort(int[] array, int low, int high) {
        if (low < high) {
            int index = partition(array, low, high);
            quickSort(array, 0, index - 1);
            quickSort(array, index + 1, high);
        }
        return array;
    }

    /**快速排序分区操作*/
    private static int partition(int[] array, int low, int high) {
        //1.找一个基准值
        int pivot = array[low];
        //2.当low 小于 high 重复操作
        while (low < high) {
            while (low < high && array[high] >= pivot) {
                high--;
            }
            array[low] = array[high];
            //从low开始，如果low小于pivot, low++ ,否则 low 的值直接赋值给 high
            while ((low < high) && array[low] <= pivot) {
                low++;
            }
            array[high] = array[low];
        }
        //3.最后基准值
        array[low] = pivot;
        //4.返回基准值位置
        return low;
    }
}
