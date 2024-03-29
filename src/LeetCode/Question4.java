package LeetCode;


/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class Question4 {


    public static void main(String[] args) {
        int[] height = new int[]{8,8};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        /*int len = height.length;
        int max = 0;
        int min_num=0;
        for (int i=0; i< len -1; i++) {
            for (int j=i+1; j < len; j++) {
                int area = (j - i) * Math.min(height[i],height[j]);
                if (max < area) {
                    max = area;
                }
            }

        }
        return max;
        */


        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
