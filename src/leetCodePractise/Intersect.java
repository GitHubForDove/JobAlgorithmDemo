package leetCodePractise;


import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。

 示例 1:

 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 输出: [2,2]
 示例 2:

 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 输出: [4,9]
 说明：

 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 我们可以不考虑输出结果的顺序。
 进阶:

 如果给定的数组已经排好序呢？你将如何优化你的算法？
 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Intersect {


    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        int[] res = intersect(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap();


            for (int i=0;i<nums1.length;i++) {

                if (map.containsKey(nums1[i])) {
                    int value = map.get(nums1[i]);
                    map.put(nums1[i],++value);
                }else {
                    map.put(nums1[i],1);
                }

            }

            List<Integer> list = new ArrayList<>();

            for (int j=0;j<nums2.length;j++) {

                if (map.containsKey(nums2[j]) && map.get(nums2[j])>0) {
                    list.add(nums2[j]);
                    int keyValue = map.get(nums2[j]);
                    map.put(nums2[j], --keyValue);
                }
            }

            int[] res = new int[list.size()];
            for (int k=0;k<res.length;k++) {
                res[k] = list.get(k);
            }

            return res;
    }
}
