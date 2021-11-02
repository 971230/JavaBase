package com.ljf.company.day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 龙江锋
 * @Date 2021/3/12 19:00
 * @Version 1.0
 *
 * 1泛型
 * 1.1     概念
 *      public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>
 *      public interface Deque<E> extends Queue<E> {}
 *      public interface Queue<E> extends Collection<E> {}
 *      public interface Collection<E> extends Iterable<E> {}
 *
 * 我们上面的代码中出现的<?>是什么东西呢？它叫泛型，常用来和集合对象一同使用，
 * 所以在开始学习集合之前，必须先了解下什么是泛型。而且泛型概念非常重要，它是程序的增强器，
 * 它是目前主流的开发方式。
 * 泛型是（Generics）JDK1.5 的一个新特性，其实就是一个『语法糖』，
 * 本质上就是编译器为了提供更好的可读性而提供的一种小手段，小技巧，
 * 虚拟机层面是不存在所谓『泛型』的概念的。是不有点神奇，不知所云，别着急等我讲完你就清楚了。
 *
 * 1.2 作用
 *      通过泛型的语法定义<>,约束集合元素的类型,编译器可以在编译期提供一定的类型安全检查
 *      这样可以避免程序运行时才暴露BUG,代码的通用性也会更强
 *      泛型可以提升程序代码的可读性,但是它只是一个『语法糖』(编译后这样的部分会被删除,不出现在最终的源码中),
 *      所以不会影响JVM后续运行时的性能.
 *
 * 1.3     泛型示例
 *      实例1 : 我们创建一个ArrayList,看到eclipse发出黄线警告,这是为什么呢?
 *      原因:ArrayList定义时使用了泛型,在声明时需要指定具体的类型<E>
 *
 *      我们把这个”<>”的方式称之为泛型,那么泛型有什么样的作用呢?就是在编译阶段检查传入的参数是否正确
 *      有了泛型,我们可以看到要求存放的是String类型,而测试时存放的是int类型的100,所以eclipse显示报错:
 *      类型List<String>的add方法要求添加的类型为String类型,int类型不匹配,不能正确存入
 *
 * 1.4     泛型声明
 * 泛型可以在接口 类 方法上使用
 *      public interface Collection<E>{}
 *      public class TestStudy<Student>{}
 *      public <E> void print(E e){}
 * 在方法的返回值前声明了一个<E>,表示后面出现的E是泛型,而不是普通的java变量
 *
 * 1.5     常用名称
 *      *  E  -  Element ( 在集合中使用,因为集合中存放的是元素 )
 *      *  T  -  Type ( Java类 )
 *      *  K  -  Key ( 键 )
 *      *  V  -  Value ( 值 )
 *      *  N  -  Number ( 数值类型 )
 *      *  ?  -  表示不确定的java类型
 */
public class Generic {
    public static void main(String[] args) {

        /*1.泛型是怎么来的?--想要模拟数组的数据类型检查*/
        //创建一个用来存放String类型数据的数组,长度为5
        String[] a = new String[5];

        a[2] = "马凯";
        a[4] = "义天";

        //数组的好处:在编译时期检查数据的类型,如果不是要求的类型会在编译器就报错
        //a[0] = 1;
        //a[1] = 8.8;
        //a[3] = 'c';
        System.out.println(Arrays.toString(a));

        /*2.泛型通常会结合着集合一起使用*/
        //Raw use of parameterized class 'List'
        //注意导包:java.util...
        ArrayList list = new ArrayList();

        //没有泛型,数据类型根本没有约束 -- 太自由!!!
        list.add("景峰峰");
        list.add(1);
        list.add(8.8);
        list.add('a');
        //通过打印查看集合中的元素
        System.out.println(list);

        /* 3.引入泛型--主要目的是想通过泛型来约束集合中元素的类型<?>
         * 4.泛型的好处:可以把报错的时机提前,在编译期就报错,而不是运行后抛出异常
         * 在向集合中添加元素时,会先检查元素的数据类型,不是要求的类型就编译失败*/
        //注意导包:java.util...
        List<String> list2 = new ArrayList<String>();
        //约束了类型以后,只可以传String参数
        list2.add("朱斐斐");
        //list2.add(1);//编译失败
        //list2.add(8.8);//编译失败
        //list2.add('d');//编译失败
        System.out.println(list2);

        /*5.<type>--type的值应该如何写?
         * 需要查看要存放的数据类型是什么,根据类型进行定义
         * 但是type必须是引用类型,不是基本类型
         */
        //List<int> list3 = new ArrayList<int>();//注意导包:java.util...
        //注意导包:java.util...
        List<Integer> list3 = new ArrayList<>();

        list3.add(100);
        list3.add(200);
        list3.add(300);
        System.out.println(list3);
    }
}
