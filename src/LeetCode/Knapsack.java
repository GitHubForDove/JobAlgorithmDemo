package LeetCode;


public class Knapsack {

    public static void main(String[] args) {
        int totalWeight=20;
        int[] weight = new int[]{0,2,3,4,5,9};
        int[] value = new int[]{0,3,4,5,8,10};
        int max = knapsack(weight, value, totalWeight);
        System.out.println(max);
    }


    /**
     *
     * @param weight 物品重量
     * @param value 物品价值
     * @return
     */
    public static int knapsack(int[] weight, int[] value,int totalWeight) {
        // 前k个物品
        int k = weight.length;
        // 还有多少空间
        int w = totalWeight;

        int[][] B = new int[k][w+1];

        for (int i=1; i< k; i++) {
            for (int c=1; c < w+1; c++) {
                if (weight[i] > c) {
                    B[i][c] = B[i-1][c];
                } else {
                    B[i][c] = Math.max(B[i][c-weight[i]] + value[i], B[i-1][c]);
                }
            }
        }
        return B[k-1][w];
    }
}
