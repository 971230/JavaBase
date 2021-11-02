package com.ljf.company.day18;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author 龙江锋
 * @Date 2021/3/21 16:11
 * @Version 1.0
 *
 * 一、JVM内存中的两大对象:java对象分为字节码对象和实例对象
 *
 * 二、字节码对象:
 *      每个类在加载(将类读到内存)时都会创建一个字节码对象,
 *      且这个对象在一个JVM内存中是唯一的.此对象中存储的是类的结构信息.
 *
 *    反射前提：获取字节码对象
 *    如何获取字节码对象:
 *    ①、Class.forName("类的全路径");
 *    ②、类名.class
 *    ③、对象.getClass();
 *    说明:字节码对象是获取类结构信息的入口.
 *
 *
 * 思考:
 *
 * 1.类加载时会做哪些事情?
 *      1)  构建类的字节码对象,类型为Class类型
 *      2)  可能会初始化类中的静态变量(类变量)
 *      3)  可能会执行类中的静态代码块.(具体是否执行由加载方式决定)
 *
 * 2.  谁负责将类加载(读)到内存中?   类加载器(ClassLoader)
 *
 * 3.  谁提供类加载器?(JDK官方或者第三方)
 *
 * 三、类的实例对象
 * 如何理解类的实例对象(类的对象)
 *
 * 1) 客观事务在内存中的呈现(堆内存中的一块区域)
 * 2) 类的实例对象在同一个JVM内存中可以有多份.
 *
 * Java中对象的创建方式
 *
 *      1）通过new关键字创建
 *      2）通过反射创建(首先要先获取字节码对象)
 *
 * Java中对象的作用？
 * 1)  存储数据(变量:类变量,实例变量,参数变量,局部变量)
 *
 *      a)  Pojo (普通的java对象)
 *      b)  Vo (值对象)
 * 2)  执行业务逻辑(方法):各司其职,各尽所能.
 *      a)  Controller --前台--网页
 *      b)  Service -- 业务--校验
 *      c)  Dao -- 数据--数据库
 *      建议:面向对象设计时不要设计一个大而全的对象.
 *
 *
 *
 * ①、获取包名 类名
 * clazz.getPackage().getName()//包名
 * clazz.getSimpleName()//类名
 * clazz.getName()//完整类名
 *
 * ②、获取成员变量定义信息
 * getFields()//获取所有公开的成员变量,包括继承变量
 * getDeclaredFields()//获取本类定义的成员变量,包括私有,但不包括继承的变量
 * getField(变量名)
 * getDeclaredField(变量名)
 *
 * ③、获取构造方法定义信息
 * getConstructor(参数类型列表)//获取公开的构造方法
 * getConstructors()//获取所有的公开的构造方法
 * getDeclaredConstructors()//获取所有的构造方法,包括私有
 * getDeclaredConstructor(int.class,String.class)
 *
 * ④、获取方法定义信息
 * getMethods()//获取所有可见的方法,包括继承的方法
 * getMethod(方法名,参数类型列表)
 * getDeclaredMethods()//获取本类定义的的方法,包括私有,不包括继承的方法
 * getDeclaredMethod(方法名,int.class,String.class)
 *
 * ⑤、反射新建实例
 * clazz.newInstance();//执行无参构造创建对象
 * clazz.newInstance(666,”海绵宝宝”);//执行含参构造创建对象
 * clazz.getConstructor(int.class,String.class)//获取构造方法
 *
 * ⑥、反射调用成员变量
 * clazz.getDeclaredField(变量名);//获取变量
 * clazz.setAccessible(true);//使私有成员允许访问
 * f.set(实例,值);//为指定实例的变量赋值,静态变量,第一参数给null
 * f.get(实例);//访问指定实例变量的值,静态变量,第一参数给null
 *
 * ⑦、反射调用成员方法
 * Method m = Clazz.getDeclaredMethod(方法名,参数类型列表);
 * m.setAccessible(true);//使私有方法允许被调用
 * m.invoke(实例,参数数据);//让指定实例来执行该方法
 *
 *
 * JUnit 单元测试框架:
 * JUnit 第三方开源工具
 * JUnit 是Java单元测试的事实标准
 * eclipse 集成了JUnit，可以直接在项目中引入JUnit jar 包
 * 集成了 JUnit 的运行器
 * TIPS:访问权限是public、返回值是void、没有参数，最重要的是用@Test注解标记该方法
 *
 * 好处:
 * 可以书写一系列的测试方法，对项目所有的接口或者方法进行单元测试。
 * 启动后，自动化测试，并判断执行结果, 不需要人为的干预。
 * 只需要查看最后结果，就知道整个项目的方法接口是否通畅。
 * 每个单元测试用例相对独立，由Junit 启动，自动调用。不需要添加额外的调用语句。
 * 添加，删除，屏蔽测试方法，不影响其他的测试方法。 开源框架都对JUnit 有相应的支持
 */
public class ReflectTest {

    //①.创建入口函数main()--不用
    /* 单元测试方法:是java测试的最小单位,使用灵活,推荐使用
     * 语法要求: @Test注解修饰 + void + 没有参数 + public
     * 注意使用时需要导包:Add JUnit4 library to the build path:import org.junit.Test;
     * 单元测试方法执行方式:选中方法名-->右键运行(Run As-->JUnit Test)-->出现小绿条说明执行成功
     */

