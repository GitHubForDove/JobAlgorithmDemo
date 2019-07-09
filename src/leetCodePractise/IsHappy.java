package leetCodePractise;

import java.util.*;

public class IsHappy {

    public static void main(String[] args) {
        System.out.println(isHappy(10));
    }

    static Set set = new HashSet();
    public static boolean isHappy(int n) {

        if (set.contains(n)) {
            return false;
        }

        set.add(n);
        int sum = 0;
        while (n > 0) {
           sum +=(int) Math.pow(n%10,2);
           n = n/10;
        }

        if (sum == 1) {
            return true;
        }
        return  isHappy(sum);
    }
}
