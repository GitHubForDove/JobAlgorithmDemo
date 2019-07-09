package leetCodePractise;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;
import java.util.Scanner;


/**
 *  大数问题解决
 *
 *   模拟平常计算的方式  进行计算
 */
public class TwoNumMuliply {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            String num1 = sc.next();
            String num2 = sc.next();

            String s = muliply(num1, num2);
            System.out.println(s);
        }
    }


    public static String muliply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        StringBuilder sb = new StringBuilder();
        int[] d = new int[num1.length() + num2.length()];

        for (int i=0; i< num1.length(); i++) {
            int a = num1.charAt(i) -'0';
            for (int j=0; j < num2.length();j++) {

                int b = num2.charAt(j) - '0';
                d[i + j] += a * b;
            }
        }

        for (int k=0 ; k < d.length; k++) {
            int dight = d[k] % 10;
            int carry = d[k] / 10;
            sb.insert(0, dight);
            if (k < d.length-1 ) {
                d[k+1] += carry;
            }
        }

        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
