package Bytedance;

import java.util.Calendar;
import java.util.Scanner;

public class Question_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[][] day = new int[T][3];
        for (int i=0;i<T;i++) {
            int y = sc.nextInt();
            int m = sc.nextInt();
            int d = sc.nextInt();
            day[i][0] = y;
            day[i][1] = m;
            day[i][2] = d;
        }

        for (int i=0;i<day.length;i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(2012,3,12);
            long dateTime1 = calendar.getTimeInMillis();
            calendar.set(day[i][0],day[i][1],day[i][2]);
            long dateTime2 = calendar.getTimeInMillis();
            long days = (dateTime2-dateTime1) / (1000 * 3600 * 24);

            System.out.println(Integer.parseInt(String.valueOf(days)));
        }


    }
}
