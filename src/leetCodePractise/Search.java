package leetCodePractise;


/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 */
public class Search {

    public static void main(String[] args) {


        int[] nums = new int[]{1,1,1,1,1,1,1,1};
        int target = 1;
        System.out.println(search(nums, target));

       /* Scanner sc = new Scanner(System.in);
        while (true) {

            String s = sc.next();
            s = s.trim().replace(",","");
            char[] c = s.toCharArray();
            int[] nums = new int[c.length];
            for (int i=0; i< c.length; i++) {
                nums[i] = Integer.valueOf(c[i]);
            }
            int target = sc.nextInt();
            System.out.println(search(nums, target));
        }*/
    }


    public static int search(int[] nums, int target) {
        int len = nums.length-1;
        int low = 0;

        if (nums.length == 0 || nums == null) return -1;

        if (nums[0] == nums[len]) {
            if (nums[0] == target) return 0;
        } else if (nums[0] < nums[len]) {
            return binarySearch(nums, target);
        } else {
            if (nums[0] <= target ) {

                while (nums[low] <= target) {
                    if (nums[low] == target) {
                        return low;
                    }
                    if (nums[low] > nums[low + 1]) return -1;
                    low++;
                }
            } else{
                if (nums[len] >= target) {
                    while (nums[len] >= target) {
                        if (nums[len] == target) return len;
                        if (nums[len] < nums[len-1]) return -1;
                        len --;
                    }
                }
            }
        }

        return -1;
    }

    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

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
