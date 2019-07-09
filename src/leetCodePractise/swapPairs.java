package leetCodePractise;


/**
 * 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class swapPairs {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);

        ListNode res = swapPairs(list1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }


    // 交换节点
    public static ListNode swapPairs(ListNode head) {
        // 限界判断 当head 为null 时 返回 null
        if (head == null) return null;
        // 当head.next 为空时  返回head节点
        if(head.next == null) return head;

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode p = pre;
        ListNode after = head.next;

        while (head != null && after!=null) {

            head.next = after.next;
            after.next = head;
            pre.next = after;
            pre = pre.next.next;


            ListNode temp = after;
            after = head;
            head = temp;

            if (head.next == null || after.next == null || after.next.next == null) {
               break;
            } else {
                head = head.next.next;
                after = after.next.next;
            }
        }

        return p.next;
    }
}
