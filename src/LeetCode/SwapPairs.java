package LeetCode;


/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 示例:

 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs {

   /* public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        p.next = new ListNode(2);
        p.next.next = new ListNode(3);
        p.next.next.next = new ListNode(4);
        ListNode listNode = swapPairs(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //一共三个节点:head, next, swapPairs(next.next)
        //下面的任务便是交换这3个节点中的前两个节点
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        //根据第二步：返回给上一级的是当前已经完成交换后，即处理好了的链表部分
        return next;
    }*/
}
