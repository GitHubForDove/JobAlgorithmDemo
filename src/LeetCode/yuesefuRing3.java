package LeetCode;

import java.util.Scanner;

public class yuesefuRing3 {
    public static void  main (String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] r=Solution(n,m);
        for (int i=0;i<n-1;i++){
            System.out.print(r[i]+" ");
        }
        System.out.println();
        System.out.print(r[n-1]);

    }



    private static int[] Solution(int n, int m) {
        // TODO Auto-generated method stub
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=1;
        }
        int [] result=new int[n];
        int c=0;
        int sum;
        int j=0;
        for(int i=0;i<n;i++){
            sum=0;
            while(sum!=m){
                sum+=arr[j];
                c=j;
                if(j<n-1)
                    j++;
                else
                    j=0;
            }
            //System.out.println(sum+"  "+c);
            result[i]=c+1;
            arr[c]=0;
        }
        return result;

    }
}