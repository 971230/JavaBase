package com.ljf.company.day15;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author 龙江锋
 * @Date 2021/3/15 20:13
 * @Version 1.0
 *
 * 需求:提示并接收用户输入的一串字符,并且统计出每个字符出现的次数
 */
public class MapTest {

    public static void main(String[] args) {

        //1.提示用户输入要统计的字符串
        System.out.println("请输入您要统计的字符串:");

        //2.接收用户输入的要统计的字符串
        String scanner = new Scanner(System.in).nextLine();

        //3.获取到用户输入的每个字符,String底层维护的是char[]
        //创建map集合存放数据,格式:{b=2,d=4,g=3}
        /*统计的是每个字符出现的次数,所以字符是char类型,次数是int,但是不可以使用基本类型,需要使用包装类型*/
        HashMap<Character, Integer> hashMap = new HashMap<>(32);


        //开始位置:0 - 数组的第一个元素
        //结束位置:   < input.length() 或者 <= input,length()-1
        //如何变化:++
        for (int i = 0; i < scanner.length(); i++) {
            //获取一串字符中指定位置上的字符
            char key = scanner.charAt(i);
            //System.out.println("获取到的第" + (i + 1) + "个字符:" + key);


            /*4.统计每个字符出现的个数,存起来,存到map*/
            //要先拿着key到map中找是不是有value
            Integer value = hashMap.get(key);

            //如果判断为null,说明之前没有存过这个字符
            if(value == null) {
                //把当前的字符作为key存入,次数存1
                hashMap.put(key, 1);
            }else {
                //如果存过值,给之前的次数+1
                hashMap.put(key, value + 1);
            }
            //可以直接调用merge()方法
            //hashMap.merge(key, 1, Integer::sum);
        }
        System.out.println("各个字符出现的频率为:");
        System.out.println(hashMap);
    }
}


