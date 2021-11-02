package com.ljf.company.day13;

import java.io.*;

/**
 * @Author 龙江锋
 * @Date 2021/3/12 18:51
 * @Version 1.0
 *
 * 本类用于序列化与反序列化的测试类
 *
 *    序列化:是指把程序中的java对象,永久保存在磁盘中,相当于是写出的过程,
 *          序列化就是将一个对象转换成字节序列，方便存储和传输。
 *          不会对静态变量进行序列化，因为序列化只是保存对象的状态，静态变量属于类的状态。
 *          序列化(Serialization)是将对象的状态信息转换为可以存储或传输形式的过程.
 *          在序列化期间,对象将其当前状态写入到临时或持久性存储区.以后可以通过从存储区中读取或者帆序列化对象的状态,
 *          重新创建该对象.
 *    序列化:利用ObjectOutputStream,把对象的信息,按照固定的格式转成一串字节值输出并持久保存到磁盘
 *    方向是 out --> ObjectOutputStream
 *
 *
 *    反序列化:是指把已经序列化在文件中保存的数据,读取/恢复到java程序中的过程,
 *    方向是 in  --> ObjectInputStream
 *
 *
 *特点/应用场景
 *      1.需要序列化的文件必须实现Serializable接口,用来启用序列化功能
 *      2.不需要序列化的数据可以修饰成static,原因:static资源属于类资源,不随着对象被序列化输出
 *      3.每一个被序列化的文件都有一个唯一的id,如果没有添加此id,编译器会自动根据类的定义信息计算产生一个
 *      4.在反序列化时,如果和序列化的版本号不一致,无法完成反序列化
 *      5.常用与服务器之间的数据传输,序列化成文件,反序列化读取数据
 *      6.常用使用套接字流在主机之间传递对象
 *      7.不需要序列化的数据也可以被修饰成transient(临时的),只在程序运行期间在内存中存在,不会被序列化持久保存
 *
 *  ObjectOutputStream
 *       ObjectOutputStream将Java对象的基本数据类型和同行写入OutputStream.
 *       可以使用ObjectInputStream读取(重构)对象.通过在流中使用文件可以实现对象的持久存储.
 *       如果流是网络套接字流，则可以在另一台主机上或另一个进程中重构对象.
 *   构造方法:
 *       ObjectOutputStream(OutputStream out)
 *       创建写入指定 OutputStream 的 ObjectOutputStream
 *   方法:
 *       writeObject(Object obj) 将指定的对象写入 ObjectOutputStream
 *
 *   4.4  ObjectInputStream
 *      ObjectInputStream对以前使用ObjectOutputStream写入的基本数据和对象进行反序列化
 *   构造方法:
 *       ObjectInputStream(InputStream in):创建从指定 InputStream 读取的 ObjectInputStream
 *   方法:
 *      readObject():从 ObjectInputStream 读取对象
 *
 *
 *      如果本类想要完成序列化,必须实现可序列化接口,否则会报错:
 *      m报错信息:java.io.NotSerializableException: com.xxx.serializable.Student
 *      Serializable接口是一个空接口,里面一个方法都没有,作用是用来当做标志,标志这个类可以序列化/反序列化
 */
public class Serial {
    public static void main(String[] args) {
        serialization();//本方法用来完成序列化的功能
        deserialize();//本方法用于完成反序列化功能
    }


    /**反序列化方法*/
    public static void deserialize() {
        //声明在本方法内都生效的局部变量,局部变量需要初始化,默认值是null
        ObjectInputStream in = null;
        try {
            //1.创建ObjectInputStream流对象来完成反序列化
            in = new ObjectInputStream(new FileInputStream("D://ready//1.txt"));
            //2.通过流对象反序列化生成指定对象
            Object o = in.readObject();
            System.out.println(o);
            System.out.println("恭喜您!反序列化成功!");
        } catch (Exception e) {
            System.out.println("很抱歉!反序列化失败!");
            e.printStackTrace();
        } finally {//一定会执行的代码块写释放资源的代码
            try {
                //3.释放资源
                assert in != null;
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**序列化方法*/
    public static void serialization() {
        //声明在本方法内都生效的局部变量,局部变量需要初始化,默认值是null
        ObjectOutputStream out = null;
        try {
            //1.创建ObjectOutputStream流对象来完成序列化
            out = new ObjectOutputStream(new FileOutputStream("D://ready//1.txt"));
            //2.指定要序列化(输出)的对象
            Student obj = new Student("海绵宝宝",3,"大海底部","男");
            //3.通过OOS流对象来序列化输出Student对象
            out.writeObject(obj);
            System.out.println("恭喜你!序列化成功!");
        } catch (IOException e) {
            System.out.println("很抱歉!序列化失败!");
            e.printStackTrace();
        }finally {//关流的操作要放在finally{}中--因为此代码块一定会执行
            try {
                //4.关流操作
                assert out != null;
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/*4.7测试报错1:
报错原因:如果测试时,代码报此错误,说明要序列化的类并没有实现序列化接口
解决方案:实现序列化接口

4.8测试报错2:
报错原因:测试时,使用的是之前序列化的UID,和本次反序列化时的UID不匹配,所以报错
解决方案:写好需要序列化对象类的UID,或者一次序列化对应一次反序列化,不匹配就报错
很抱歉!反序列化失败!

java.io.InvalidClassException: cn.tedu.serializable.Student;
local class incompatible: stream classdesc serialVersionUID = 5648240250298459244,
local class serialVersionUID = -3193364654654535741*/
