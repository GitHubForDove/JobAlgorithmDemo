package leetCodePractise;


import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            String s = sc.nextLine();
            s = s.trim().replace(",", "");
            int len = s.length();
            int[] nums = new int[len];
            for (int i=0;i<len;i++) {
                nums[i] = s.charAt(i) -'0';
            }
            nextPermutation(nums);
        }
    }

    /**
     * 其实就是从数组倒着查找，找到nums[i] 比nums[i+1]小的时候，
     * 就将nums[i]跟nums[i+1]到nums[nums.length - 1]当中找到一个最小的比nums[i]大的元素交换。
     * 交换后，再把nums[i+1]到nums[nums.length-1]进行倒序，就ok了
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if (i >= 0) {
            int len = nums.length -1;

           while ( len >=0 && nums[len] <= nums[i]) {
               len --;
           }
           swap(nums,i,len);
        }
        reverse(nums, i+1,nums.length-1);



        System.out.println(Arrays.toString(nums));
    }

    public static void reverse(int[] nums, int start, int end) {
        int i=start, j = end;

        while (i<j) {
            swap(nums, i ,j);
            i++;
            j--;
        }

    }


    public static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

}
