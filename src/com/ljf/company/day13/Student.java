package com.ljf.company.day13;

import java.io.Serializable;

/**
 * @Author 龙江锋
 * @Date 2021/3/12 18:42
 * @Version 1.0
 *
 * 序列化/反序列化
 * 4.1  概述
 * 序列化(Serialization)是将对象的状态信息转换为可以存储或传输形式的过程.
 * 在序列化期间,对象将其当前状态写入到临时或持久性存储区.
 * 以后可以通过从存储区中读取或者帆序列化对象的状态,重新创建该对象.
 * **序列化:利用ObjectOutputStream,把对象的信息,按照固定的格式转成一串字节值输出并持久保存到磁盘
 * **反序列化:利用ObjectInputStream,读取磁盘中之前序列化好的数据,重新恢复成对象
 * TIPS: 序列化: 对象 -> 字节值     反序列化:字节值(之前序列化生成的) -> 对象
 *
 * 4.2  特点/应用场景
 *      1.需要序列化的文件必须实现Serializable接口,用来启用序列化功能
 *      2.不需要序列化的数据可以修饰成static,原因:static资源属于类资源,不随着对象被序列化输出
 *      3.每一个被序列化的文件都有一个唯一的id,如果没有添加此id,编译器会自动根据类的定义信息计算产生一个
 *      4.在反序列化时,如果和序列化的版本号不一致,无法完成反序列化
 *      5.常用与服务器之间的数据传输,序列化成文件,反序列化读取数据
 *      6.常用使用套接字流在主机之间传递对象
 *      7.不需要序列化的数据也可以被修饰成transient(临时的),只在程序运行期间在内存中存在,
 *      不会被序列化持久保存
 */
public class Student implements Serializable {
    /*需要给每个进行序列化的文件分配唯一的UID值*/
    //The serializable class Student does not declare a static final
    // serialVersionUID field of type long
    /**private static final long serialVersionUID = 1L;*/
    private static final long serialVersionUID = 1363050008864224879L;

    //1.定义学生的相关属性 + private封装
    /**姓名*/
    private String name;
    /**年龄*/
    private int age;
    /**地址*/
    private String addr;
    /**性别*/
    private String gender;

    /**2.创建无参构造--必须手动提供无参构造,否则会被含参构造覆盖*/
    public Student() {
        System.out.println("我是Student的无参构造");
    }

    /**3.创建全参构造*/
    public Student(String name,int age,String addr,String gender) {
        super();//默认调用父类的无参构造
        this.name = name;
        this.age = age;
        this.addr = addr;
        this.gender = gender;
        System.out.println("我是Student的全参构造");
    }

    /**4.属性封装后,需要本类提供公共的属性访问与设置方式get()&set()*/
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**打印结果:cn.tedu.serializable.Student@4c873330-->地址值
     * 想看对象的属性值,原因是想查看序列化后对象的属性,需要重写toString()
     * 5.重写toString()*/
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                ", gender=" + gender +
                '}';
    }
}
