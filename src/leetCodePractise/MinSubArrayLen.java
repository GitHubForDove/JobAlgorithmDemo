package leetCodePractise;


/**
 *   给定一个整型数组h和一个数字s，找到数组中最短的一个连续数组，是的连续子数组的数字和sum》=s，
 *   返回这个最短的连续子数组的返回值。
     什么是子数组？
     如果没有解怎么办？返回0
     如果有多个解  如果处理 是返回任意一个解 还是返回所有的解？
 */
public class MinSubArrayLen {


    public static void main(String[] args) {

    }

    /**
     * 滑动窗口
     * @return
     */
    public static int minSubArrayLen(int[] nums, int s) {
        int l =0,r = -1;  // nums[l....r]为我们的滑动窗口
        int sum=0;
        int res = nums.length+1;

        while (l<nums.length) {

            if (r+1 < nums.length && sum < s) {
                r++;
                sum += nums[r];
            }else {
                sum -= nums[l];
                l++;
            }

            if (sum >= s) {
                res  = Math.min(res, r-l+1);
            }
        }
        if (res == nums.length+1) {
            return 0;
        }
        return res;
    }
}
