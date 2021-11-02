package com.ljf.company.day14;

import java.util.*;

/**
 * @Author 龙江锋
 * @Date 2021/3/15 18:42
 * @Version 1.0
 *
 * 各遍历方式的适用于什么场合？
 *         1、传统的for循环遍历，基于计数器的：
 *             顺序存储：读取性能比较高。适用于遍历顺序存储集合。
 *             链式存储：时间复杂度太大，不适用于遍历链式存储的集合。
 *         2、迭代器遍历，Iterator：
 *             顺序存储：如果不是太在意时间，推荐选择此方式，毕竟代码更加简洁，也防止了Off-By-One的问题。
 *             链式存储：意义就重大了，平均时间复杂度降为O(n)，还是挺诱人的，所以推荐此种遍历方式。
 *         3、foreach循环遍历：
 *             foreach只是让代码更加简洁了，但是他有一些缺点，就是遍历过程中不能操作数据集合（删除等），
 *             所以有些场合不使用。而且它本身就是基于Iterator实现的，但是由于类型转换的问题，
 *             所以会比直接使用Iterator慢一点，但是还好，时间复杂度都是一样的。
 *             所以怎么选择，参考上面两种方式，做一个折中的选择。
 */
public class ListPlus {
    public static void main(String[] args) {

        //1.创建List接口对象 导包快捷键:Ctrl+Shift+O
        List<String> list = new ArrayList<String>();

        //2.向集合中添加元素
        list.add("喜羊羊");
        list.add("美羊羊");
        list.add("懒羊羊");
        list.add("沸羊羊");
        list.add("小肥羊");
        list.add("红太阳");

        //3.测试集合的迭代
        /*
         * 集合迭代的方式:
         * 1.for循环
         * 2.增强for循环
         * 3.iterator
         * 4.listIterator
         * */
        //方式①:因为List集合是有序的,元素有下标,所以可以根据下标进行遍历
        //从何开始:0 到哪结束:list.size() 如何变化:i++

        for(int i = 0 ; i < list.size() ; i++) {
            //根据对应的下标来获取集合对应位置上的元素
            String s = list.get(i);
            System.out.println(s);
        }
        //逆序遍历
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(i + ":" + list.get(i));
        }
        System.out.println("***********我是一个无情的分割线1***************");

        //方式②:普通for循环遍历效率低,可以通过foreach提高遍历效率
        //好处:语法简洁效率高 坏处:不能按照下标来处理数据
        //格式:for(1 2 : 3){循环体} 3是要遍历的数据 1和2是遍历得到的单个数据的类型 和 名字
        //s就是本次循环/遍历得到的集合中的元素
        for(String s : list) {
            System.out.println(s);
        }
        System.out.println("***********我是一个无情的分割线2***************");


        //方式③:iterator() 是继承自父接口Collection的
        /*1.获取当前集合的迭代器*/
        Iterator<String> it = list.iterator();

        /*由于不清楚要遍历的集合中有多少元素,所以我们使用的循环结构是While*/
        //判断集合中是否有下个元素,如果有,返回true,继续遍历
        while(it.hasNext()) {
            //获取对应的元素
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("***********我是一个无情的分割线3***************");

        //方式④:listIterator()是List接口特有的
        //Iterator<E> Iterator --父接口 --hasNext() --next() --remove()
        //ListIterator<E> ListIterator --子接口,拥有父接口的方法,也有自己特有的方法(逆向迭代)
        //public interface ListIterator<E> extends Iterator<E>
        ListIterator<String> it2 = list.listIterator();
        //判断是否还有数据
        while(it2.hasNext()) {
            //获取当前遍历得到的数据
            String s = it2.next();
            System.out.println(s);
        }
        //逆序遍历
        while (it2.hasPrevious()){
            System.out.println(it2.previous());
        }

        //思考:方式3和方式4有什么区别?
        //3使用的是父接口中的Iterator 4使用的是子接口中的ListIterator
        //子接口拥有父接口的所有方法,除此之外,子接口也可以拥有自己特有的方法,目前是向前/逆向遍历
    }
}
