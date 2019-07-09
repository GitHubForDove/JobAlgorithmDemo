package LeetCode;


import java.util.LinkedList;
import java.util.Scanner;

public class yuesefuRing {


    public static void main(String[]args){
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        int m = sn.nextInt();
        josephRingMethod(n,m);
    }


    private static int josephRingMethod(int n, int m){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i=1; i <= n;i++) {
            linkedList.add(i);
        }
        int index = m - 1;
        while(linkedList.size()!=1){
        index %= linkedList.size();
        //出列
        System.out.print(linkedList.get(index)+" ");
        linkedList.remove(index);
        if(linkedList.size()==1){
        System.out.println();
        System.out.println(linkedList.get(0));
        }
        //新的索引就要从出列的人重新开始数，再次数到m-1。
        index+=m-1;
        }

        return-1;
        }
}
