package leetCodePractise;

import java.util.Arrays;

public class SortColors {


    public static void main(String[] args) {
        int[] nums = new int[]{2,1,0,1,2,0,0,1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 三路快排
    public static void sortColors(int[] nums) {
        int zero = -1;
        int two = nums.length;

        for (int i=0;i<two;) {

            if (nums[i] == 1){
                i++;
            } else if (nums[i] == 2) {
                two--;
                swap(nums,i,two);
            }else { // nums[i] == 0
                zero++;
                swap(nums, zero, i);
            }

        }
    }

    public static void swap(int[] nums, int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
