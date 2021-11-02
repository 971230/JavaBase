package com.ljf.company.day18;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 龙江锋
 * @Date 2021/3/21 16:01
 * @Version 1.0
 *
 * 注解
 * 1.1 概念
 *   注解很厉害，它可以增强我们的java代码，同时利用反射技术可以扩充实现很多功能。它们被广泛应用于三大框架底层。
 * 传统我们通过xml文本文件声明方式，而现在最主流的开发都是基于注解方式，代码量少，
 * 框架可以根据注解去自动生成很多代码，从而减少代码量，程序更易读。例如最火爆的SpringBoot就完全基于注解技术实现。
 *   注解设计非常精巧，初学时觉得很另类甚至多余，甚至垃圾。有了java代码干嘛还要有@注解呢？
 * 但熟练之后你会赞叹，它竟然可以超越java代码的功能，让java代码瞬间变得强大。大家慢慢体会吧。
 *   常见的元注解：@Target、@Retention，jdk提供将来描述我们自定义的注解的注解。
 * 听起来好绕，别着急，做两个例子，立刻清晰。现在现有“元注解”这个概念。
 *
 * 1.2 分类
 * l  JDK自带注解
 * l  元注解
 * l  自定义注解
 *
 * 1.3  JDK注解
 * JDK注解的注解，就5个：
 * l  @Override :用来标识重写方法
 * l  @Deprecated 标记就表明这个方法已经过时了，但我就要用，别提示我过期
 * l  @SuppressWarnings("deprecation") 忽略警告
 * l  @SafeVarargs jdk1.7出现，堆污染，不常用
 * l  @FunctionalInterface jdk1.8出现，配合函数式编程拉姆达表达式，不常用
 *
 * 1.4  元注解
 * 定义注解的注解，就5个：
 * l  @Target       :注解用在哪里：类上、方法上、属性上(里面的值可以多个)
 * l  @Retention    :注解的生命周期：源文件中、.class字节码文件中、运行中
 * l  @Inherited    :允许子注解继承
 * l  @Documented   :生成javadoc时会包含注解，不常用
 * l  @Repeatable   :注解为可重复类型注解，可以在同一个地方多次使用，不常用
 *
 * 元注解
 * 2.1 @Target   ElementType.class
 * 描述注解存在的位置：
 * l  ElementType.TYPE                 应用于类的元素
 * l  ElementType.METHOD               应用于方法级
 * l  ElementType.FIELD                应用于字段或属性(成员变量)
 * l  ElementType.ANNOTATION_TYPE      应用于注释类型
 * l  ElementType.CONSTRUCTOR          应用于构造函数
 * l  ElementType.LOCAL_VARIABLE       应用于局部变量
 * l  ElementType.PACKAGE              应用于包声明
 * l  ElementType.PARAMETER            应用于方法的参数
 *
 * 2.2 @Retention  RetentionPolicy.class
 * 定义了该注解被保留的时间长短，某些注解仅出现在源代码中，而被编译器丢弃；
 * 而另一些却被编译在class文件中； 编译在class文件中的注解可能会被虚拟机忽略，而另一些在class被装载时将被读取。
 * 为何要分有没有呢？没有时，反射就拿不到，从而就无法去识别处理。
 *
 * l  SOURCE        在源文件中有效（即源文件保留）
 * l  CLASS         在class文件中有效（即class保留）
 * l  RUNTIME       在运行时有效（即运行时保留）
 *
 * 自定义注解
 * 3.1定义注解
 * 注意：注解的语法写法和常规java的语法写法不同
 */
public class Annotations {
    public static void main(String[] args) {
        TestAnnotation testAnnotation = new TestAnnotation();
        testAnnotation.eat();
        System.out.println(testAnnotation.name);
    }
}

/**
 * @author 龙江锋
 */

/* ②、通过@Target注解表示此自定义注解可以使用的位置
 * 注意@Target注解使用时需要导包
 * 通过ElementType.静态常量值来指定此自定义注解可以标记的元素
 * 如果有多个值,可以使用"{   ,  } "的格式来写:
 * @Target({ElementType.METHOD,ElementType.TYPE})
 * */
@Target(ElementType.METHOD)//表示此注解可以用来标记方法


/* ③、通过@Retention注解表示自定义注解的声明周期
 * 注意@Retention使用时需要导包
 * 通过RetentionPolicy.静态常量值 来指定此自定义注解的生命周期
 * 也就是指自定义注解可以存活到哪个阶段:源文件/字节码文件/运行时,只能3选1,不能写多个,
 * 因为源码:RetentionPolicy value();
 * */
@Retention(RetentionPolicy.SOURCE)


/* ①、首先注意:自定义注解的语法与java不同,不要套用java的语法
 * 定义自定义注解,注解名是Tests
 * 注解定义需要使用"@interface 注解名" 的方式来定义
 * */
@interface Tests{
    /** ⑤、自定义注解还可以添加功能--给注解添加属性
     *   注意int age();不是方法的定义,而是给自定义注解中定义age属性的语法
     *   如果为了使用注解时方便,还可以给age属性指定默认值,这样就可以直接使用,格式:"int age() default 0;"
     */
    //int age();//报错,要么自己赋值，要么赋予默认值

    int age() default 0;
    //String sex();


    /** ⑥、注解中还可以添加功能--可以定义特殊属性value
     *  特殊属性的定义方式与别的属性相同,主要是使用方式不同
     *  使用此注解给属性赋值的时候可以不用写成"@Tests(value = "apple")",
     *  格式可以简化成"@Tests("apple")",直接写值（没有冲突时）
     *  但是在自定义注解类中的赋予默认值不能简写,如果自定义了默认值,使用时可以不用赋值直接使用属性的默认值
     */
    String value() default "lemon";
}


/** ④、使用注解时,只要在指定的自定义注解名字前加上@即可使用此注解
    自定义一个类用来测试自定义注解*/
class TestAnnotation{

    /**测试1:TestAnnotation/name属性/eat()都添加了@Tests注解,只有方法上不报错
     * 结论: 自定义注解能够加在什么位置,取决于@Target的值
     * 测试2:修改@Target的值@Target({ElementType.METHOD,ElementType.FIELD,ElementType.TYPE}),
     * 3个@Tests都不再报错
     * 结论:注解@Tests可以有多个位置,多个值,可以使用"{ , }"的格式,@Target中维护的是ElementType[]数组
     * */
    //@Test

    String name;


    /* 测试3:添加了age属性以后,@Tests注解报错
     * 结论:当注解没有定义属性时,可以直接使用,如果有属性了,就需要给属性赋值
     * 测试4:给@Tests注解的age属性赋值以后,就不报错了
     * 结论:给属性赋值时的格式"@Tests(age = 10)",注意,不能直接写10这种错误格式
     * 测试5:给age属性赋予默认值后,还可以不加属性直接使用@Tests注解,此时使用的就是age属性的默认值0
     * 测试6:给特殊属性value赋值时可以简写,相当于value = "lemon"*/
    //@Test("lemon")
    /**测试7:因为已有默认值,所以不用给特殊属性value赋值,直接使用@Tests*/
    @Tests
    public void eat() {
        System.out.println("干饭啦！");
    }
}