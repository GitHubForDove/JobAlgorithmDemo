package leetCodePractise;


import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 给出一个数组，算出其中其中3个数 最大的乘积
 */
public class MaxThreeNumberSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            BigInteger[] num = new BigInteger[n];

            for (int i=0; i<n;i++) {
                num[i] = sc.nextBigInteger();
            }

            BigInteger max = maxThreeNumberSum(num);
            System.out.println(max);
        }
    }


    public static BigInteger maxThreeNumberSum(BigInteger[] num) {

        Arrays.sort(num);
        System.out.println(Arrays.toString(num));
        int end = num.length-1;
        int start = 0;
        int cur = 1;
        BigInteger max = num[end].multiply(num[end-1]).multiply(num[end-2]);


        BigInteger temp = num[start].multiply(num[cur]).multiply(num[end]);


        return max.compareTo(temp) >0 ? max : temp;
    }
}
