package SortAlgorithm;


import java.util.Arrays;

/**
 *  归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[] {3,2,6,1,46,3,43,5,1};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序
     * @param arr
     * @param low
     * @param high
     */
    public static void mergeSort(int[] arr, int low, int high) {
        int middle = (high+low)/2;
        if (low < high) {
            // 处理左边
            mergeSort(arr, low, middle);
            // 处理右边
            mergeSort(arr, middle + 1, high);
            // 排序
            merge(arr, low, middle, high);
        }
    }

    // 排序
    public static void merge(int[] arr, int low, int middle, int high) {
        // 用于存储归并后的临时数组
        int[] temp = new int[high - low + 1];
        //记录第一个数组中需要遍历的下标
        int i = low;
        int j = middle + 1;
        // 用于存放临时数组中的下标
        int index = 0;


        // 遍历两个数组取出小的数字，放入临时数组中
        while (i <= middle && j <= high) {

            if (arr[i] < arr[j]) {
                temp[index++] = arr[i];
                i++;
            }else {
                temp[index++] = arr[j];
                j++;
            }
        }

        while (i <= middle) {
            temp[index++] = arr[i];
            i++;
        }

        while (j <= high) {
            temp[index++] = arr[j];
            j++;
        }


        // 把临时数组重新赋值给arr数组
        for (int k=0; k < temp.length; k++) {
            arr[k+low] = temp[k];
        }





    }

}
