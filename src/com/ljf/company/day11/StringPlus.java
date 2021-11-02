package com.ljf.company.day11;

/**
 * @Author 龙江锋
 * @Date 2021/3/11 16:09
 * @Version 1.0
 *
 * StringBuilder/StringBuffer
 * 4.1  特点
 * 1. 封装了char[]数组
 * 2. 是可变的字符序列
 * 3. 提供了一组可以对字符内容修改的方法
 * 4. 常用append()来代替字符串做字符串连接”+”
 * 5. 内部字符数组默认初始容量是16：super(str.length() + 16);
 * 6. 如果大于16会尝试将扩容，新数组大小原来的变成2倍+2，容量如果还不够，
 *    直接扩充到需要的容量大小。int newCapacity = value.length * 2 + 2;
 * 7.StringBuffer 1.0出道线程安全，StringBuilder1.5出道线程不安全
 *
 * 4.2  常见方法
 *      append()
 */
public class StringPlus {
    public static void main(String[] args) {
        //method();//完成通过" + "进行拼接
        methods();//优化" + "拼接
    }

    private static void methods() {
        //1.定义字符串
        String str = "abcdefghijklmnopqrstuvwxyz";
        int num = 10000;

        //2.将指定的字符串拼接10000次
        /*优化1:String --> StringBuffer/StringBuilder*/
        //创建工具类对象1
        //线程安全，效率低
        StringBuffer sb = new StringBuffer();
        //创建工具类对象2
        //线程不安全，效率高
        StringBuilder sb2 = new StringBuilder();


        //2.2拼接10000次
        /*4.可以添加一个计时功能*/
        //4.1获取系统当前时间作为开始时间(ms)
        long t1 = System.currentTimeMillis();
        for(int i = 0; i < num ; i++) {
            /*优化2:+ -->append() */
            //result = result + str;
            sb.append(str);
            //sb2.append(str);
        }
        //4.2获取系统当前时间作为结束时间（ms）
        long t2 = System.currentTimeMillis();

        //3.打印拼接好的字符串
        //注意:eclipse控制台显示数据有限制,都打印在同一行了,所以控制台看不出来打印的内容
        //可以通过全选,复制拿出来看数据是否拼接成功
        //4.3打印拼接总共花费的总时长

        //打印拼接的结果
        //System.out.println(sb.toString());
        //0ms
        System.out.println(t2 - t1);
    }

    public static void method() {

        //1.定义字符串
        String str = "abcdefghijklmnopqrstuvwxyz";

        //2.将指定的字符串拼接10000次
        //2.1定义变量,用来保存最终拼接的结果
        String result = "";
        int num = 10000;

        //2.2拼接10000次
        /*4.可以添加一个计时功能*/
        //4.1获取系统当前时间作为开始时间(ms)
        long t1 = System.currentTimeMillis();
        for(int i = 0; i < num ; i++) {
            result = result + str;
        }

        //4.2获取系统当前时间作为结束时间(ms)
        long t2 = System.currentTimeMillis();

        //3.打印拼接好的字符串
        //可以通过全选,复制拿出来看数据是否拼接成功
        //System.out.println(result);

        //4.3打印拼接总共花费的总时长
        //2791ms/2698ms
        System.out.println(t2 - t1);
    }
}

/*
2.1.10.	String StringBuffer 和 StringBuilder 的区别是什么? String 为什么是不可变的?
String 类中使⽤ final 关键字修饰字符数组来保存字符串，所以 String 对象是不可变的。
在 Java 9 之后，String 类的实现改⽤ byte 数组存储字符串:private final byte[] value

⽽ StringBuilder 与 StringBuffer 都继承⾃ AbstractStringBuilder 类，在 AbstractStringBuilder 中
也是使⽤字符数组保存字符串变的。但是没有⽤ final 关键字修饰，所以这两种对象都是可变的
StringBuilder 与 StringBuffer 的构造⽅法都是调⽤⽗类构造⽅法也就是 AbstractStringBuilder 实现的，


 1. 在线程安全上 :
    --String 中的对象是不可变的，也就可以理解为常量，线程安全。
    --StringBuffer是旧版本就提供的，StringBuffer对⽅法加了同步锁或者对调⽤的⽅法加了同步锁，
      所以是线程安全的线程安全的。@since JDK1.0
    --StringBuilder是jdk1.5后产生,StringBuilder并没有对⽅法进⾏加同步锁,所以是⾮线程安全的。@since JDK1.5

 2. 在执行效率上，StringBuilder > StringBuffer > String
    每次对 String 类型进⾏改变的时候，都会⽣成⼀个新的 String 对象，然后将指针指向新的 String 对象。
    StringBuffer 每次都会对 StringBuffer 对象本身进⾏操作，⽽不是⽣成新的对象并改变对象引⽤。
    相同情况下使⽤ StringBuilder 相⽐使⽤ StringBuffer 仅能获得 10%~15% 左右的性能提 升，
    但却要冒多线程不安全的⻛险。

    对于三者使⽤的总结：
    ①.操作少量的数据: 适⽤ String
    ②.单线程操作字符串缓冲区下操作⼤量数据: 适⽤ StringBuilder
    ③.多线程操作字符串缓冲区下操作⼤量数据: 适⽤ StringBuffer


 3. 源码体现：本质上都是在调用父类抽象类AbstractStringBuilder来干活，
    只不过Buffer把代码加了同步关键字，
    使得程序可以保证线程安全问题。
    abstract class AbstractStringBuilder implements Appendable, CharSequence {


 8.4 API手册使用方式
     双击打开API手册可以看到有根据包名/根据类名/对类的简单介绍3个部分,
     我们也可以通过搜索快速定位到自己想要查看的内容,比如想查看下Object类,第一步,点击”显示”
 3.  在最左边新弹出的那一列点击”索引”这个页签,就可以在输入框中输入关键字进行查找了,不区分大小写
 4.  可以看到根据查找出来4个选项,一般是第一个,点击”显示”
 5.  想要查看的内容就显示出来了,大家可以在中间的页面仔细查阅需要了解的信息*/