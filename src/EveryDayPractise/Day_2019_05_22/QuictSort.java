package EveryDayPractise.Day_2019_05_22;


import java.util.Arrays;

// 快速排序
// 没能在很短的时间内写完 还需要每天进行重写
public class QuictSort {


    public static void main(String[] args) {
        int[] arr = new int[]{2,5,61,2,4,1,7,8,4};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    // 快速排序
    public static void quickSort(int[] arr, int start, int end) {

        if (start < end) {

            int stard = arr[start];
            int low = start;
            int high = end;

            while (low < high) {

                while (low < high && arr[high] >= stard) {
                    high--;
                }

                arr[low] = arr[high];

                while (low < high && arr[low] <= stard) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = stard;

            quickSort(arr, start, low);
            quickSort(arr, low+1, end);
        }

    }

    // 另一种排序实现方式
    public static void quickSort2(int[] arr, int start, int end) {
        //int l=0,r=arr.length-1;
        if (start<end) {

            int low = partition(arr, start, end);

            quickSort2(arr,start, low);
            quickSort2(arr,low+1, end);
        }

    }

    // 将排序的部分分离出来
    public static int partition(int[] arr, int start, int end) {

        int stard = arr[start];
        int low = start;
        int high = end;

        while (low < high) {

            while (low < high && stard <= arr[high]) {
                high --;
            }

            arr[low] = arr[high];

            while (low < high && stard >= arr[low]) {
                low ++;
            }
            arr[high] = arr[low];
        }
        arr[low] = stard;

        return low;
    }




}
