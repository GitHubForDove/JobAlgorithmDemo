package LeetCode;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 现在有一个真人游戏跳一跳，说是在一个n行n列的方阵,每个位置都有一个可以升降且高度不同的方块，
 * 高度是已知的，当人跳上去之后可以自己控制升降，每个方块的升降速度是每1单位时间能升高1单位高度，
 * 要求玩家以最快的速度从(0,0)到达(n-1,n-1)的方块，从一个方块跳跃到另外一个方块，只能在高度相同或者从高的往低的移动，
 * 如果一个方块的高度比周围的低，那么需要等待方块高度与周围方块任意一个相同时才能移动，请计算等待的最短时间
 *
 *
 *  输入:输入n*n的高度，参数是一个二维数组输入数据包含一行，行之间用分号隔开列之前用逗号分割
    输出:返回需要等待的时间
    输入范例:输入 0,5;6,3 最终转换成 [[0,5],[6,3]]
    输出范例:5
 */
public class Dump_Alibaba {

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/


    public static void main(String[] args){
    //这里的转换已经写好，按照输入描述输入即可,main方法代码不用修改 ，
    //重点在实现dump方法
        Scanner in = new Scanner(System.in);
        String s  = in.nextLine().trim();
        String[] array = s.split(";");
        int[][] grid = new int[array.length][array[0].split(",").length];
        for(int i=0;i<array.length;i++){
            String[] l= array[i].split(",");
            for(int k=0;k<l.length;k++){
                grid[i][k] =Integer.parseInt(l[k]);
            }
        }
       //int res =dump(grid);
        getShortestWayInMap(grid);
        //System.out.println(Arrays.deepToString(grid));
    }


    public static int dump(int[][] grid) {
        int[][] timeArr = new int[grid.length][grid[0].length];

        int costTime = Integer.MAX_VALUE;

        int xPos = grid.length;
        int yPos = grid.length;
        /*int i=0;
        int j=0;
        while (i<= xPos && j <= yPos) {

            if ()
        }*/

        /*for (int i=0; i< grid.length; i++) {
            for (int j=0; j<grid.length ; j++) {

                if (i==1 && j==1) continue;

                if (grid[])
            }
        }*/


        //for (int i)
        return 0;
    }

    public static int findWay(int[][] grid, int x, int y, int costTime) {
        if (x == grid.length && y == grid.length)
        {}

        return 0;
    }

    private static void getShortestWayInMap(int[][] data) {

        int[][] time = new int[data.length][data.length];


        for (int i = 1; i < time.length; i++) {
            time[i][0] = time[i - 1][0];
            if (data[i - 1][0] < data[i][0]) {
                time[i][0] += data[i][0] - data[i - 1][0];
            }
        }
        System.out.println(Arrays.deepToString(time));

        for (int i = 0; i < time.length; i++) {
            for (int j = 1; j < time[i].length; j++) {
                time[i][j] = time[i][j - 1];
                if (data[i][j - 1] < data[i][j]) {
                    time[i][j] += data[i][j] - data[i][j - 1];
                }
            }
        }


        work(data, time);
        work(data, time);
        work(data, time);
        // for (int i = 0; i < time.length; i++) {
        // System.out.println(Arrays.toString(data[i]));
        // }
        // System.out.println("");
        // for (int i = 0; i < time.length; i++) {
        // System.out.println(Arrays.toString(time[i]));
        // }
    }


    private static void work(int[][] data, int[][] time) {


        for (int i = 1; i < time.length; i++) {
            for (int j = 0; j < time[i].length; j++) {
                int tmp = time[i - 1][j];
                if (data[i - 1][j] < data[i][j]) {
                    tmp += data[i][j] - data[i - 1][j];
                }
                if (time[i][j] > tmp) {
                    time[i][j] = tmp;
                }
            }
        }


        for (int i = 0; i < time.length; i++) {
            for (int j = 1; j < time[i].length; j++) {
                int tmp = time[i][j - 1];
                if (data[i][j - 1] < data[i][j]) {
                    tmp += data[i][j] - data[i][j - 1];
                }
                if (time[i][j] > tmp) {
                    time[i][j] = tmp;
                }
            }
        }


        for (int i = time.length - 2; i >= 0; i--) {
            for (int j = 0; j < time[i].length; j++) {
                int tmp = time[i + 1][j];
                if (data[i][j] > data[i + 1][j]) {
                    tmp += data[i][j] - data[i + 1][j];
                }
                if (time[i][j] > tmp) {
                    time[i][j] = tmp;
                }
            }
        }


        for (int i = 0; i < time.length; i++) {
            for (int j = time[i].length - 2; j >= 0; j--) {
                int tmp = time[i][j + 1];
                if (data[i][j + 1] < data[i][j]) {
                    tmp += data[i][j] - data[i][j + 1];
                }
                if (time[i][j] > tmp) {
                    time[i][j] = tmp;
                }
            }
        }


    }
}