    /**②.通过单元测试来测试如何获取类字节码对象*/
    @Test
    public void getClazz() throws Exception {

        //第一种方式：forName(),此处的参数是类的全路径名[包名+类名],并且需要抛出异常
        Class<?> student1 = Class.forName("com.ljf.company.day18.Student");
        //第二种方式
        Class<?> student2 = Student.class;
        //第三种方式：先创建匿名对象,匿名对象没有名字,然后对象的字节码对象
        Class<?> student3 = new Student().getClass();


        //反射得到的字节码Class对象
        //class com.ljf.company.day18.Student
        System.out.println(student1);
        //获取类的全路径名[包名+类名]
        //com.ljf.company.day18.Student
        System.out.println(student2.getName());
        //只获取类名
        //Student
        System.out.println(student3.getSimpleName());
        //获取包名
        //com.ljf.company.day18
        System.out.println(student3.getPackage().getName());
    }

    /**③.通过单元测试来测试如何获取构造方法*/
    @Test
    public void getConstruct() {

        //1.获取字节码Class对象(必须)
        Class<?> clazz = Student.class;

        //2.获取所有构造方法,并放入cs数组中,元素是一个个构造方法
        Constructor<?>[] cs = clazz.getConstructors();

        //3.获取每个构造
        //使用增强for循环完成
        //for(1 2 : 3){循环体}其中3是要遍历的数据,1是遍历后每个元素的数据类型 2是遍历后每个数据的变量名
        for (Constructor<?> c : cs) {
            //操作每轮循环到的当前构造方法，以后可以获取构造方法的相关信息
            //获取构造方法的名称
            System.out.println(c.getName());
            //获取构造方法的参数类型,可能有多个
            Class<?>[] cps = c.getParameterTypes();
            System.out.println(Arrays.toString(cps));
        }
        /*
         *   com.ljf.company.day18.Student(构造函数名字)
         *   [](无参构造的参数)
         *   com.ljf.company.day18.Student(构造函数名字)
         *   [class java.lang.String, int](有参构造的参数类型)
         */
    }


    /**④.通过单元测试来测试获取成员(普通)方法*/
    @Test
    public void getFunction() throws ClassNotFoundException {

        //1.获取Class字节码对象
        Class<?> clazz = Class.forName("com.ljf.company.day18.Student");
        //2.获取所有成员(普通)方法
        Method[] methods = clazz.getMethods();

        //3.遍历数组,获取每个方法的信息
        for (Method m : methods) {
            //获取方法名
            System.out.println(m.getName());
            //获取方法参数类型
            Class<?>[] parameterTypes = m.getParameterTypes();
            System.out.println(Arrays.toString(parameterTypes));
            System.out.println("****************");
        }
    }

    /**⑤.通过单元测试来测试获取成员变量*/
    @Test
    public void getFields(){

        //1.获取Class字节码对象
        /* Class<?>中的"?"是泛型约束的通配符,类似于"*" */
        Class<?> clazz = new Student().getClass();

        //2.获取所有的成员变量,公共的!!!
        /* !!!注意目前成员变量的修饰符必须是public才能获取到,采用默认修饰符就反射不到
         * getFields()没有这个功能*/
        Field[] fs = clazz.getFields();

        //3.遍历数组,获取每个成员变量的信息
        for (Field f : fs) {
            //获取变量名
            System.out.println(f.getName());
            //获取变量类型
            System.out.println(f.getType().getName());
            System.out.println("**************************");
        }
    }


    /**⑥.通过单元测试来测试反射创建对象
     * 利用反射技术来创建对象的2中方式：
     * 方式一:通过字节码对象直接调用newInstance(),默认触发无参构造来创建对象
     * 方式二:先获取指定的构造方法对象,再通过构造方法对象调用newInstance(),触发对应的构造函数来创建对象
     */
    @Test
    public void getObject() throws Exception {

        //1.获取Class字节码对象
        Class<?> clazz = Student.class;

        //2.创建对象
        //触发的是无参构造
        Object obj = clazz.newInstance();
        //Student [name=null,age=0]
        System.out.println(obj);
        System.out.println("***********************");


        //3.可以指定去获取哪个构造方法,注意根据参数来指定,
        // 而且传入的是不是参数的直接类型，而是参数的字节码对象
        Constructor<?> c = clazz.getConstructor(String.class , int.class);

        //4.触发指定的构造方法：利用刚刚拿到的构造方法对象，创建Student对象，触发的是全参构造
        Object obj2 = c.newInstance("海绵宝宝" , 3);
        //Student [name=海绵宝宝,age=3]
        System.out.println(obj2);
        System.out.println("********************************");


        //5.查看对象具体的属性值,或者调用方法,需要把Object强转成指定的子类类型
        /*为什么要把Object强转成子类类型?因为想要使用子类的特有属性和方法,父类无法使用子类的特有功能
         * obj是Object类型,Object中没有Student的属性与功能
         * 这个操作叫做向下转型，属于多态--想使用子类特有功能时需要做此操作
         * 把子类类型看做父类类型--多态的向上转型，为了同一调用方式，把所有子类类型看做父类来看，比如异常
         */

        Student s = (Student)obj2;
        System.out.println(s.name);
        System.out.println(s.age);
        s.tell(666);
    }
}
