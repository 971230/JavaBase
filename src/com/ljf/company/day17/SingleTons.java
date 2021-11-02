package com.ljf.company.day17;

import java.io.Serializable;

/**
 * @Author 龙江锋
 * @Date 2021/3/21 15:42
 * @Version 1.0
 *
 * 本类用于测试单例设计模式2-懒汉式--面试重点!!!
 *
 * 总结:
 * 1.延迟加载的思想:是指不会在第一时间加载资源(创建对象)来占用内存,
 *   而是什么时候需要用到,什么时候才去加载资源(创建对象)
 * 2.线程安全问题:多线程场景+共享资源+多条语句操作此共享数据：有线程并发的数据隐患。
 *   可以通过加锁的方式[同步代码块/同步方法]
 *
 * 饿汉式与懒汉式的区别:
 * 饿汉式是不管你用不用这个类的对象,先帮你创建一个
 * 懒汉式是先不给你创建这个类的对象,等你需要时再帮你创建--延迟加载的思想
 */
public class SingleTons {
    public static void main(String[] args) {

        MySingle2 my1 = MySingle2.getMySingle2();
        MySingle2 my2 = MySingle2.getMySingle2();

        System.out.println(my1 == my2);
        System.out.println(my1);
        System.out.println(my2);
    }
}

/**0.创建单例类*/
class MySingle2 {

    /**①、私有化构造方法--为了防止外界调用此构造方法创建对象*/
    private MySingle2(){}

    /**②、在类的内部创建好引用类型成员变量  --注意私有化 -- 延迟加载
          本处引用类型变量single也需要用static修饰,因为静态资源只能调用静态资源*/
    private static MySingle2 single;

    //static Object obj = new Object();

    /*
     * 问题:程序中有共享资源single,并且有多条语句(3句)操作了共享资源
     * 此时single共享资源一定会存在多线程数据安全问题
     * 解决方案:加同步锁-同步代码块-同步方法[由于方法中的所有代码都被同步了,所以可以直接变成同步方法]
     * 锁的位置:操作共享资源的多条语句
     * 锁对象:static中不能使用this & 外部创建了obj,注意是static的
     */

    /**③、对外提供全局访问点，对外提供公共的getXxx(),返回本类对象
     * 注意要使用static来修饰本公共方法,方便后续通过类名之间调用*/
    public static synchronized MySingle2 getMySingle2() {

        /* 同步代码块:静态区域内不能使用this关键字,因为静态资源优先于对象this加载
         * 因为静态资源属于类资源,随着类的加载而加载,而this指的是本类对象*/

        //synchronized (this) {//报错
        //synchronized (obj) {

        /*④、当用户调用此方法时,才说明用到对象了,那么再将本类对象返回
        如果调用此方法时为null,说明之前没有new过,保存的是默认值null*/
        if(single == null) {
            single = new MySingle2(){};
        }
        //将本类对象返回
        return single;
        //}
    }
}

