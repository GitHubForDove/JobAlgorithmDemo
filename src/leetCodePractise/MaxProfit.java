package leetCodePractise;

import java.util.*;

public class MaxProfit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] num = new int[n];
            for (int i=0; i< n; i++) {
                num[i] = sc.nextInt();
            }

            maxProfit(num);
        }
    }


    public static int[] maxProfit(int[] n) {

       /* int[][] res = new int[n.length][n.length];
        maxProfitAndCount(n, 0, 1,0,0);
        System.out.println(Arrays.toString(list.toArray()));
        return null;*/
       int[] choice = new int[]{-1,0,1};
       int profit = 0;
       int count = 0;
       ArrayList list = new ArrayList();

       for (int i=0; i< n.length; i++) {
            for (int j=0;j<choice.length; j++) {
                profit = maxProfitAndCount(n,i,choice[j], profit,count);
                if (i == n.length -1) list.add(new int[]{profit, count});
            }
       }

       return null;

    }

    public static int maxProfitAndCount(int[] n, int index, int choice, int profit, int count) {


        if (choice == -1) {
            profit -= n[index];
        } else if (choice == 0) {
            profit += 0;
        } else {
            profit += n[index];

        }
        return profit;

    }

    /*public static void maxProfitAndCount(int[] n, int index, int choice, int profit, int count) {

        if (index == n.length){
            Map map = new HashMap(profit, count);
            list.add(map);
            return;
        }

        if (choice == -1 ) {
            profit -= n[index];
            index ++;
        } else if (choice == 0){
            index ++;
        }else {
            profit += n[index];
            index ++;
            count ++;
        }

        maxProfitAndCount(n ,index++, -1,profit, count);
        maxProfitAndCount(n ,index++, 0,profit, count);
        maxProfitAndCount(n ,index++, 1,profit, count);

    }*/

}
