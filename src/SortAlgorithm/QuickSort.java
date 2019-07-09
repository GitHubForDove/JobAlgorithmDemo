package SortAlgorithm;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[] {12,5,2,56,3,23,15,63,42};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }


    public static void quickSort(int[] arr, int start, int end) {

        if (start < end ) {
            // 数组中0的位置表示为标准数
            int stard = arr[start];
            int low  = start;
            // 记录需要排序的下标
            int high = end;
            while (low < high) {

                // 如果标准数比右边的数要小 则将右边的数向后移动
                while (low < high && stard <= arr[high]) {
                    high--;
                }

                arr[low] = arr[high];

                while (low < high && arr[low] <= stard ) {
                    low++;
                }
                arr[high] =  arr[low];
            }
            arr[low] = stard;
            quickSort(arr, start, low);
            quickSort(arr, low+1, end);

        }
    }



}