/**
 * ##被volatile修饰的变量能够保证每个线程能够获取该变量的最新值，从而避免出现数据脏读的现象。##
 *
 * volatile关键字的两层语义
 *     一旦一个共享变量（类的成员变量、类的静态成员变量）被volatile修饰之后，那么就具备了两层语义：
 *
 *     ①、保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
 *     （1）当写一个volatile变量时，JMM会把该线程本地内存中的变量强制刷新到主内存中去；
 *     （2）这个写会操作会导致其他线程中的volatile变量缓存无效。
 *
 *     ②、禁止进行指令重排序。
 *     重排序是指编译器和处理器为了优化程序性能而对指令序列进行排序的一种手段。重排序需要遵守一定规则：
 *     （1）重排序操作不会对存在数据依赖关系的操作进行重排序。
 * 　       比如：a=1;b=a; 这个指令序列，由于第二个操作依赖于第一个操作，所以在编译时和处理器运行时这两个操作不会被重排序。
 *     （2）重排序是为了优化性能，但是不管怎么重排序，单线程下程序的执行结果不能被改变
 * 　       比如：a=1;b=2;c=a+b这三个操作，第一步（a=1)和第二步(b=2)由于不存在数据依赖关系，
 *          所以可能会发生重排序，但是c=a+b这个操作是不会被重排序的，因为需要保证最终的结果一定是c=a+b=3。
 *          重排序在单线程下一定能保证结果的正确性，但是在多线程环境下，可能发生重排序，影响结果
 *
 *     -------------------------------------------------------------------------------------------
 *     a.当程序执行到volatile变量的读操作或者写操作时，在其前面的操作的更改肯定全部已经进行，
 *     且结果已经对后面的操作可见；在其后面的操作肯定还没有进行；
 *
 *     b.在进行指令优化时，不能将对volatile变量访问的语句放在其后面执行，也不能把volatile变量后面的语句放到其前面执行。
 *     即执行到volatile变量时，其前面的所有语句都执行完，后面所有语句都未执行。
 *     且前面语句的结果对volatile变量及其后面语句可见。
 *
 *     ----------------------------------------------------------------------------------------------
 *     volatile原理:
 *     volatile可以保证线程可见性且提供了一定的有序性，但是无法保证原子性。
 *          在JVM底层volatile是采用"内存屏障"来实现的。
 *          观察加入volatile关键字和没有加入volatile关键字时所生成的汇编代码发现，加入volatile关键字时，
 *          会多出一个lock前缀指令，lock前缀指令实际上相当于一个内存屏障（也成内存栅栏），内存屏障会提供3个功能;
 *         （1）它确保指令重排序时不会把其后面的指令排到内存屏障之前的位置，也不会把前面的指令排到内存屏障的后面;
 *             即在执行到内存屏障这句指令时，在它前面的操作已经全部完成;
 *         （2）它会强制将对缓存的修改操作立即写入主存;
 *         （3）如果是写操作，它会导致其他CPU中对应的缓存行无效。
 * */

class DoubleLock implements Serializable {

    /**
     * 双重锁校验的单例
     */
    private static final long serialVersionUID = -2661668900873276710L;
    /** volatile防止指令重排序，内存可见
       (缓存中的变化及时刷到主存，并且其他的内存失效，必须从主存获取)*/
    public static volatile DoubleLock doubleLock = null;

    private DoubleLock(){
        //构造器必须私有  不然直接new就可以创建
    }

    public static DoubleLock getInstance(){
        //第一次判断，假设会有好多线程，如果doubleLock没有被实例化，那么就会到下一步获取锁，只有一个能获取到，
        //如果已经实例化，那么直接返回了，减少除了初始化时之外的所有锁获取等待过程
        if(doubleLock == null){
            synchronized (DoubleLock.class){
                //第二次判断是因为假设有两个线程A、B,两个同时通过了第一个if，然后A获取了锁,进入,然后判断doubleLock是null，
                //他就实例化了doubleLock，然后他出了锁，
                //这时候线程B经过等待A释放的锁，B获取锁了，如果没有第二个判断，那么他还是会去new DoubleLock()，
                // 再创建一个实例，所以为了防止这种情况，需要第二次判断
                if(doubleLock == null){
                    //下面这句代码其实分为三步：
                    //1.开辟内存分配给这个对象
                    //2.初始化对象
                    //3.将内存地址赋给虚拟机栈内存中的doubleLock变量
                    //注意上面这三步，第2步和第3步的顺序是随机的，这是计算机指令重排序的问题
                    //假设有两个线程，其中一个线程执行下面这行代码，如果第三步先执行了，就会把没有初始化的内存赋值给doubleLock
                    //然后恰好这时候有另一个线程执行了第一个判断if(doubleLock == null)，然后就会发现doubleLock指向了一个内存地址
                    //这另一个线程就直接返回了这个没有初始化的内存，所以要防止第2步和第3步重排序
                    doubleLock = new DoubleLock();
                }
            }
        }
        return doubleLock;
    }
}