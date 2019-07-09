package LeetCode;


import java.util.*;

/**
 * 紧急疏散
 时间限制：C/C++语言 1000MS；其他语言 3000MS
 内存限制：C/C++语言 65536KB；其他语言 589824KB
 题目描述：
 体育场突然着火了，现场需要紧急疏散，但是过道真的是太窄了，同时只能容许一个人通过。现在知道了体育场的所有座位分布，座位分布图是一棵树，已知每个座位上都坐了一个人，安全出口在树的根部，也就是1号结点的位置上。其他节点上的人每秒都能向树根部前进一个结点，但是除了安全出口以外，没有任何一个结点可以同时容纳两个及以上的人，这就需要一种策略，来使得人群尽快疏散，问在采取最优策略的情况下，体育场最快可以在多长时间内疏散完成。

 输入
 第一行包含一个正整数n，即树的结点数量（1<=n<=100000）。

 接下来有n-1行，每行有两个正整数x，y，表示在x和y结点之间存在一条边。(1<=x<=y<=n)

 输出
 输出仅包含一个正整数，表示所需要的最短时间


 样例输入
 6
 2 1
 3 2
 4 3
 5 2
 6 1
 样例输出
 4
 */
public class MinTimeExit {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n= sc.nextInt();
            ArrayList list = new ArrayList();
            for (int i=0; i<n-1;i++) {
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();
                list.add(new int[]{num1,num2});
            }
            for (int j=0; j< list.size(); j++) {
                System.out.println(Arrays.toString((int[]) list.get(j)));
            }

            int count = minTimeExit(list);
            System.out.println(count);
        }
    }

    public static int minTimeExit(ArrayList list) {
        int count =0;
        Queue<int[]> q = new LinkedList<>();
        q.add((int[]) list.get(0));
        list.remove(0);
        while (list.size() >0) {
            Iterator it = list.listIterator();
            while (it.hasNext()) {
                int[] num = (int[]) it.next();
                int[] compare = q.peek();

                if (num[0]==compare[0] || num[1] == compare[0] ||
                        num[0]==compare[1] || num[1] == compare[1]) {
                    q.add(num);
                    count ++;
                    q.poll();

                }

            }
            list.remove(0);
        }
        return count;
    }
}
