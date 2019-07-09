package leetCodePractise;

import java.util.Arrays;

public class N26_removeDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[]{4,5};
        int res = removeDuplicatesSame(nums,4);
        System.out.println(res);
    }


    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * 示例 1:
     *
     * 给定数组 nums = [1,1,2],
     *
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     */

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;

        if (len ==0 || nums == null) return 0;

    int temp = nums[0];
    int cur = 1;

        for (int i = 1; i<len;i++) {

        if (nums[i] != temp) {
            nums[cur] = nums[i];
            temp = nums[i];
            cur++;
        }
    }
        return cur;
}


    /**
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * 示例 1:
     *
     * 给定 nums = [3,2,2,3], val = 3,
     *
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums
     * @return
     */

    /* 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

    不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

    元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。*/
    public static int removeDuplicatesSame(int[] nums, int val) {
        int len = nums.length;

        if (len ==0 || nums == null) return 0;

        int count =0;
        for (int i = 0;i < len;i++) {
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }



}
