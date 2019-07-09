package leetCodePractise;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？



 网格中的障碍物和空位置分别用 1 和 0 来表示。

 说明：m 和 n 的值均不超过 100。

 示例 1:

 输入:
 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 输出: 2
 解释:
 3x3 网格的正中间有一个障碍物。
 从左上角到右下角一共有 2 条不同的路径：
 1. 向右 -> 向右 -> 向下 -> 向下
 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{
                {0,1},{1,0}};
        int res = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(res);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] ==1) return 0;

        int[][] map = new int[obstacleGrid.length][obstacleGrid[0].length];

        /*for (int i=0;i<obstacleGrid.length; i++) {
            map[i][0] = 1;
        }

        for (int j=0;j<obstacleGrid[0].length; j++) {
            map[0][j] = 1;
        }*/

        for (int m=0;m< obstacleGrid.length; m++) {
            for (int n=0;n<obstacleGrid[0].length;n++) {
                // 如果有阻碍物  就直接跳过了  后面的都是为0 所以相加起来 最后的结果也为0
                if (obstacleGrid[m][n] == 0) {
                    if (m ==0 && n==0) {
                        map[m][n] = 1;
                    } else if (m==0) {
                        map[m][n] = map[m][n-1];
                    }else if (n==0) {
                        map[m][n] = map[m-1][n];
                    }else {
                        map[m][n] = map[m-1][n] + map[m][n-1];
                    }
                    /*if (obstacleGrid[m-1][n] == 1) {
                        map[m][n] = map[m][n-1];
                    }else if (obstacleGrid[m][n-1] == 1) {
                        map[m][n] = map[m-1][n];
                    } else {
                        map[m][n] = map[m-1][n] + map[m][n-1];
                    }*/

                }

            }
        }
        return map[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
