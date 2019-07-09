package leetCodePractise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KidsDay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            int n = sc.nextInt();
            int[] w = new int[n];
            for (int i=0; i< n;i++) {
                w[i] = sc.nextInt();
            }

            int m = sc.nextInt();
            int[] h = new int[m];
            for (int i=0; i< m;i++) {
                h[i] = sc.nextInt();
            }
            int num = num(w, h);
            System.out.println(num);
        }
    }


    public static int num(int[] w, int[] h) {

        Arrays.sort(w);
        Arrays.sort(h);
        int num=0;
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i< w.length; i++) {
            q.add(w[i]);
        }

        for (int j=0; j< h.length; j++) {
            if (h[j] >= q.peek()) {
                num++;
                q.poll();
            }
        }

        return num;

    }
}
