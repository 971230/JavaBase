package com.ljf.company.day12;

import java.io.File;

/**
 * @Author 龙江锋
 * @Date 2021/3/11 20:16
 * @Version 1.0
 */
public class FileSumRecursion {
    public static void main(String[] args) {
    //1.指定要求哪个目录的总大小
    /* 注意:此处指定的目录必须是真实存在的
     * 如果传一个不存在的文件夹会报错,如果是传了一个空文件夹,大小为0*/
    File file = new File("D:\\ready");

    //2.调用size()求目录大小,把路径传给size()
    long total = size(file);

    //3.接收结果并打印
    System.out.println("文件夹的总大小为:" + total);
}


    private static long size(File files) {
        //1.列出文件夹中的所有资源--listFiles()-->File[]
        File[] fs = files.listFiles();

        //2.遍历数组,依次处理数组中的每个file对象
        //2.1定义变量,记录总和
        long sum = 0;
        for(int i = 0; i < fs.length; i++) {
            //2.2通过下标操作当前遍历到的资源
            File f = fs[i];
            //2.3判断,当前资源是文件还是文件夹--文件夹大小为0,文件大小需要累加
            if(f.isFile()) {
                //--是文件,求文件的字节量大小length(),累加就行
                //相当于:sum = sum + f.length();
                sum += f.length();
            }else if(f.isDirectory()) {
                //--是文件夹,继续列出文件夹下的所有资源,1 2步骤--listFiles()-->File[]
                /*方法的递归,递归现象,就是在方法的内部调用方法自身*/
                sum += size(f);
            }
        }
        //把sum记录的值返回调用位置
        return sum;
    }
}
