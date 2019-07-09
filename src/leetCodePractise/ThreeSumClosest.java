package leetCodePractise;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] arr = new int[]{-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(arr, target));

    }

    // 使用for循环加双指针法  进行判断
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int result= nums[0] + nums[1] + nums[2];
        // 使用双指针法
        for (int i = 0; i<len-2; i++) {
            int l = i+1, r = len -1;
            while (l < r) {
                int threeSum = nums[i] + nums[l] + nums[r];
                if (Math.abs(threeSum - target) < Math.abs(result - target)) {
                    result = threeSum;
                }

                if (threeSum > target) {
                    r--;
                } else if (threeSum < target) {
                    l++;
                } else {
                    // 如果已经等于target的话, 肯定是最接近的
                    return target;
                }
            }
        }

         return result;
    }
}

