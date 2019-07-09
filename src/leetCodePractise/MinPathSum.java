package leetCodePractise;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

 说明：每次只能向下或者向右移动一步。

 示例:

 输入:
 [
 [1,3,1],
 [1,5,1],
 [4,2,1]
 ]
 输出: 7
 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class MinPathSum {


    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1},
                {1,5,1},
                {4,2,1}};
        int min = minPathSum2(grid);
        System.out.println(min);
    }

    public static int minPathSum(int[][] grid) {

        int sum = 0;
        findPath(grid, 0, 0, 0);

        return min;
    }

    static int min = Integer.MAX_VALUE;

    public static void findPath(int[][] grid, int curX, int curY, int sum) {

        if (curX==grid.length-1 && curY==grid[0].length-1) {
            sum += grid[curX][curY];
            if (min > sum) {
                min = sum;
            }
            sum=0;
            return;
        }

        if (curX == grid.length-1) {
            sum += grid[curX][curY];
            if (min>sum) {
                findPath(grid,curX,curY+1,sum);
            } else {
                return;
            }

        } else if (curY == grid[0].length-1) {
            sum += grid[curX][curY];
            if (min>sum){
                findPath(grid, curX+1,curY,sum);
            }else {
                return;
            }
        }else {
            sum += grid[curX][curY];
            if (min >sum) {
                findPath(grid, curX+1,curY,sum);
                findPath(grid, curX,curY+1,sum);
            }else {
                return;
            }

        }
    }

    /**
     * 使用动态规划的思想写
     * @param grid
     * @return
     */
    public static int minPathSum2(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {

                if (i==0 && j!=0) {
                    grid[i][j] +=  grid[i][j-1];
                }else if (i!=0 && j==0) {
                    grid[i][j] +=  grid[i-1][j];
                } else if (i!=0 && j!=0){
                    grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
                }
            }
        }
        return grid[m-1][n-1];
    }

}
