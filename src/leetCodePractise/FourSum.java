package leetCodePractise;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class FourSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        List<List<Integer>> ls = againFourSum(nums, 0);
        Iterator  it = ls.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ls=new ArrayList<>();
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                int l=j+1;
                int r=nums.length-1;
                while(l<r){
                    if(nums[i]+nums[j]+nums[l]+nums[r]==target){
                        ls.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        while(l<r && nums[l+1]==nums[l]) l++;
                        while(l<r && nums[r-1]==nums[r]) r--;
                        l++;
                        r--;
                    }else if(nums[i]+nums[j]+nums[l]+nums[r]<target){
                        while(l<r && nums[l+1]==nums[l]) l++;
                        l++;
                    }else{
                        while(l<r && nums[r-1]==nums[r]) r--;
                        r--;
                    }
                }
            }
        }
        //去重
        List<List<Integer>> list=new ArrayList<>();
        for (int i = 0;i<ls.size(); i++){
            if (!list.contains(ls.get(i))){
                list.add(ls.get(i));
            }
        }
        return list;
    }


    public static List<List<Integer>> againFourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        int len = nums.length;
        for (int i=0; i< len-3; i++) {
            for (int j=i+1; j<len-2;j++) {
                int r = len-1;
                int l = j+1;
                while (l<r) {
                    if ((nums[i]+nums[j]+nums[l]+nums[r]) == target) {
                        ls.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        while (l<r && nums[l] == nums[l+1]) l++;
                        while (l<r && nums[r] == nums[r-1]) r--;
                        l++;
                        r--;
                    }else if ((nums[i]+nums[j]+nums[l]+nums[r]) < target){
                        while (l<r && nums[l] == nums[l+1]) l++;
                        l++;
                    }else {
                        while (l<r && nums[r] == nums[r-1]) r--;
                        r--;
                    }
                }
            }
        }

        List<List<Integer>> list =new ArrayList<>();
        for(int k=0; k < ls.size(); k++) {
            if (!list.contains(ls.get(k))) {
                list.add(ls.get(k));
            }
        }
        return list;
    }
}
