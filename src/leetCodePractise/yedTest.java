package leetCodePractise;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class yedTest {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            String test = sc.next();
            //float res = ratio(str);
            double res = ratio(str,test)*100;

            System.out.println(String.format("%.2f",res)+ "%");
        }
    }

    public static double ratio(String str, String test) {

        char[] c = str.toCharArray();
        for (int i=0; i<str.length(); i++) {
            if (c[i] >= 'A' && c[i] <= 'Z' || c[i] >= 'a' && c[i] <= 'z' || c[i] >= '0' && c[i] <= '9') {
                c[i] = '1';
            } else {
                c[i] = '0';
            }
        }
        char[] t = test.toCharArray();
        int count =0;
        for (int j=0; j< c.length; j++) {
            if (c[j] == t[j])
                count ++;
        }
        double res = (double) count / (double)c.length;
        return  res;
    }
}
