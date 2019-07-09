package leetCodePractise;

import java.util.*;

public class Permute {

    // 使用boolean[] 来记录状态
    static boolean[]  used ;

    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        List<List<Integer>> res = permuteUnique(nums);
        Iterator it = res.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }


    public static List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) return res;

        used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        generatePermutetation(nums,0, list);

       /* Set set = new HashSet();
        Iterator it = res.listIterator();
        while(it.hasNext()) {
            set.add(it.next());
        }

        Iterator<List<Integer>> iterator = set.iterator();
        List<List<Integer>> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add( iterator.next());
        }
        return result;*/
       return res;
    }

    //
    public static List<List<Integer>> permute(int[] nums) {

        if (nums.length == 0) return res;

        used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        generatePermutetation(nums,0, list);

        return res;
    }


    static HashMap<List<Integer>,Integer> map = new HashMap<>();
    public static void generatePermutetation(int[] nums, int index, List<Integer> p) {

        // 边界条件 当index==nums.length的时候
        if (index == nums.length) {
            if (!map.containsKey(p)) {
                res.add(p);
                map.put(p,1);
            }

            return;
        }

        // 递归过程

        // 实际上就是dfs的思想
        for (int i=0;i<nums.length;i++) {

            // 判断是否nums[i]是否在p中
            if (!used[i]) {
                // nums[i]添加在p中
                p.add(nums[i]);
                used[i] = true;
                generatePermutetation(nums, index+1, new ArrayList<>(p));
                // 回溯 还原状态
                p.remove(p.size()-1);
                used[i] = false;
            }
        }

    }

    public static void dfs(List<List<Integer>> res, List<Integer> list, int[] nums,int index) {

    }
}

