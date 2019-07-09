package LeetCode;


import java.util.Scanner;

public class test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String num = sc.nextLine();
            String[] ss = num.trim().split(",");
            ListNode head= new ListNode("");
            ListNode p = null;
            p = head;

            for (int i=0; i< ss.length; i++) {
                head.next = new ListNode(ss[i]);
                head = head.next;
            }

            int k = sc.nextInt();
            ListNode list = reverseList(p.next,k);

            while (list != null) {
                System.out.println(list.val);
                list = list.next;
            }

        }
    }


    public static ListNode reverseList(ListNode head, int k){

        if(head == null)
            return head;
        ListNode cur = head;
        ListNode pre = null;
        int count = 0;
        if(getLength(cur) >= k){
            while(count < k && cur != null){
                ListNode temp = cur;
                temp.next = pre;
                pre = temp;
                cur = cur.next;
                count++;
            }
            if(cur != null)
                head.next = reverseList(cur, k);
            return pre;
        }
        return cur;
    }

    public static int getLength(ListNode head){
        ListNode node = head;
        int count = 0;
        while(node != null){
            count++;
            node = node.next;
        }
        return count;
    }


}
