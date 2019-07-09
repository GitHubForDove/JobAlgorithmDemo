package LeetCode;



import java.util.Arrays;
import java.util.Scanner;

public class FindKidsString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            int n = sc.nextInt();
            String[] strs = new String[n];
            for (int i=0; i< n;i++) {
                strs[i] = sc.next();
            }
            String T = sc.next();
            Arrays.sort(strs);
            System.out.println(Arrays.toString(strs));
            int count = 0;
            for (int j=0; j<n; j++ ) {
                while (T.contains(strs[j])) {
                    count ++;
                    T = T.replaceFirst(strs[j],"");
                }
            }
            System.out.println(count);
        }
    }
}
