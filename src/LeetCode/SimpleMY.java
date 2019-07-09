package LeetCode;


import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 简单的模拟
 时间限制：C/C++语言 2000MS；其他语言 4000MS
 内存限制：C/C++语言 65536KB；其他语言 589824KB
 题目描述：
 桌上有一叠牌，从第一张牌（即位于顶面的牌）开始开始从上往下依次编号为1 到n。当至少还剩两张牌时进行以下操作：

 把第一张牌扔掉，然后把新的第一张放到整叠牌的最后。

 输入n，输出每次扔掉的牌，以及最后剩下的牌。

 输入
 输入第一行包含一个整数T，表示有T组测试数据

 接下来有T行，每行一个整数n，表示牌的张数

 (1 <= T <= 200 , 1 <= n <= 1000)

 输出
 对应每组输入，输出一行结果，每个数后有一个空格


 样例输入
 2
 2
 7
 样例输出
 1 2
 1 3 5 7 4 2 6

 提示
 样例解释
 对于第一组样例而言，初始我们将1拿出，然后将2扔到牌堆的最后，第2次取出2，所以应当输出1 2.
 对于第二组样例而言，初始我们将1拿出，然后将2扔到牌堆的最后，第2次取出3，依次操作，所以应当输出1 3 5 7 4 2 6
 */
public class SimpleMY {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();

            for (int i=0; i< n;i++) {
                int k = sc.nextInt();
                int[] arr = new int[k];
                for (int j=0; j < k; j++) {
                    arr[j] = j+1;
                }
                test(arr);
                System.out.println();
            }
        }
    }


    public static void test(int[] num) {
        Queue<Integer> q = new LinkedList<>();

        for (int i=0; i<num.length; i++) {
            q.add(num[i]);
        }

        while (q.size() >0) {

            System.out.print(q.poll() + " ");
            if (q.size() >0) {
                int pollElement = q.poll();
                q.add(pollElement);
            } else {
                return;
            }

        }

    }
}
