package SortAlgorithm;

import java.util.Arrays;

public class SelectSort {


    public static void main(String[] args) {
        int[] arr = new int[] {2,5,3,8,5,4,7,8};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void selectSort(int[] arr) {

        // 遍历所有的数
        for (int i=0; i < arr.length; i++) {
            int minIndex = i;
            // 后面的所有数进行遍历直到结束，并记录下最小的数的下标
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 如果当前最小的数和当前遍历数的下表不一致,说明下标为minIndex的数比当前遍历的数要更小
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
