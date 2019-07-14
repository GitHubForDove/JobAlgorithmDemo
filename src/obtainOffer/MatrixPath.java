package obtainOffer;


/**
 *
 *  回溯法
 *  设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径
 *  路径可以从矩阵中的任意一格开始，每一步可以在矩阵的上下左右移动一个格。
 *  如果一条路径经过了矩阵的某一格，那么该路径不可以再次进入该格子。
 */
public class MatrixPath {

    public static void main(String[] args) {
        boolean[] visited = new boolean[4 * 4];
        char[] matrix = new char[]{'a','b','t','g','c','f','c','s','j','d','e','h'};
        int rows = 3;
        int cols = 4;
        char[] str = new char[]{'b','f','c','e'};
        boolean hasPath = hasPath(matrix, rows,cols, str);
        System.out.println(hasPath);

        System.out.println();
    }

    /**
     * 找出路径
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        boolean[] visited = new boolean[rows * cols];
        int pathLength = 0;
        for (int row=0; row< rows; row++) {
            for (int col=0; col<cols; col++) {
                if (hasPathCore(matrix, rows,cols,row,col,str, pathLength, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 找到路径
     * @param matrix
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param str
     * @param pathLength
     * @param visited
     * @return
     */
    private static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col,
                                char[] str, int pathLength, boolean[] visited) {

        if (pathLength == str.length) return true;

        boolean hasPath = false;

        if (row >=0 && row< rows && col>= 0 && col<cols &&
                matrix[row * cols + col] == str[pathLength] &&
                !visited[row* cols + col]) {
            // 路径加一
            ++pathLength;
            // 路径设为true
            visited[row*cols + col] = true;
            hasPath = hasPathCore(matrix, rows,cols, row+1,col,str,pathLength, visited)||
                    hasPathCore(matrix, rows,cols, row-1,col,str,pathLength, visited) ||
                    hasPathCore(matrix, rows,cols, row,col+1,str,pathLength, visited)||
                    hasPathCore(matrix, rows,cols, row,col-1,str,pathLength, visited);

            // 如果不是要找的路径 就返回 并visited[row * cols + col] 设置为false  表示为当前路径不对
            if (!hasPath) {
                --pathLength;
                visited[row * cols + col] = false;
            }
        }

        return hasPath;
    }


}
