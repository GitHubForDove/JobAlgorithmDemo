package leetCodePractise;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * 输入一个数组
 * 将这个数组分为两个数组  并且两个数组的和相等
 */
public class kugouMusicQuestion {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {


            int n = sc.nextInt();
            int[] str = new int[n];

            int sum = 0;
            for (int i=0;i<n; i++) {
                str[i] = sc.nextInt();
                sum += str[i];
            }

            if (sum %2 != 0) {
                System.out.println("false");
            } else {



            }


        }
    }

    public static ArrayList<char[]> split(int[] str, int n, int sum) {
        int[][] dp = new int[n+1][sum/2 + 1];
        for (int i=1; i < n;i++) {
            for (int j=1;i<sum/2; j++) {

                if (j >= str[i]) {
                    dp[i][j] = Math.max(dp[i][j-str[i]] + str[i-1], dp[i-1][j]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }


            }
        }


        return null;

    }


}
