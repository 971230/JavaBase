package com.ljf.company.day05;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 龙江锋
 * 数组+变量
 *
 * 方法：被命名的代码块，方法可以含参数可以不含参数，可以提高代码的复用性
 * 形式：修饰符  返回值类型  方法名([参数]){
 *        方法体;
 * }
 *
 * ①.顺序执行代码
 * ②.调用指定方法
 * ③.执行完毕返回调用位置
 */
public class Day05 {

    /**
     * 1.方法调用
     */
    public static void main(String[] args) {
        System.out.println(1);
        f();
        System.out.println(2);
    }

    /**
     * 调用f()
     */
    private static void f() {
        //132
        System.out.println(3);
    }

    /**
     * 2.方法含参数
     */
    static void f(int x) {
        //142
        System.out.println(x * x);
    }

    /**
     * 3.方法有返回值
     */
    public static void main1() {
        System.out.println(1);
        int num = f3(5);
        System.out.println(num);
        String str = f4("学习使我快乐");
        System.out.println(str);
        System.out.println(2);
    }

    public static String f4(String desc) {
        return desc + ",我信你个鬼";
    }

    public static int f3(int i) {
        return i * 10;
    }

    /**
     * 方法重载：
     * 方法重载是指在一个类中定义多个同名的方法，但要求每个方法具有不同的参数列表(也就是说参数的个数和类型不同)。
     * 程序调用方法时，可以通过传递给它们的不同个数和类型的参数来决定具体使用哪个方法。
     */

    public static void main2() {
        int a = 10;
        int b = 20;
        String name = "list";

        p1();
        p1(a);
        p1(a, b);
        p1(a, b, name);
    }

    private static void p1(int a, int b, String name) { System.out.println(a + b + name); }

    private static void p1() {
        System.out.println("p1()");
    }

    private static void p1(int a) {
        System.out.println(a);
    }

    private static void p1(int a, int b) {
        System.out.println(a + b);
    }

