package com.ljf.company.day11;

import java.util.Scanner;

/**
 * @Author 龙江锋
 * @Date 2021/3/11 18:08
 * @Version 1.0
 *
 * 正则表达式Regex
 * 5.1  概述
 * 正确的字符串格式规则。常用来判断用户输入的内容是否符合格式的要求，注意是严格区分大小写的。
 *
 * 5.2  常见语法
 *
 * 5.3  String提供了支持正则表达式的方法
 * Matches(正则) : 当前字符串能否匹配正则表达式
 * replaceAll(正则,子串) : 替换子串
 * split(正则) : 拆分字符串
 *
 *
 *  *              . - 除换行符以外的所有字符。
 *  *              ^ - 字符串开头。
 *  *              $ - 字符串结尾。
 *  *              \d,\w,\s - 匹配数字、字符、空格。
 *  *              \D,\W,\S - 匹配非数字、非字符、非空格。
 *  *              [abc] - 匹配 a、b 或 c 中的一个字母。
 *  *              [a-z] - 匹配 a 到 z 中的一个字母。
 *  *              [^abc] - 匹配除了 a、b 或 c 中的其他字母。
 *  *              aa|bb - 匹配 aa 或 bb。
 *  *              ? - 0 次或 1 次匹配。
 *  *              * - 匹配 0 次或多次。
 *  *              + - 匹配 1 次或多次。
 *  *              {n} - 匹配 n次。
 *  *              {n,} - 匹配 n次以上。
 *  *              {m,n} - 最少 m 次，最多 n 次匹配。
 *  *              (expr) - 捕获 expr 子模式,以 \1 使用它。
 *  *              (?:expr) - 忽略捕获的子模式。
 *  *              (?=expr) - 正向预查模式 expr。
 *  *              (?!expr) - 负向预查模式 expr。
 */
public class Regex {
    public static void main(String[] args) {

        //1.提示并接收用户输入的身份证号:
        System.out.println("请您输入您的身份证号:");
        String input = new Scanner(System.in).nextLine();

        //2.编辑正则表达式
        //身份证号的规律:一般都是18位,前17位都是数字(即出现17次),最后一位可能是数字,也有可能是X
        String regex = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";

        //3.判断,是否符合正则表达式的规则(也就是输入的是正确的身份证号吗?)
        //matches()是String类提供的功能,可以用来判断字符串是否符合正则表达式的要求
        if( input.matches(regex) ) {
            System.out.println("输入正确!");
        }else {
            System.out.println("输入不正确,请重新输入!");
        }
    }
}
