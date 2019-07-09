package LeetCode;


import java.util.Scanner;

/**
 * 题目描述：
 我们称一个矩阵为黑白矩阵，当且仅当对于该矩阵中每一个位置如(i,j),其上下左右四个方向的数字相等，即(i-1,j),(i+1,j),(i,j+1),(i,j-1)四个位置上的数字两两相等且均不等于(i,j)位置上的数字。(超出边界的格子忽略)

 现在给出一个n*m的矩阵，我们想通过修改其中的某些数字，使得该矩阵成为黑白矩阵，问最少修改多少个数字。

 输入
 第一行包含两个整数n,m,表示矩阵的长宽。(1≤n,m≤100000,1≤n*m≤100000)。

 接下来有n行，每行包含m个整数，中间用空格隔开，表示n*m的矩阵。

 输出
 输出仅包含一个数字，表示该矩阵想修改为黑白矩阵最少修改的数字数量。


 样例输入
 3 3
 1 1 1
 1 1 1
 1 1 1
 样例输出
 4

 提示
 补充样例
 输入样例2
 3 3
 1 1 1
 1 5 1
 1 1 1
 输出样例2
 */
public class meituan_Question1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] matrix = new int[n][m];
            for (int i=0;i<n;i++) {
                for (int j=0;j<m;j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int res = modifMatrix(matrix);
            System.out.println(res);
        }
    }


    public static int modifMatrix(int[][] matrix) {


        int n = matrix.length;
        int m = matrix[0].length;
        if (n==1 && m==1)  return 0;
        int res = 0;
        for (int i=0; i<n;i++) {
            for (int j=0;j<m;j++) {

                if (i<n-1 && j<m-1) {

                    if (i+2<=n-1 && matrix[i][j] == matrix[i+1][j]
                            &&  matrix[i][j] == matrix[i+2][j]) {
                        res += 1;
                        matrix[i+1][j] = (int)Math.random();
                        j= j+2;
                        continue;
                    }


                    if (i+1 <= n-1 && matrix[i][j] == matrix[i+1][j]
                            && j+1<=m-1 && matrix[i][j] == matrix[i][j+1]) {
                        res +=1;
                        continue;
                    }

                    if (i+1 <= n-1 && matrix[i][j] == matrix[i+1][j]){
                        res +=1;
                    }

                    if (j+1<=m-1 && matrix[i][j] == matrix[i][j+1]) {
                        res += 1;
                    }

                } else if (j==m-1 && i+1<=n-1 && matrix[i][j] == matrix[i+1][j]) {
                        res +=1;
                }

            }
        }
        return res;
    }
}
