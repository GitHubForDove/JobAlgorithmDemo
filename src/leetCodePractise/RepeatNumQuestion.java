package leetCodePractise;

import java.util.Scanner;

/**
 * 不修改数组找出重复的数字
 */
public class RepeatNumQuestion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] str = new int[]{1,2,4,2,3,5,6,5};
        System.out.println(str[repeatNum(str, str.length)]);
        while (sc.hasNext()) {

        }
    }

    public static int repeatNum(int[] str, int length) {
        if (str == null && length <0) return -1;

        int start = 0;
        int end = length-1;

        while (end >= start) {
            System.out.println("end:" + end + " start: " + start + "  " + "middle:" + ((end - start)>>1 +start));
            int middle = ((end - start)>>1) + start;
            int count = countRange(str, length, start, end);

            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }

            if (count > (middle -start + 1)) {
                end = middle;
            } else {
                start = middle+1;
            }
        }

        return start;
    }

    public static int countRange(int[] str, int len, int start, int end) {
        int count = 0;

        for (int i=0; i < len; i++) {
            if (str[i] > start && str[i] < end -1) {
                ++count;
            }
        }
        return count;
    }
}
