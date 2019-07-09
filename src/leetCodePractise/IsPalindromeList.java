package leetCodePractise;

public class IsPalindromeList {


    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        ListNode head = createLinkedList(nums,nums.length);
        boolean res = isPalindrome(head);
        System.out.println(res);
    }

    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;
        ListNode cur = head;
        ListNode p = cur;
        ListNode q = cur;
        ListNode pre = null;
        while (q!=null && q.next!=null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }

        pre.next = null;
        ListNode list2 = reverseList(p);
        cur = head;
        while (cur!=null && list2!=null) {

            if (cur.val != list2.val) return false;
            cur = cur.next;
            list2 = list2.next;
        }
       return true;

    }

    public static ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;

        while (next != null) {

            cur.next = pre;
            pre = cur;
            cur = next;

            next = next.next;
        }
        cur.next = pre;

        return cur;


    }

    /**
     * 创建链表
     * @param arr
     * @param n
     * @return
     */
    public static ListNode createLinkedList(int[] arr, int n) {
        ListNode head = new ListNode(arr[0]);
        ListNode curNode = head;

        for (int i=1;i<n;i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
        return head;
    }

    /**
     * 打印链表
     * @param head
     */
    public static void printLinkedList(ListNode head) {

        ListNode curNode = head;
        if (curNode == null) return;

        while (curNode!=null) {
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
        return;
    }
}
