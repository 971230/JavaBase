package com.ljf.company.day02;

import java.math.BigDecimal;
import java.util.Scanner;

/**
@author 龙江锋
 *  一、八大基本数据类型
 *  变量就是申请内存来存储值。也就是说，当创建变量的时候，需要在内存中申请空间。
----------------------------------------------------------------
           类型名称     字节空间           取值范围
----------------------------------------------------------------
整数型       byte        1          -27到27-1 或者 -128到127      
           short        2             -215到215-1
           int          4             -231到231-1
           long         8             -263到263-1
----------------------------------------------------------------
浮点型       float       4         单精度，对小数部分的精度要求不高
           double       8         双精度，精确的小数部分并操作值很大时
----------------------------------------------------------------
字符         char       2                0到65535
----------------------------------------------------------------
布尔        boolean     1            真true  假false
----------------------------------------------------------------
 *  引用类型：
 *  引用类型是一个对象类型，值是什么呢？它的值是指向内存空间的引用，就是地址，
 *  所指向的内存中保存着变量所表示的一个值或一组值。
 * */

public class Day02 {
	public static void main(String[] args) {
		//1.整型：
		byte byteMax = Byte.MAX_VALUE;
		byte byteMin = Byte.MIN_VALUE;
		short shortMax = Short.MAX_VALUE;
		short shortMin = Short.MIN_VALUE;
		int intMax = Integer.MAX_VALUE;
		int intMin = Integer.MIN_VALUE;
		long longMax = Long.MAX_VALUE;
		long longMin = Long.MIN_VALUE;
		System.out.println(byteMax);
		System.out.println(byteMin);
		System.out.println(shortMax);
		System.out.println(shortMin);
		System.out.println(intMax);
		System.out.println(intMin);
		System.out.println(longMax);
		System.out.println(longMin);
		//2.浮点型：
		float floatMax = Float.MAX_VALUE;
		float floatMin = Float.MIN_NORMAL;
		double doubleMax = Double.MAX_VALUE;
		double doubleMin = Double.MIN_VALUE;
		System.out.println(floatMax);
		System.out.println(floatMin);
		System.out.println(doubleMax);
		System.out.println(doubleMin);
		//3.字符型(ascll码) char类型允许存放数字，但是使用时回去查找数字对应的字符，使用字符本身
		//底层会自动查询，ascll码表规定了数字和字符的关系
		//ascll码表 只规定了数字0-127对应的字符，128-65535默认按照字符问号?来处理
		char charMax = Character.MAX_VALUE;
		char charMin = 65535;
		//char可以保存一个汉字
		//char z = '中';
		System.out.println(charMax);
		System.out.println(charMin);
		//System.out.println(z);
		//4.布尔型
		boolean booleanMax = Boolean.FALSE;
		boolean booleanMin = Boolean.TRUE;
		System.out.println(booleanMax);
		System.out.println(booleanMin);

		/*二、引用数据类型：
		 * 引用类型是一个对象类型，值是什么呢？它的值是指向内存空间的引用，就是地址，
		 * 所指向的内存中保存着变量所表示的一个值或一组值。如：类，接口，数组
		 * 还有抽象数据结构(ADT)
		 * */

		/* Java Scanner类：语法：
		 * Scanner s = new Scanner(System.in); */
		// 从键盘接收数据
		//新建扫描，扫描系统的输入
		Scanner scan = new Scanner(System.in);
		// nextLine方式接收字符串
		System.out.println("nextLine方式接收：");
		// 判断是否还有输入
		//接收系统输入的下一行
		if (scan.hasNextLine()) {
			String str2 = scan.nextLine();
			System.out.println("输入的数据为：" + str2);
		}
		scan.close();//关闭扫描输入
		//动态接收键盘输入的值
		double k = new Scanner(System.in).nextDouble();
		System.out.println(k);


		/*三、基本类型的字面值（5条）*/

		//①.整数字面值是int类型
		//错，右侧是int类型，但是超出范围
		//int o 999999999999999;
		int o = 999999999;

		//②.byte，short，char三种比int小的整数可以用范围内的值直接赋值
		//对
		byte p = 127;
		//byte l=128;//错，右面已经超过byte范围是int类型的数据

		//③.浮点数的字面值是double类型
		//对
		double q = 3.14;
		//float r=3.14;//错，右面是double，float是四字节double是八字节存不下

		//④.字面值后缀l f d
		//L –long   如：long a = 99999999999;//错，超出范围，解决方案加L
		//F –float   如：float a = 3.14;//错，右面是double类型，解决方案加F
		//D –double  如：double a = 3;//错，右面是int，解决方案加D或者改成3.0
		double l = 9999999999999D;
		float m = 99999999999999999F;
		short u = 'q';

		//⑤.进制前缀
		// ob   -- 二进制
		// 0x   -- 16进制
		// 0    -- 8进制
		//u    --标识这是char类型，属于16进制


		/*四、基本数据类型转换*/
		/*容量大的类型转换为容量小的类型时必须使用强制类型转换。
		1)转换过程中可能导致溢出或损失精度
		例如：int  i =128; byte b = (byte)i; //打印的结果是-128
		因为 byte 类型是 8 位，最大值为127，所以当 int 强制转换为 byte 类型时，值 128 时候就会导致溢出。
		2)浮点数到整数的转换是通过舍弃小数得到，而不是四舍五入
		例如：float f = 32.7f; int a2 =(int) f;    //打印的结果是32
		3)不能对boolean类型进行类型转换。
		口诀：小到大，直接转  大到小，强制转  浮变整,小数没
		byte,short,char —> int —> long—> float —> double
		*/

		//1.小转大(隐式转换)
		byte a = 120;
		//直接转
		int b = a;
		System.out.println(b);
		//2.大转小(显式转换) 需要强制类型转换 注意：小数转成整数，小数直接舍弃
		int x = 3569;
		byte y = (byte)x;
		System.out.println(y);


		/*五、运算规则(5条)*/
		/*①.计算结果的数据类型，与最大类型一致
		3/2   得1 ，而不是1.5，结果是int类型
		3d/2  得1.5，相当于double/int，结果是double类型*/

		/*②.byte,short,char三种比int小的整数，运算时会先自动转换成int*/
		byte c = 3;
		byte d = 4;
		byte f = (byte)(c + d);
		//7
		System.out.println(f);
		//byte f=c+d;错，运行时，byte会先自动转成int再运算，int+int还是int

		/*③.整数运算溢出
		整数运算，类似于一个中标，转到最大时，再转会回到最小。
		计算：光速运行一年的长度是多少米*/
		//Numeric overflow in expression
		System.out.println(300000000*60*60*24*365);
		//后缀需放第一个数字的后面
		System.out.println(300000000L*60*60*24*365);

		/*④.浮点数运算不精确*/
		System.out.println(1-0.8);
		System.out.println(4.35*100);
		//使用BigDecimal,源码843-845详解原因
		BigDecimal b1 = new BigDecimal(String.valueOf(0.01));
		BigDecimal b2 = new BigDecimal(String.valueOf(0.05));
		BigDecimal b3 = new BigDecimal(String.valueOf(0.06));
		if(b1.add(b2).compareTo(b3) == 0) {
			System.out.println("两个数字相等!");
		}else {
			System.out.println("两个数字不相等!");
		}

		/*⑤.浮点数的特殊值
		Infinity 无穷大  3.14/0
		NaN not a number  0/0.0*/
		System.out.println(3.14/0);
		System.out.println(0/0.0);
	}
}
