package leetCodePractise;


/**
 *   Given an unsorted array of integers, find the length of longest increasing subsequence.

     Example:

     Input: [10,9,2,5,3,7,101,18]
     Output: 4
     Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */

public class LengthOfLIS {

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int max = lengthOfLIS(nums);
        System.out.println(max);
    }

    public static int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int maxans = 1;

        for (int i=1;i<len; i++) {
            int maxVal = 0;
            for (int j=0;j<i;j++) {

                if (nums[i] > nums[j]) {
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }

            dp[i] = maxVal+1;
            maxans = Math.max(maxans, dp[i]);

        }


        return maxans;
    }
}
