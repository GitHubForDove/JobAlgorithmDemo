package leetCodePractise;

import java.util.Arrays;
import java.util.Scanner;

public class tianjisaima {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums1 = new int[n];
            int[] nums2 = new int[n];
            for (int i=0; i <n; i++) {
                nums1[i] = sc.nextInt();
            }

            for (int i=0; i <n; i++) {
                nums2[i] = sc.nextInt();
            }

            compare(nums1, nums2);
        }
    }

    /**
     * 田忌赛马
     * @param nums1
     * @param nums2
     */
    public static void compare(int nums1[], int nums2[]) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int i=0,j=0,x = n-1, y = n-1, cnt=0;
        boolean bLast = true;
        while (bLast) {

            //是否是最后一匹马
            if(x==i)
                bLast=false;

            if (nums1[x] > nums2[y]) {
               x--;
               y--;
               cnt++;
           }else if (nums1[i]> nums2[j]) {
               i++;
               j++;
               cnt++;
           } else {

               if (nums1[i] < nums2[y]) {
                   cnt--;
               }

               i++;
               y--;
           }
        }
        System.out.println(100*cnt);
    }

}
