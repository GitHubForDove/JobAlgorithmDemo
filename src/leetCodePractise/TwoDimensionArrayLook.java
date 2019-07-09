package leetCodePractise;

/**
 * 求解 二维数组中的是否含有某个数字
 *  数字特性为 行 依次增大 列 依次增大
 */
public class TwoDimensionArrayLook {

    public static void main(String[] args) {
        int[][] str = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(numFind(str, 4,4,7));
    }

    public static boolean numFind(int[][] str, int rows, int cols, int num) {

        int row = 0;
        int col = cols-1;

        while (row < rows && col < cols) {

            if (str[row][col] > num) {
                col --;
            } else if (str[row][col] < num){
                row ++;
            }else {
                System.out.println(str[row][col]);
                return true;
            }

        }


        return false;
    }
}
