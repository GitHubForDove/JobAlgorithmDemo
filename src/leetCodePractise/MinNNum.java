package leetCodePractise;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 找出数组中的n个最小的数
 */
public class MinNNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            int n = sc.nextInt();
            int[] num = new int[n];
            for (int i=0; i< n;i++) {
                num[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            ArrayList<Integer> list = minNNum(num,k);
            System.out.println(Arrays.toString(list.toArray()));
        }
    }



    public static ArrayList<Integer> minNNum(int[] num, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->o2-o1);
        for (int i=0; i< num.length;i++) {
            if (maxHeap.size() < k ){
                maxHeap.add(num[i]);
            }
            else if ( maxHeap.peek() > num[i]) {
                maxHeap.poll();
                maxHeap.add(num[i]);
        }
    }

    for (int j=0; j< k; j++) {
        list.add(maxHeap.poll());
    }

    return list;
    }
}
