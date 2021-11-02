package com.ljf.company.day14;

import java.util.LinkedList;
import java.util.Vector;

/**
 * @Author 龙江锋
 * @Date 2021/3/15 19:41
 * @Version 1.0
 *
 * LinkedList
 * 7.1 概述
 *        链表,两端效率高,底层就是双向链表实现的
 *
 *        总结(ArrayList和LinkedList区别):
 *        ArrayList底层是数组结构,查询快,增删慢,适合查询较多的场景，支持高效的随机访问
 *        LinkedList底层是链表结构,查询慢,增删快,适合增删操作较多的场景，支持高效的随机访问
 *        注意:LinkedList查询慢是指数据量大时,查询中间要慢,首位操作还是比较快的
 *        两者都不保证线程安全
 *
 *        补充内容：RandomAccess接口标识实现这个接口的类具有随机访问功能
 *
 *
 * 7.2 创建对象
 *        LinkedList() 构造一个空列表
 *
 * 7.3 常用方法
 * void addFirst(E e) 将指定元素插入此列表的开头
 * void addLast(E e) 将指定元素添加到此列表的结尾
 * E getFirst() 返回此列表的第一个元素
 * E getLast() 返回此列表的最后一个元素
 * E removeFirst()移除并返回此列表的第一个元素
 * E removeLast() 移除并返回此列表的最后一个元素
 * E element() 获取但不移除此列表的头（第一个元素）
 * boolean offer(E e) 将指定元素添加到此列表的末尾（最后一个元素）
 * boolean offerFirst(E e) 在此列表的开头插入指定的元素
 * boolean offerLast(E e) 在此列表末尾插入指定的元素
 * E peek() 获取但不移除此列表的头（第一个元素）
 * E peekFirst() 获取但不移除此列表的第一个元素；如果此列表为空，则返回 null
 * E peekLast() 获取但不移除此列表的最后一个元素；如果此列表为空，则返回 null
 * E poll()获取并移除此列表的头（第一个元素）
 * E pollFirst() 获取并移除此列表的第一个元素；如果此列表为空，则返回 null
 * E pollLast() 获取并移除此列表的最后一个元素；如果此列表为空，则返回 null
 *
 *
 * ArrayList扩容
 * ArrayList相当于在没指定initialCapacity时就是会使用延迟分配对象数组空间，
 * 当第一次插入元素时才分配10（默认）个对象空间。假如有20个数据需要添加，
 * 那么会分别在第一次的时候，将ArrayList的容量变为10；之后扩容会按照1.5倍增长。
 * 也就是当添加第11个数据的时候，Arraylist继续扩容变为10*1.5=15；当添加第16个数据时，
 * 继续扩容变为15 * 1.5 =22个
 *
 * ArrayList没有对外暴露其容量个数，查看源码我们可以知道，实际其值存放在elementData对象数组中，
 * 那我们只需拿到这个数组的长度，观察其值变化了几次就知道其扩容了多少次。怎么获取呢？只能用反射技术了。
 */
public class LinkedLists {
    public static void main(String[] args) {

        //1.创建对象
        LinkedList<String> list = new LinkedList<>();

        //2.添加数据
        list.add("孙悟空");
        list.add("猪八戒");
        list.add("唐三藏");
        list.add("沙师弟");
        list.add("白龙马");
        System.out.println(list);


        //3.1自行测试从collection继承过来的共性方法测试
        //3.2 LinkedList特有方法测试
        //添加首元素
        list.addFirst("蜘蛛精");
        //添加尾元素
        list.addLast("玉兔精");
        System.out.println(list);


        //获取首元素
        System.out.println(list.getFirst());
        //获取尾元素
        System.out.println(list.getLast());
        //移除首元素,成功移除会返回移除的数据
        System.out.println(list.removeFirst());
        System.out.println(list);

        //移除尾元素,成功移除会返回移除的数据
        System.out.println(list.removeLast());
        System.out.println(list);

        //返回该 LinkedList浅拷贝
        System.out.println(list.clone());
        System.out.println(list);



        //4.其他测试
        //4.1创建对象
        LinkedList<String> list2 = new LinkedList<>();

        //4.2添加数据
        list2.add("水浒传");
        list2.add("三国演义");
        list2.add("西游记");
        list2.add("红楼梦");
        System.out.println(list2);
        //获取但不移除此列表的首元素(第一个元素)
        System.out.println(list2.element());
        //返回此列表中指定位置的元素。
        System.out.println(list2.get(2));

        /*别名:查询系列*/
        //获取但不移除此列表的首元素(第一个元素)
        System.out.println(list2.peek());
        //获取但不移除此列表的首元素(第一个元素)
        System.out.println(list2.peekFirst());
        //获取但不移除此列表的尾元素(最后一个元素)
        System.out.println(list2.peekLast());


        /*别名:新增系列*/
        //将指定元素添加到列表末尾
        System.out.println(list2.offer("遮天"));
        //将指定元素插入列表开头
        System.out.println(list2.offerFirst("斗罗大陆"));
        //将指定元素插入列表末尾
        System.out.println(list2.offerLast("斗破苍穹"));
        System.out.println(list2);


        /*别名:移除系列*/
        //获取并且移除此列表的首元素(第一个元素),成功移除,返回移除元素
        System.out.println(list2.poll());
        //获取并且移除此列表的首元素(第一个元素),成功移除,返回移除元素,如果此列表为空,则返回null
        System.out.println(list2.pollFirst());
        //获取并且移除此列表的尾元素(最后一个元素),成功移除,返回移除元素,如果此列表为空,则返回null
        System.out.println(list2.pollLast());
        System.out.println(list2);


        //List的古老实现类，底层用数组存储，线程安全
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);

        System.out.println(vector);
        System.out.println(vector.size());
    }
}
