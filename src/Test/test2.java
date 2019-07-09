package Test;

import java.util.Scanner;

public class test2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            System.out.println(maxIndexSection(num1, num2));
        }

    }

    public static int maxIndex(int num) {
        if (num == 1) return 1;
        int maxIndex = (int) Math.sqrt(num);
        int i = 2;
        while (i <= num) {

            for (int j = 2; j <= maxIndex + 1; j++) {
                if (Math.pow(i, j) > num) break;
                if (Math.pow(i, j) == num) return j;
            }
            i++;
        }
        return 1;
    }


    public static int maxIndexSection(int num1, int num2) {
        if (num2 < 4)  return 1;
        int i = 2;
        int max = 2;
        while (i <= num2) {
            for (int j = 2; j <= 32; j++) {
                if (Math.pow(i, j) > num2 && Math.pow(i,j) < num1) break;
                if ( Math.pow(i, j) >= num1 && Math.pow(i,j) <= num2){
                    if (max < j) max = j;
                }
            }
            i++;
        }
        return max;
    }

}
