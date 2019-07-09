package leetCodePractise;


import java.util.Scanner;

/**
 *  0/1背包 动态规划
 */
public class Knapsack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] weights = new int[n+1];
            int[] values = new int[n+1];
            for (int i=1; i<= n; i++) {
                weights[i]=sc.nextInt();
            }
            for (int j=1; j<= n; j++) {
                values[j]=sc.nextInt();
            }
            System.out.print("\t");
            int totalWeight = sc.nextInt();
            int max = knapsack(weights, values, totalWeight);
            System.out.println(max);
        }
    }

    public static int knapsack(int[] weight, int[] value, int totalWeight) {
        // dp[k][v]  : k 表示还剩下k个物品 没有装   v ： 表示剩下的容量大小
        int[][] dp = new int[weight.length][totalWeight+1];
        for (int i=0; i< weight.length; i++) {
            dp[i][0] = 0;
        }
        for (int j=0; j< totalWeight+1; j++) {
            dp[0][j] = 0;
        }

        for (int k = 1;k<weight.length;k++) {
            for (int c=1; c < totalWeight+1;c++) {
                if (weight[k] > c) {
                    dp[k][c] = dp[k-1][c];
                } else {
                    dp[k][c] = Math.max(dp[k-1][c-weight[k]] + value[k], dp[k-1][c]);
                }
            }
        }

        return dp[weight.length-1][totalWeight];
    }
}
