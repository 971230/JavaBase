package com.ljf.company.day03;

import java.util.Random;
import java.util.Scanner;

/**
 * @author 龙江锋
 * 方法-流程控制-循环
 *
 *运算符：
-----------------------------------------------------------------------------
算术运算符         + - * /                        基本运算
                  %                          取余数，求模，算整除
                ++     --                      自增    自减
-----------------------------------------------------------------------------
比较运算符          ==                            相等比较
                  ！=                           不等比较
-----------------------------------------------------------------------------
逻辑运算符       &&(更高效) &          逻辑与(短路与)，两边同为真结果才为真，双与和单与
               ||(更高效) |       逻辑或(短路或)，两边只要有一个真结果就是真，双或和单或
                   +                           字符串连接
                   ！                      非，非真是假，非假是真
1 && 2 ,当1为false时，运算结果就注定为false，此时没有必要执行2，就发生短路现象，来提高效率
1 || 2 ,当1为true时，运算结果就注定为true，此时没有必要执行2，就发生短路现象，来提高效率
-----------------------------------------------------------------------------
三元运算符           ？：           三项运算 ； 1?2:3  ；1是真取2，1是假取3
-----------------------------------------------------------------------------
赋值运算符            =                          赋值运算
               +=  -=  *=  /=         复合的赋值运算  a+=2;//a=a+2
-----------------------------------------------------------------------------
 */

