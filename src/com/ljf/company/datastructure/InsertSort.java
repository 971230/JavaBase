package com.ljf.company.datastructure;

/**
 * @author 龙江锋
 */
public class InsertSort {
    /**
     * 插入排序算法 时间复杂度 N ~ N2 （时间复杂度与初始排序状态有关） 空间复杂度 1 稳定
     *
     * @param array
     * @return
     */
    public static int[] main(int[] array) {
        for (int i = 1; i < array.length; i++) {
            //插入的元素
            int insertVal = array[i];
            //被插入的位置（准备和前一个数进行比较）
            int index = i - 1;
            //如果插入的元素比被插入的数小
            while (index >= 0 && insertVal < array[index]) {
                //则将array[index]向后移动
                array[index + 1] = array[index];
                //将index向后移动
                index--;
            }
            //将插入的元素放入合适的位置
            array[index + 1] = insertVal;
        }
        return array;
    }
}
