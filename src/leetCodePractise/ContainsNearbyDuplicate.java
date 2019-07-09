package leetCodePractise;

import java.util.HashSet;
import java.util.Set;

public class ContainsNearbyDuplicate {

    public static void main(String[] args) {
        int[] nums = {1};
        int k = 1;
        System.out.println(containsNearbyDuplicate(nums,k));

    }


    /**
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
     * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
     *
     * 滑动窗口 + 查找表
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0, r = -1;

        if (nums.length==0 || k==0 ) return false;
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<k+1;i++) {
            if (i<nums.length ){
                ++r;
                if ( set.contains(nums[i])) {
                    return true;
                }
                set.add(nums[i]);
            }

        }

        for (int j=r+1;j<nums.length;j++) {

            set.remove(nums[l]);
            if (set.contains(nums[j])) {
                return true;
            } else {
                if (l+1<nums.length) {
                    l++;
                }

                set.add(nums[j]);
            }
        }

        return false;
    }
}
