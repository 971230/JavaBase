package com.ljf.company.day11;

import java.util.Arrays;

/**
 * @Author 龙江锋
 * @Date 2021/3/11 16:03
 * @Version 1.0
 *
 * String
 * 3.1  特点
 * String是一个封装char[]数组的对象,字符串不可变
 * 通过下图中的底层实现可以看出:被final修饰,是常量
 * String str = "abc"; 等效于：char data[] = {'a', 'b', 'c'};
 *
 *
 * 3.2  创建String对象的方式
 * 方式一:
 * String(char[] value) 分配一个新的 String，使其表示字符数组参数中当前包含的字符序列。
 *
 * 方式二: String str = “abc”;
 * 1.   如果是第一次使用字符串，java会在字符串常量池创建一个对象。
 * 2.   再次使用相同的内容时，会直接访问常量池中存在的对象。
 *
 * 3.3  常见方法
 * length()-查看字符串的长度
 * charAt()—定位某个字符,返回它的位置
 * lastIndexOf()-某个字符最后一次出现的位置
 * substring()-截取子串,如果参数有两个左闭右开[1,5)
 * equals()-判断两个串是否相等,注意String重写了Object的此方法,所以内容相同就返回true
 * startsWith()-判断是不是以参数开头
 * endsWith()--判断是不是以参数结尾
 * split()—以指定字符分割
 * trim()-去掉首尾两端的空格
 * getBytes()-把串转换成数组
 * toUpperCase()-变成全大写
 * toLowerCase()-变成全小写
 * String.valueOf(10)-把int类型的10转换成String类型
 */
public class Strings {
    public static void main(String[] args) {

        //1.创建String对象方式一
        char[] value = {'a','b','c'};
        /*1.字符串底层维护了char类型的数据,存放在内存的堆中*/
        String s1 = new String(value);


        //2.创建String对象方式二
        /*2.此种创建方式底层也会new String(),存放在堆的常量池中,效率高*/
        String s2 = "abc";
        //false  地址值不一样
        System.out.println(s2 == s1);
        //true
        System.out.println(s2.equals(s1));

        System.out.println("***************************************");
        /*
        链接：https://www.pdai.tech/md/java/basic/java-basic-lan-basic.html
        下面示例中，a1 和 a2 采用 new String() 的方式新建了两个不同对象，
        而 a3 是通过 a1.intern() 方法取得一个对象引用。
        intern() 首先把 s1 引用的对象放到 String Pool(字符串常量池)中，然后返回这个对象引用。
        因此 a3 和 a1 引用的是同一个字符串常量池的对象。*/
        String a1 = new String("aaa");
        String a2 = new String("aaa");
        // false
        System.out.println(a1 == a2);
        String a3 = a1.intern();
        String a4 = a2.intern();
        //true
        System.out.println(a3 == a4);
        // true
        System.out.println(a2.intern() == a3);
        /*如果是采用 "bbb" 这种使用双引号的形式创建字符串实例，会自动地将新建的对象放入 String Pool 中*/
        String s4 = "bbb";
        String s5 = "bbb";
        // true
        System.out.println(s4 == s5);


        System.out.println("**********************************************");
        //3.测试常用方法
        //b,获取下标为1的char字符
        System.out.println(s2.charAt(1));
        //abcabcd,在原有的字符串上进行拼接,注意不改变原来的串
        System.out.println(s2.concat("abcd"));
        //true,s2判断是否以c结尾
        System.out.println(s2.endsWith("c"));
        //false
        System.out.println(s2.endsWith("xy"));
        //true,String默认重写了Object的equals(),只要串内容相同就是true
        System.out.println(s1.equals(s2));
        //变为abccxy,在原有的字符串上进行拼接,把拼接好的串赋值给s3
        String s3 = s2.concat("cxy");
        //true,s3判断是否以xy结尾
        System.out.println(s3.endsWith("xy"));

        byte[] bytes = s2.getBytes();
        //[B@15db9742,将字符串转成byte[],所以打印的是数组的地址值
        System.out.println(s2.getBytes());
        //[97, 98, 99]
        System.out.println(Arrays.toString(s2.getBytes()));
        //2,获取c字符在字符串中第一次出现的索引值
        System.out.println(s2.indexOf("c"));


        s2 = "abcbc";
        //4,获取c字符在字符串中最后一次出现的索引值
        System.out.println(s2.lastIndexOf("c"));
        //5,获取字符串长度
        System.out.println(s2.length());
        System.out.println(bytes.length);


        s2="abcde";
        String[] c = s2.split(" ");
        //返回String[],所以打印的是地址值,作用是通过指定元素分割串
        System.out.println(s2.split(","));
        //返回String[],想看用Arrays工具类
        System.out.println(Arrays.toString(s2.split(" ")));
        //true,判断字符串是否以a开始
        System.out.println(s2.startsWith("a"));


        // b c d e,从下标为1开始截取剩下所有的字符串
        System.out.println(s2.substring(1));
        // b c,截取下标为[1,5)的字符串
        System.out.println(s2.substring(1, 5));


        //A B C D E    把串变成全大写
        System.out.println(s2.toUpperCase());
        //a b c d e    把串变成全小写
        System.out.println(s2.toLowerCase());


        s2="  abcde   ";
        //去除数据前后两头的空格
        System.out.println(s2.trim());
        //10,   把int 10转换成String类型
        System.out.println(String.valueOf(10));
        //1010, 不是加法,而是String类型拼接哦
        System.out.println(String.valueOf(10) + 10);
    }
}
