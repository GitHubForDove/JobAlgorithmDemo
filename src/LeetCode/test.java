package LeetCode;

import java.util.Scanner;

public class test {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String num = sc.nextLine();
            String[] ss = num.trim().split(",");
            ListNode head= new ListNode("");
            ListNode p = null;
            p = head;

            for (int i=0; i< ss.length; i++) {
                head.next = new ListNode(ss[i]);
                head = head.next;
            }

            System.out.println(isHasCircle(p.next));
        }

        sc.close();


    }


    public static boolean isHasCircle(ListNode list) {
        ListNode p = list;
        ListNode q = list;
        boolean hasCircle = false;
        while (p!= null && q.next != null) {

            p = p.next;
            q = q.next.next;

            if (p.val == q.val ) return true;


        }
        return false;
    }
}
