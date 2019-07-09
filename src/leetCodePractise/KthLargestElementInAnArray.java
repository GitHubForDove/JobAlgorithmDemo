package leetCodePractise;


/**
 * 找到第k大的元素
 */
public class KthLargestElementInAnArray {


    public static void main(String[] args) {
        int[] nums = new  int[]{15,123,3,13,1,7,5,5,24,23};
        findKLargestNum(nums, 0,nums.length-1,3);
        //System.out.println(num);
    }

    public static void findKLargestNum(int[] nums, int start, int end, int k) {

        if (start< end) {
            int index = partion(nums, start,end);

            if (index ==nums.length-k+1) {
                System.out.println(nums[index]);

            }else if (index < nums.length-k+1) {
                findKLargestNum(nums,index+1, end,nums.length-k+1);
            }else {
                findKLargestNum(nums, start,index-1,nums.length-k+1);
            }
        }
    }

    public static int partion(int[] nums, int start, int end) {

        int i = start;
        int j = end;
        int stard = nums[start];

        while (i<j) {

            while (i<j && stard <= nums[j]) {
                j--;
            }

            swap(nums, i++,j);

            while (i<j && nums[i] <= stard) {
                i++;
            }

            swap(nums, i,j--);
        }
        return i;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
