package leetCodePractise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PrintMatrixClock {

    public static void main(String[] args) {
        int[][] str = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

       /*(for (int i = 0; i< str.length; i++) {
            System.out.println(Arrays.toString(str[i]));
        }*/
       ArrayList<Integer> arrayList  = printMatrixClock(str, 4,4);
       System.out.println("---------- ");
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }

    // 打印数组顺时针
    public static ArrayList<Integer> printMatrixClock(int[][] str, int col, int row) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        if (str == null && row <= 0 && col <= 0) {
            return null;
        }

        int start = 0;
        // colums > startX*2并且rows> startY*2 是循环继续的条件
        while(col > start * 2 && row > start * 2) {
            printMatrixCircle(arrayList, str, col, row, start);
            ++start;
        }

        return arrayList;

    }

    // 打印数组圆圈
    public static void printMatrixCircle(ArrayList<Integer> arrayList, int[][] str, int col,
                                         int row, int start) {

        int endX = col -1 -start;
        int endY = row -1 -start;

        // 从左向右打印
        for (int i=start; i<= endX ; ++i) {
            System.out.println(str[start][i]);
            arrayList.add(str[start][i]);

        }

        //从上往下打印
        if (start < endY) {
            for (int j = start+1; j <= endY; ++j) {
                System.out.println(str[j][endX]);
                arrayList.add(str[j][endX]);
            }
        }

        // 从右向左打印
        if (start < endY && start < endX) {
            for (int j = endX-1 ; j >= start; --j) {
                System.out.println(str[endY][j]);
                arrayList.add(str[endY][j]);

            }
        }
        // 从下向上打印
        if (start < endY-1 && start < endX) {
            for (int j = endY - 1; j > start; --j) {
                System.out.println(str[j][start]);
                arrayList.add(str[j][start]);
            }
        }
    }
}
