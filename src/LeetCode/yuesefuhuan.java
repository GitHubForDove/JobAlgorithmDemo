package LeetCode;

import java.util.ArrayList;
import java.util.Scanner;

public class yuesefuhuan {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            yuesefu(n,m);
        }
    }

    public static void yuesefu(int n, int m) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i=1; i<= n; i++) {
            list.add(i);
        }

        int x=0;
        while (list.size() > 0) {

            x = x + m;
            x = x % list.size()-1;

            if (x < 0) {
                if (list.size() == 1) System.out.println();
                System.out.print(list.get( list.size()-1));
                list.remove(list.size()-1);
                x=0;
            } else {
                System.out.print(list.get(x));
                list.remove(x);
            }
        }

    }
}
