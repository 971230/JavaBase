package com.ljf.company.day18;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author 龙江锋
 * @Date 2021/3/21 16:29
 * @Version 1.0
 *
 * 暴力反射
 *   指可以将程序中的私有的属性或者方法通过反射技术，暴力的获取到资源
 *   本类用来测试暴力反射
 *
 * 本类用于测试暴力反射
 */
public class ReflectsTest {
    /**①.通过单元测试来测试暴力反射获取和设置私有属性*/
    @Test
    public void getField() throws Exception {

        //1.获取Class字节码对象
        Class<?> clazz = Person.class;

        //2.获取私有属性(引号里填私有属性名)
        Field field = clazz.getDeclaredField("name");
        //Field field1 = clazz.getDeclaredField("age");

        //3.根据获取到的属性对象获取属性类型
        System.out.println(field.getType().getName());

        //4.设置属性的值
        //set(m,n)-- m:要给哪个对象设置值,n:是要设置的具体值
        //4.1 没有对象就通过反射的方式创建对象
        Object obj = clazz.newInstance();

        //4.2暴力反射!!!设置私有可见
        field.setAccessible(true);

        //4.3给指定对象设置值
        field.set(obj, "派大星");

        //5.获取私有属性的值
        System.out.println(field.get(obj));
    }

    /**②.通过单元测试来测试暴力反射获取和设置私有方法*/
    @Test
    public void getFunction() throws Exception{

        //1.获取Class字节码对象
        Class<?> clazz = Person.class;

        //2.通过暴力反射获取私有方法
        //getDeclaredMethod("m",n,x,y...) m:要执行的方法名  n x y :是方法的参数类型,为字节码对象
        Method method = clazz.getDeclaredMethod("save", int.class, String.class);
        //Method method1 = clazz.getDeclaredMethod("update");

        //3.通过暴力反射执行私有方法
        //invoke(m,n,x,y...) m:要执行的哪个对象的方法  n x y :是方法的参数类型
        //3.1没有对象就通过反射的方式创建对象
        Object obj = clazz.newInstance();

        //3.2 想要执行私有方法,首先设置私有可见
        method.setAccessible(true);

        //3.3 invoke表示通过反射执行方法
        method.invoke(obj, 100, "蟹老板");
    }
}
