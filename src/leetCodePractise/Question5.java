package leetCodePractise;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Question5 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum(nums);
        for (List<Integer> l: list
             ) {
            System.out.println(l);
        }
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i=0; i< nums.length; i++) {

            if (nums[i] > 0) {
                break;
            }
            //跳过相同的数，避免重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j= i+1;
            int k = nums.length -1;
            int target = 0 - nums[i];
            while (j < k) {

                if ((nums[j] + nums[k]) == target){
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while (j < k && nums[j] == nums[j+1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k-1]) {
                        k--;
                    }
                    j++;
                    k--;
                }else if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }

            }
        }

        return list;

    }
}
