package leetCodePractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


/**
 *
 * 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

 注意：答案中不可以包含重复的三元组。

 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums =  new int[]{8733,-14859,-83082,-75794,-82082,-24871,-1};
        List<List<Integer>> lists = threeSum(nums);
        Iterator it = lists.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i=0; i< nums.length;i++) {

            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int low = i+1;
            int height = nums.length-1;

            while (low < height) {
                List<Integer> list = new ArrayList<>();

                if ((nums[i] + nums[low]+nums[height]) == 0) {
                    list.add(nums[i]);
                    list.add(nums[low]);
                    list.add(nums[height]);
                    lists.add(list);

                    while (low < height && nums[low] == nums[low+1]) {
                        low++;
                    }
                    while (low < height && nums[height] == nums[height-1]) {
                        height--;
                    }

                    low++;
                    height--;
                }else if ((nums[i] + nums[low]+nums[height]) < 0) {
                    low++;
                }else {
                    height--;
                }
            }

        }

        return lists;
    }

}
