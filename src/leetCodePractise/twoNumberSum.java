package leetCodePractise;


/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class twoNumberSum {

    /**
     * 两个链表个节点数相加
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum=0;
        int i=0;
        ListNode newListNode = new ListNode(0);
        ListNode tempList = newListNode;
        while(l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            sum = x+ y + i;
            i = sum / 10;
            tempList.next = new ListNode(sum % 10);
            tempList = tempList.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if (i > 0) {
            tempList.next = new ListNode(i);
        }

        return newListNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(2);

        ListNode l2 = new ListNode(7);
        l2.next = new ListNode(7);
        l2.next.next = new ListNode(9);

        ListNode newListNode = addTwoNumbers(l1,l2);

        while (newListNode != null) {
            System.out.println(newListNode.val);
            newListNode = newListNode.next;
        }

    }
}
