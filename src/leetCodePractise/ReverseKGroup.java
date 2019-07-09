package leetCodePractise;

import java.util.Scanner;
import java.util.Stack;

public class ReverseKGroup {


    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }


    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            int k = sc.nextInt();


        }*/


        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);
        int k = 3;

        ListNode res = reverseKGroup2(list1, k);
        while (res!=null) {
            System.out.println(res.val);
            res = res.next;
        }
    }


    public static ListNode reverseKGroup(ListNode head, int k) {


        int size=0;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = head;
        ListNode p = pre;


        while (cur != null) {
            size++;
            cur = cur.next;
        }

        int count = size / k;
        int len = count * k;

        if (head == null ) return null;

        if (head.next == null || count == 0 || k == 1) return head;

        Stack<ListNode> stack = new Stack<>();

        int flag = 1;

        while (len >= 0) {

            if (flag % (k+1) == 0) {

                while (stack.size() > 0) {
                    ListNode temp = stack.pop();
                    temp.next = null;
                    pre.next = temp;
                    pre = pre.next;
                }
                pre.next = head;
                if (head== null) return p.next;
                flag = 1;

            } else {
                stack.add(head);
                head = head.next;
                flag ++;
                len --;
            }

        }

        return p.next;
    }

    /**
     * 递归进行反转链表
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup2(ListNode head, int k) {

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        ListNode check = head;
        int canProceed = 0;
        int count = 0;

        // 检查链表长度是否满足翻转
        while (canProceed < k && check != null) {
            check = check.next;
            canProceed++;
        }
        // 满足条件，进行翻转
        if (canProceed == k) {
            while (count < k && cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                count++;
            }

            if (next != null) {
                // head 为链表翻转后的尾节点
                head.next = reverseKGroup2(next,k);
            }

            // prev 为链表翻转后的头结点
            return prev;

        } else {
            // 不满住翻转条件，直接返回 head 即可
            return head;
        }
    }
}


