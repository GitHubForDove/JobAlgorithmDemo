package LeetCode;

import java.util.Scanner;

/**
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 内存限制：C/C++语言 131072KB；其他语言 655360KB
 题目描述：
 人族和兽族为了争夺一处矿产掀起了世界大战。大战在即，先知召集兽族各勇士学习新的攻击技能。

 先知想要让n(1<=n<=100000)个兽族勇士都分别学会k(1<=k<=100000)种技能，
 但一个一个教的效率太低，先知在精灵杂货铺那里买来了分身宝石，
 使用分身宝石后，就出现了m(1<=m<=100000)个先知。先知教会一个兽族勇士一个技能的时间是1分钟，
 一个兽族勇士在同一时间只能学习一个技能，一个先知在同一时间也只能教一个勇士学习技能，
 不同先知或不同勇士当然可以在同一时间教授或学习技能。

 大战即将爆发，先知想要知道最少需要多久才能教会n个勇士分别学会k个技能？
 */
public class ques2 {


    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        long n, k, m;
        while (cin.hasNextInt()) {

            n = cin.nextLong();
            k = cin.nextLong();
            m = cin.nextLong();
            long time = costTime(n, k, m);
            System.out.println(time);
            System.out.println("---------------");
            if (m >= n) System.out.println(k);
            else {
                if (n % m > 0) System.out.println((n / m + 1) * k);
                else System.out.println((n / m) * k);
            }
        }
    }

    public static long costTime(long n,long k, long m) {
        long time = 0;
        if (m >= n) {
            return k; //最快
        } else if (m < n){
            if (n %m ==0) time = n / m * k; // count为m的倍数，表示先知全部出动教兽人的次数
            else {
                time = (n/m +1) * k;
            }
        }
        return time;
    }
}
