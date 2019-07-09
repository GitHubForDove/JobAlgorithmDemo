package leetCodePractise;


import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class SearchRange {

    public static void main(String[] args) {
        int[] nums = new int[]{1,4};
        int target = 4;
        int[] res = new int[2];
        res = searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};

        if (nums.length == 0 || nums == null) return res;
        if (nums[0] == nums[nums.length-1]) {
            if (target == nums[0]) {
                res[0] = 0;
                res[1] = nums.length-1;
                return res;
            } else {
                return res;
            }

        }

        int index = binarySearch(nums, target);
        if (index == -1) return res;

        int low = index;
        int high = index;

        // 注意是数组中的下标 还是数组长度比较
        while ( (low-1) >=0 && nums[low-1] == target) {
            low--;
        }
        res[0] = low;

        // 注意是数组中的下标 还是数组长度比较
        while ((high +1) <= nums.length-1 && nums[high+1] == target ) {
            high++;
        }
        res[1] = high;

        return res;
    }

    public static int binarySearch(int[] nums, int target) {

        int len = nums.length;
        int low = 0;
        int high = len-1;

        while (low <= high) {

            int middle = (low + high) /2;

            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] < target) {
                low = middle+1;
            }else {
                high = middle-1;
            }
        }
        return -1;
    }
}
