package LeetCode;

import java.util.Scanner;

/**
 * 给定两个数字（0-9）字符串（长度不限）求它们的乘积。

 输入描述:
 第一行为第一个数字字符串

 第二行为第二个数字字符串

 输出描述:
 乘积字符串

 输入例子1:
 123
 20

 输出例子1:
 2460
 */
public class TwoStringAddQuestion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            System.out.println(stringAdd(str1, str2));
        }
    }

    public static String stringAdd(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int i = 0;
        long x = 0, y = 0;
        while(len1> 0 || len2 > 0) {
            if (len1> 0) {
                x = x * 10 + Long.parseLong(String.valueOf(str1.charAt(i)));
                System.out.println(x);
            }
            if (len2 > 0) {
                y = y * 10 + Long.parseLong(String.valueOf(str2.charAt(i)));
                System.out.println(y);

            }
            len1 --;
            len2 --;
            i ++;
        }
        return x*y + "";
    }
}
