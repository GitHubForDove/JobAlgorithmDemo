package LeetCode;


import java.util.Scanner;

public class ByteDance2019_Question2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] str = new int[10][10];
        int count = 0;
        while (true) {
            String space = "";
            String s = sc.nextLine();
            if (s.equals(space)) {
                minTime(str);
            }
            s = s.trim().replace(" ","");
            for (int i=0; i< s.length(); i++) {
                str[count][i] = s.charAt(i)-'0';
            }
            count++;
        }

    }

    public static int minTime(int[][] str) {

        int begin = str[0][0];
        int costTime = 0;
        for (int i=0; i < str.length; i++) {

            for (int j=0; j< str[0].length ;j++) {


                if (str[i][j] == 0 || str[i][j] == 1) {
                    continue;
                }

                if (str[i][j] == 2) {

                        if (i+1 < str.length && str[i+1][j] == 1 ) {
                            str[i+1][j] = 2;
                        }

                        if (j+1 < str[0].length && str[i][j+1] == 1) {
                            str[i][j+1] = 2;
                        }
                        if (i-1>=0 && str[i-1][j] == 1) {
                            str[i-1][j] = 2;
                        }
                        if (j-1>=0 && str[i][j-1] == 1) {
                            str[i][j-1] = 2;
                        }

                        if (str[i+1][j] != 1 || str[i][j+1] != 1 || str[i-1][j] == 1 ||str[i][j-1] == 1) {
                            continue;
                        }

                        costTime++;
                }
            }
        }
        return costTime != -1 ? costTime : -1;
    }

}