    /**
     * 数组：
     * 1.概念
     * 数组Array是用于储存多个相同类型数据的集合。存储数据用
     * 想要获取数组中的元素值，可以通过元素的下标来获取，下标是从0开始的。
     *
     * 2.创建数组
     * 一般分为动态初始化和静态初始化
     * ①.动态初始化：int[] a = new int[5];
     *  Ø  新建int[],长度是5
     *  Ø  刚创建好的数组都是默认值0，int类型的数据默认值是0
     *  Ø  把数组的地址值给变量a保存(*)
     * ②. 静态初始化1：int[] a ={1,2,3,4,5,6,7,8};
     *    静态初始化2：int[] a =new int[]{1,2,3,4,5};
     *
     * 3.数组的长度
     *  Ø  .length属性获取数组长度
     *  Ø  数组一旦创建，长度不可变
     *  Ø  允许0长度的数组
     *
     * 4.数组的遍历
     * 从头到尾，依次访问数组的位置
     * 形式:我们通过数组的下标操作数组,所以for循环变量操作的也是数组下标
     * 开始:开始下标0  结束:结束下标length-1 如何变化:++
     * for(从下标为0的位置开始;下标的取值<=数组的长度-1;下标++){循环体;}
     *
     * 5.程序创建数组 int[] a = new int[5]; 时发生了什么?
     * 1.    在内存中开辟连续的空间,用来存放数据,长度是5
     * 2.    给数组完成初始化过程,给每个元素赋予默认值,int类型默认值是0
     * 3.    数组完成初始化会分配一个唯一的地址值
     * 4.    把唯一的地址值交给引用类型的变量a去保存
     * TIPS: 数组名是个引用类型的变量,它保存着的是数组的地址,不是数组中的数据
     *       数组一旦创建，长度不可改变
     */
    public static void main3() {

        //arr保存的是数组的地址，不是数组的值
        int[] arr = {9, 23, 123, 123, 5, 6, 7, 8, 32, 354, 12};
        char[] ar = new char[5];
        String[] aa = {"a","b","c"};
        //动态创建，后期赋值;通过数组下标,操作数组中的每个元素,给数组元素赋值(显示初始化)
        ar[0] = 'h';
        ar[1] = 'e';
        ar[2] = 'l';
        ar[3] = 'l';
        ar[4] = 'o';
        //直接打印的是保存数组元素的内存地址空间
        System.out.println(aa);
        /*只有char类型底层做了特殊处理,可以直接打印数组中的元素
        但是其他所有类型的数组想要打印数组中的具体元素,需要借助数组的工具类Arrays.toString()*/
        System.out.println(ar);
        //数组长度
        System.out.println(arr.length);
        //打印数组
        System.out.println(Arrays.toString(ar));
        //给数组赋值
        int[] b = new int[8];
        for (int i = 0; i <= b.length-1; i++){
            //b[i] = i;
            b[i] = new Random().nextInt(100);
        }
        System.out.println(Arrays.toString(b));

        //遍历数组
        //①或者 i <= arr.length-1
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
        //②增强for循环
        for (int i : arr) {
            System.out.print(i + ",");
        }
        //③
        System.out.println(Arrays.toString(arr));

        //二维数组
        int[][] c = {{3,5},{7,9},{1,2}};
        /*--创建外部数组,长度是3
        --给每个外部数组的位置创建内部数组,每个内部数组的长度是2
        --给每个内部数组进行数据初始化
        --二维数组生成唯一的地址值
        --把地址值交给引用类型变量a来保存*/
        //遍历外部数组
        for (int i = 0; i < c.length; i++) {
            //遍历内部数组
            for (int j = 0; j < c[i].length; j++) {
                //依次打印二维数组中每个元素的值
                System.out.println(c[i][j]);
            }
        }

        //JAVA中数组扩容(缩容)的三种方式:创建一个新数组，并将原数组数据复制进去
        //①
        /*int[] arr2=new int[arr1.length*2]   //新数组长度

        for(int i=0;i<arr1.length;i++){     //复制

            arr2[i]=arr1[i];
        }*/
        //②
        /*int[] arr2=java.util.Arrays.copyOf(arr,11); //(原数组名，新数组长度);*/
        //③前两个通常用于扩容，第三种通常用于复制
        /*int[] arr2=new int[arr1.length*2]
        System.arraycopy(arr,0,arr3,2,10)
        (arr:原数组名，0:起始下标，arr3:新目标数组名，2:起始下标，10:复制长度，应小于或等于原数组的长度);*/
        int[] arr4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr5 = new int[10];
        System.arraycopy(arr4, 1, arr5, 3, 4);
        int q = 0;
        for (int p = 0; q < arr5.length; q++) {
            System.out.println(arr5[p]);
        }
    }

    /**
     * 例：创建随机数组，获取100以内的随机值的数组
     */
    private static void a2() {
        int length = new Random().nextInt(10);
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = 1 + new Random().nextInt(100);
        }
        System.out.println(Arrays.toString(a));
    }

    /*数组工具类：
     * 1、Arrays.toString(数组)：
     * 把数组里的数据，用逗号连接成一个字符串。格式：[10, 14, 20, 46, 51]
     * 2.Arrays.sort(数组)：
     * 对数组排序，对于基本类型的数组使用优化后的快速排序算法，效率高。对引用类型数组，使用优化后的合并排序算法。
     * 3.Arrays.copyOf(数组，新的长度)：
     * 把数组复制成一个指定长度的新数组。新数组长度大于原数组，相当于复制，并增加位置。--数组的扩容
     * 新数组长度小于原数组，相当于截取前一部分数据。--数组的缩容
     * */

    public static void main4() {
        int[] arr = {12, 30, 20, 90, 34};
        //打印的是每个元素的内存地址空间
        System.out.println(arr);
        //数组的复制，大于原来长度相当于扩容
        int[] a = Arrays.copyOf(arr, 10);
        //合并排序
        Arrays.sort(a);
        //[12, 30, 20, 90, 34, 0, 0, 0, 0, 0]
        System.out.println(Arrays.toString(a));
        //10
        System.out.println(a.length);
        //数组的复制，小于原来长度相当于截取前几个数据
        int[] a2 = Arrays.copyOf(arr, 3);
        //[12, 30, 20]
        System.out.println(Arrays.toString(a2));
        //3
        System.out.println(a2.length);
        //指定首尾截取数组中的元素
        int[] a3 = Arrays.copyOfRange(arr,2,3);
        //[20]
        System.out.println(Arrays.toString(a3));
    }
}
