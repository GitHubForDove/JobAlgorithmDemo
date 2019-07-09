package SortAlgorithm;

import java.util.Arrays;


/**
 *  基数排序
 */
public class RadixSort {


    public static void main(String[] args) {
        int[] arr = new int[]{2, 443, 32, 234, 545, 745, 3, 523, 22, 876, 90};
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 使用二维数组 完成基数排序
     *
     * @param arr
     */
    public static void radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        // 求出最大数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 计算最大数是几位数
        int maxLength = (max + "").length();
        // 用于临时存取数据的数组
        int[][] temp = new int[10][arr.length];
        // 用于记录相应的数组中存放的数字的数量
        int[] count = new int[10];
        // 根据最大长度最大数  决定比较的次数
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // 把每个数字分别计算余数
            for (int j = 0; j < arr.length; j++) {
                //余数
                int ys = arr[j] / n % 10;
                //记录 每个位数上的值
                temp[ys][count[ys]++] = arr[j];

            }

            // 记录取的元素 需要放的位置
            int index = 0;
            // 循环取出数组中的数字
            for (int k = 0; k < count.length; k++) {
                // 当前记录的数量不为0
                if (count[k] != 0) {
                    for (int l = 0; l < count[k]; l++) {
                        arr[index] = temp[k][l];
                        index++;
                    }
                }
                count[k] = 0;
            }
        }
    }


    /**
     * 使用队列 完成基数排序
     *
     * @param arr
     */
    public static void radixSortByQueue(int[] arr) {
        int max = Integer.MIN_VALUE;
        // 求出最大数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 计算最大数是几位数
        int maxLength = (max + "").length();
        // 用于临时存取数据的数组
        int[][] temp = new int[10][arr.length];
        // 用于记录相应的数组中存放的数字的数量
        int[] count = new int[10];
        // 根据最大长度最大数  决定比较的次数
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // 把每个数字分别计算余数
            for (int j = 0; j < arr.length; j++) {
                //余数
                int ys = arr[j] / n % 10;
                //记录 每个位数上的值
                temp[ys][count[ys]++] = arr[j];

            }

            // 记录取的元素 需要放的位置
            int index = 0;
            // 循环取出数组中的数字
            for (int k = 0; k < count.length; k++) {
                // 当前记录的数量不为0
                if (count[k] != 0) {
                    for (int l = 0; l < count[k]; l++) {
                        arr[index] = temp[k][l];
                        index++;
                    }
                }
                count[k] = 0;
            }
        }

    }
}
