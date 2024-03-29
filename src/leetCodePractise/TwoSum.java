package leetCodePractise;

import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {

    }


    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i< nums.length;i++) {
            int x = nums[i];
            if(map.containsKey(target-x)) {
                return new int[]{map.get(target-x),i};
            }
            map.put(x,i);
        }
        return null;
    }
}
