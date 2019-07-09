package LeetCode;


import java.util.Scanner;

/**
 * KB跳格子
 时间限制：C/C++语言 1000MS；其他语言 3000MS
 内存限制：C/C++语言 131072KB；其他语言 655360KB
 题目描述：
 KB今天很开心，跟局长玩起了跳格子的游戏，游戏规则是这样的。

 局长在地上连续的画了很多的格子，格子编号依次为1，2，3，...

 KB会玩T轮游戏，每次站在一个编号为n的格子上，KB每次的跳跃非常讲究，如果这个数字是奇数，
 那么KB下一次会跳到3n+1的位置，如果这个数字是偶数，那么KB将跳跃到n/2的位置，不停的这样跳，
 局长看的有些无聊，局长想知道KB究竟要跳多少次才能跳到1。

 输入
 第一行一个整数T

 第二行是T个正整数n

 1<=T<=100

 1<=n<=1000

 输出
 对于每一个正整数n，每行输出一个数s，表示KB在编号为n的格子上跳多少次会跳到1，如果n无法跳到1，则输出-1


 样例输入
 3
 1 2 3
 样例输出
 0
 1
 7

 提示
 1
 */
public class JumpWay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int T = sc.nextInt();
            int n = sc.nextInt();
            int[] str = new int[n];
            for (int i=0; i<n;i++) {
                str[i] = sc.nextInt();
            }
        }
    }

    public static int jump(int T, int[] n) {
        return 0;
    }

}
