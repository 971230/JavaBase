package com.ljf.company.day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author 龙江锋
 * @Date 2021/3/21 21:20
 * @Version 1.0
 */
public class ListPlusPlus {
    public static void main(String[] args) {
        /*补充！*/
        List<String> myList = Arrays.asList("Apple","Banana", "Orange");

        /*asList的返回对象是一个arrays内部类，并没有实现集合的修改方法。Arrays.asList体现的是适配器模式
        只是转接接口，后台的数据仍是数组*/
        //这里使用[myList.add]可能会导致UnsupportedOperationException
        //myList.add("qwe");//运行时报错：UnsupportedOperationException
        ///myList.remove(1);//运行时报错：UnsupportedOperationException
       // myList.clear();//运行时报错：UnsupportedOperationException

        int[] myArray = {1, 2, 3};
        List myList1 = Arrays.asList(myArray);

        /*传递的数组必须是对象数组，而不是基本类型。
        Arrays.asList()是泛型方法，传入的对象必须是对象数组。
        Arrays.asList() 方法返回的并不是 java.util.ArrayList ，
        而是 java.util.Arrays 的一个内部类,这个内部类并没有实现集合的修改方法或者说并没有重写这些方法。*/
        //1
        System.out.println(myList1.size());
        //数组地址值
        System.out.println(myList1.get(0));
        //报错：ArrayIndexOutOfBoundsException
        System.out.println(myList1.get(1));
        int[] array = (int[]) myList1.get(0);
        //1
        System.out.println(array[0]);

        /*当传入一个原生数据类型数组时，Arrays.asList() 的真正得到的参数就不是数组中的元素，
        而是数组对象本身！此时List 的唯一元素就是这个数组，这也就解释了上面的代码。
        我们使用包装类型数组就可以解决这个问题。*/
        Integer[] myArray1 = {1, 2, 3};


        /*如何正确的将数组转换为ArrayList?*/
        //class java.util.ArrayList
        System.out.println(arrayToList(myArray1).getClass());

        //②、最简便(推荐)
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));

        //③、使用 Java8 的Stream(推荐)
        List<Integer> myList2 = Arrays.stream(myArray1).collect(Collectors.toList());
        //基本类型也可以实现转换（依赖boxed的装箱操作）
        int [] myArray3 = { 1, 2, 3 };
        //目前的jdk不支持
        //List<Integer> myList4 = Arrays.stream(myArray1).boxed.collect(Collectors.toList());

        //④、使用 Java9 的 List.of()方法
        //Integer[] array1 = {1, 2, 3};
        //List<Integer> list1 = List.of(array);
        //System.out.println(list); /* [1, 2, 3] */
        /* 不支持基本数据类型 */
    }

    /**①、JDK1.5+,自己动手实现*/
    static <T> List<T> arrayToList(final T[] array) {
        final List<T> l = new ArrayList<T>(array.length);

        for (final T s : array) {
            l.add(s);
        }
        return l;
    }
}
