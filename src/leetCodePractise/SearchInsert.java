package leetCodePractise;

public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 4;
        System.out.println(searchInsert(nums,target));
    }


    public static int searchInsert(int[] nums, int target) {

        int len = nums.length;
        for (int i = 0; i < len; i++) {
           if (target == nums[i]) return i;
        }

        if (target < nums[0]) return 0;

        for (int j=1; j<len; j++) {
            if (target < nums[j]) {
                return j;
            }
        }

        return len;
    }


}