public class Day03 {
    public static void main(String[] args) {
        //前缀式：符号在前，先变化后使用；后缀式：符号在后，先使用在变化
        int w = 1;
        int m = 1;
        //1
        System.out.println(w++);
        //2
        System.out.println(++m);
        //3
        System.out.println(++w);
        //4+2+2=8,受之前代码的影响，此时m已经为2
        System.out.println(++w + m + m++);

        int r = 0;
        int t = 0;
        //0，先使用再自减
        System.out.println(r--);
        //-1，先自减再使用
        System.out.println(--t);
        //(-2)-(-2)-(-1)-(-1)=2,此时r已为-1，t已为-1,中间的r经过--r后变为-2
        System.out.println(--r - r -t - t--);

        //比较三个数大小
        int u = new Scanner(System.in).nextInt();
        int v = new Scanner(System.in).nextInt();
        int o = new Scanner(System.in).nextInt();

        int max = u>v ? u : v;
        max = max>o ? max : o;
        //或者
        int max1 = u>v ? (u>o ? u : o) : (v>o ? v : o);

        System.out.println(max);
        System.out.println(max1);

        //平年闰年判断
        int year = new Scanner(System.in).nextInt();
        //默认值为平年
        String result = "平年";
        System.out.println(year + result);
        if ((year%4 == 0 && year%100 != 0) || year%400 == 0){
            System.out.println("闰年");
        }else {
            System.out.println("平年");
        }

        /*分支结构1.if ：
        * 顺序结构的程序虽然能解决计算、输出等问题，但不能做判断再选择。
        * 对于要先做判断再选择的问题就要使用分支结构。*/
        //单分支
        int a = 3;
        double price = new Scanner(System.in).nextDouble();
        double count;
        if (price < 5){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        //嵌套分支
        if (price >= 1000){
            count = price * 0.7;
        }else if (price >= 800 ){
           count = price * 0.8;
        }else if (price >= 600){
            count = price * 0.9;
        }else {
            count = price;
        }
        System.out.println(count);

        /*分支结构2：switch：
        * 当一个case成立，从这个case向后穿透所有case，
        * 包括default，直到程序结束或者遇到break程序才结束
        * 当变量值与 case 语句值相等时，开始执行此case 语句的内容,执行完会判断此行代码是否有break,
        * 如果有,结束执行,如果没有,会继续向后执行穿透所有case,包括default*/
        switch (a){
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            default:
                System.out.println("default");
                break;
        }

        /*循环结构1：for:
        循环结构是指在程序中需要反复执行某个功能而设置的一种程序结构。
        它由循环体中的条件，判断继续执行某个功能还是退出循环。
        根据判断条件,循环结构又可细分为先判断后执行的循环结构和先执行后判断的循环结构。
        for(开始条件;循环条件;更改条件){循环体;}*/
        for (int b = 0; b < a; b++){
            System.out.println(b);
        }

        /*嵌套for循环：根据外层的条件，判断里层能否执行，外层控制执行的轮数，内层控执行的次数
        如果能执行，就把里层代码都循环完毕后，再继续执行外层，继续判断。。*/
        //正方形
        //外层循环控制行数
        for(int i = 1; i < 5; i++){
            //内层循环控制列数
            for(int j = 1; j < 5; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        //例：左直角三角形
        for (int i = 1; i < 6; i++){
            //注意:需要修改内循环的循环条件,让j的最大值随着i改变,否则写死了
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        //例:右直三角形
        for (int x = 0; x <= 6; x++){
            for (int y = x; y <= 6; y++){
                System.out.print("*");
            }
            System.out.println();
        }
        //例：正三角形1
        for(int i = 1; i <= 5; i++){
            //空行，把*挤到后面去，为倒左直三角形
            for(int j = 5; i <= j; j--) {
                System.out.print(" ");
            }
            //打印左直三角形，并且每一行的*被空格挤到最后，变为右直三角形
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            //打印少一次循环的左直三角形
            for(int j = 1; j < i; j++) {
                System.out.print("*");
            }
            //一起拼出正三角形
            System.out.println();
        }
        //例：正三角形2
        for(int i = 1; i <= 5; i++){
            //打印空格的倒三角
            for(int j = 5; j >= i; j--){
                System.out.print(" ");
            }
            //打印*号的正三角
            for(int k = 1; k <= i * 2-1; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        //例：99乘法表
        for(int i = 1; i <= 9; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(i * j);
            }
            System.out.println();
        }
        //例：8行8列的杨辉三角
        //行数
        int row = 6;
        //6行6列数组
        int[][] yanghui = new int[row][row];
        //行
        for (int i = 0; i < row; i++){
            //列
            for(int j = 0; j <= i; j++){
                if (j == 0 || j == i){
                    yanghui[i][j] = 1;

                }else{
                    yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j];
                }
            //System.out.print(yanghui[i][j]+" ");
            }
            //System.out.println();
        }
        //等腰输出处理
        for (int i = 0; i < row; i++){
            int num = row -i;
            for(int j = 0; j <= num; j++){
                System.out.print(" ");
            }
            for(int k= 0; k <= i; k++){
                System.out.print(yanghui[i][k] + " ");
            }
            System.out.println();
        }

        /*break: 直接结束当前循环,跳出循环体,简单粗暴
          TIPS: break以后的循环体中的语句不会继续执行,循环体外的会执行
          continue: 跳出本轮循环,继续下一轮循环
          TIPS:continue后本轮循环体中的语句不会继续执行,但是会继续执行下轮循环,循环体外的也会执行
          用来终止循环，可以用两种方式*/
        //找88
        for(int i = 1; i <= 100; i++){
            //一直输入…
            int j = new Scanner(System.in).nextInt();
            if(j != 88){
                continue;//继续输入
                /*break或者continue之后都不允许写代码,都是不可到达的代码*/
                //System.out.println(0);//Unreachable statement
            }
            System.out.println(i);
            break;
            //System.out.println(0);//Unreachable statement
        }

        //拓展：
        /* ①：&和&&的区别:
        当一个&表达式在求值的时候，两个操作数都会被求值，&&更像是一个操作符的快捷方式。
        当一个&&表达式求值的时候，先计算第一个操作数，如果它返回true才会计算第二个操作数。
        如果第一个操作数取值为false,第二个操作数就不会被求值*/
        /*②：a=a+4和a+=4的区别:
           byte a = 1;
           a=(byte) (a+4);//右侧int，左侧byte，大转小，强转。
           a=(byte) (a+4);//右侧int，左侧byte，大转小，强转。
           a+=4;//会自动完成数据类型的转换
              //注意：a=a+4和a+=4是有区别的！！
           System.out.println(a);*/

        /*循环结构2：while：
        先判断，再执行*/
        System.out.println("猜1~1000的随机数");
        //系统产生0-100随机数，从0开始，要从1开始就加1
        int i = new Random().nextInt(100);
        System.out.println(i);
        //写一个死循环
        while(true){
            //接收用户输入的值
            int sc = new Scanner(System.in).nextInt();
            //判断
            if(sc > i){
                System.out.println("大");
            }else if(sc < i){
                System.out.println("小");
            }else{
                System.out.println("right");
                //一定注意:要设置程序出口!!!
                break;
            }
        }

        /*循环结构3：do-while:先执行，再判断，循环体代码保证最少执行一次*/
        int random = new Random().nextInt(100);
        do{
            int input = new Scanner(System.in).nextInt();
            System.out.println(random);
            System.out.println(input);
            if (input > random){
                System.out.println("大");
            }else if (input < random){
                System.out.println("小");
            }else {
                System.out.println("对");
            }
            break;
        }while (true);

        /*三种循环的区别
          三种循环都可以互相代替
        1、 for：知道和控制循环次数
        2、 while/do while：当循环次数不确定时
        3、 while：先判断，不符合规则，不执行代码
        4、 do while：代码最少被执行一次，再去判断，符合规则，再次执行代码*/
    }
}
