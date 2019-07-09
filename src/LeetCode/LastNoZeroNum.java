package LeetCode;

import java.math.BigInteger;
import java.util.Scanner;

public class LastNoZeroNum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            BigInteger sum = BigInteger.valueOf(1);
            int num = n;
            for (int i = 0; i < n; i++) {
                num = n - i;
                sum = sum.multiply(BigInteger.valueOf(num));
            }

            System.out.println(sum);
            String s = String.valueOf(sum);
            char[] c = s.toCharArray();
            int len = s.length() - 1;

            for (int i = len; i > 0; i--) {
                if (c[i] == '0') {
                    while (c[i - 1] == '0') {
                        i--;
                    }
                    System.out.println(c[i - 1]);
                    break;
                }
                System.out.println(c[i]);
            }
        }
    }

}
