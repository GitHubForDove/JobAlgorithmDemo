package SortAlgorithm;

import java.util.Arrays;

/**
 * 快速分类的分类过程
 *  将小于标准数的 放在左边  将大于标准数的放在右边
 */
public class Patition {

    public static void main(String[] args) throws Exception {
        int[] data = new int[]{2,1,3,5,4,9,6};
        int res = partition(data,data.length,0,data.length-1);
        System.out.println(res);
    }

    public static int partition(int[] data, int length, int start, int end) throws Exception {

        if (data == null ||length <= 0 || start < 0 || end >= length) {
             throw  new Exception("参数错误");
        }

        int index = 3;
        swap(data, index, end);

        int small = start-1;
        for (index=start; index < end; ++index) {

            if (data[index] < data[end]) {
                ++small;
                if (small != index) {
                    swap(data, index, small);
                }
            }
        }

        ++small;
        swap(data, small, end);

        System.out.println(Arrays.toString(data));

        return small;
    }

    public static void swap(int[] data, int pos1, int pos2) throws Exception {
        if (data == null || data.length <= 0 || pos1 > data.length || pos2 > data.length) {
            throw  new Exception("参数错误");
        }
        int temp = data[pos1];
        data[pos1] = data[pos2];
        data[pos2] = temp;
    }
}
