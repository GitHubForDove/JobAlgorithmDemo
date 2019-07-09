package leetCodePractise;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 滑动窗口的最大值
 */
public class MaxInWindows {


    public static void main(String[] args) {
        int[] nums = new  int[]{2,3,4,2,6,2,5,1};
        int size = 3;
        ArrayList<Integer> list = maxInWindows(nums, size);
        System.out.println(Arrays.toString(list.toArray()));
    }

    /**
     * 滑动窗口的最大值
     * @param nums
     * @param size
     * @return
     */
    public static ArrayList<Integer> maxInWindows(int[] nums, int size) {

        ArrayList<Integer> ret = new ArrayList<>();
        if (size > nums.length || size < 1)
            return ret;

        // 大顶堆  使用优先级队列实现大顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2)->o2-o1);


        for (int i=0; i< size; i++) {
            heap.add(nums[i]);
        }
        // 将大顶堆中最大的元素弹出
        ret.add(heap.peek());
        for (int i = 0, j=i+size; j < nums.length; i++,j++) {
            heap.remove(nums[i]);
            heap.add(nums[j]);
            ret.add(heap.peek());
        }
        return ret;
    }
}

