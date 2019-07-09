package LeetCode;


/**
 * 二进制中1的个数
 */
public class Question15 {


    public static void main(String[] args) {
        int count = numberOf1(-8);
        System.out.println(count);
    }

    public static int numberOf1(int n) {
        int count = 0;
        if (n < 0) {
            n = Math.abs(n);
            count = 1;
        }


        while (n > 0) {
            ++count;
            n = (n-1) & n;
        }
        return count;
    }
}
