package SortAlgorithm;

import java.util.Arrays;

public class InsertSort {


    public static void main(String[] args) {
        int[] arr = new int[] {12,5,2,56,3,23,15,63,42};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int len = arr.length;
        for (int i=1; i < len; i++) {
            if (arr[i-1] > arr[i]) {
                int stard = arr[i];
                while (i-1>0 && arr[i-1] >= stard) {
                    arr[i] = arr[i-1];
                    i--;
                }
                arr[i-1] = stard;
            }
        }
    }
}
