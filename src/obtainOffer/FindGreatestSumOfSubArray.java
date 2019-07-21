package obtainOffer;

/**
 * 面试题42：连续子数组的最大和
 *
 *  输入一个整形数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *  要求时间复杂度为O（n）
 */
public class FindGreatestSumOfSubArray {

    public static void main(String[] args) {
        int[] data = new int[]{1,-2,3,10,-4,7,2,-5};
        int res = findGreatestSumOfSubArray(data, data.length);
        System.out.println(res);
    }

    public static boolean InvalidInput = false;

    /**
     * 思路： 如果累加起来比0 还小 那么就舍弃前面的累加 直接从本次开始累加
     */
    public static int findGreatestSumOfSubArray(int[] data, int length) {
        if (data == null || length <= 0) {
            InvalidInput = true;
            return 0;
        }

        InvalidInput = false;
        int curSum = 0;
        int greatestSum = Integer.MIN_VALUE;
        for (int i=0; i< length; i++) {
            if (curSum <= 0) {
                curSum = data[i];
            } else {
                curSum += data[i];
            }

            if (curSum > greatestSum) {
                greatestSum = curSum;
            }
        }
        return greatestSum;
    }


}
