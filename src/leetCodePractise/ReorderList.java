package leetCodePractise;

public class ReorderList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        ListNode head = createLinkedList(nums, nums.length);
        reorderList(head);
        printLinkedList(head);
    }

    public static void reorderList(ListNode head) {

        if (head == null || head.next == null) return;
        ListNode cur = head;
        ListNode p = cur;
        ListNode q = cur;
        ListNode pre = null;

        while (q!=null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }

        // 将中间截断
        pre.next = null;

        ListNode head2 = reverseList(p);
        cur = head;
        ListNode last = null;
        while (cur!=null) {

            ListNode temp = new ListNode(head2.val);
            head2 = head2.next;

            temp.next = cur.next;
            cur.next = temp;
            last = temp;
            cur = cur.next.next;

        }
        if (head2!=null) {
            last.next = head2;
        }


    }

    /**
     * 反转链表
     * @param head
     * @return
     */
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
