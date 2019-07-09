package leetCodePractise;


/**
 *
 * 203. 移除链表元素
 *
 * 删除链表中等于给定值 val 的所有节点。

 示例:

 输入: 1->2->6->3->4->5->6, val = 6
 输出: 1->2->3->4->5
 */
public class RemoveElements {


    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,6,3,4,5,6};
        ListNode head = createLinkedList(nums,nums.length);
        ListNode res = removeElements(head, 1);
        printLinkedList(res);
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        pre.next = head;
        ListNode res = pre;
        ListNode cur = head;

        while (cur!=null) {

            if (cur.val == val) {
                pre.next = cur.next;
                cur = pre.next;
            }else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return res.next;
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
