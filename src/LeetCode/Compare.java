package LeetCode;


import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public class Compare {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            int n = sc.nextInt();
            if (n <0 || n > 1000) return ;
            int n1= n;
            int[] nums1 = new int[n];
            int[] nums2 = new int[n];
            for (int i=0; i < n; i++) {
                nums1[i] = sc.nextInt();
            }
            for (int i=0; i < n; i++) {
                nums2[i] = sc.nextInt();
            }
            compare2(nums1, nums2);
        }
    }

    public static void compare(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int max=0;
        boolean bLast = true;
        int n = nums1.length;
        int i=0,j=0,x=n-1,y=n-1,cnt=0;
        while (i<=x) {


            if (nums1[x] > nums2[y]) {
                x--;
                y--;
                cnt++;
            } else if (nums1[i] > nums2[j]) {
                    i++;
                    j++;
                    cnt++;
            } else if (nums1[i] < nums2[j]) {
                i++;
                y--;
                cnt--;
            } else {
                if (nums1[x]>nums2[j]) {
                    j++;
                    x--;
                    cnt++;
                }else if (nums1[x] < nums2[j]) {
                    j++;
                    x--;
                    cnt--;
                } else {
                    j++;
                    x--;
                }
            }


        }
        System.out.println(cnt*100);

    }

    public static void compare2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int i=0,j=0,x=n-1,y=n-1,cnt=0;
        boolean bLast = true;
        while (bLast) {
            if (i == x) {
                bLast = false;
            }

            if(nums1[x] > nums2[y]) {
                x--;
                y--;
                cnt++;
            }else if (nums1[i] > nums2[j]) {
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
        System.out.println(cnt * 100);
    }
}

