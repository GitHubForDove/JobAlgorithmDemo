package leetCodePractise;

import java.util.Scanner;

public class Func {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long n = sc.nextInt();
            long res = func(n);
            if (res == -1){
                System.out.println("输入错误！");
            }else {
                System.out.println(res);
            }
        }
    }

    public static long func(long n) {
        if (n < 0) return -1;
        if (n == 0|| n==1) {
            return  1;
        }
        return n*func(n-1);
    }
}
