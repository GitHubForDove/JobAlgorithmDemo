package leetCodePractise;


/**
 *
 * 86. 分隔链表

 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

 你应当保留两个分区中每个节点的初始相对位置。

 示例:

 输入: head = 1->4->3->2->5->2, x = 3
 输出: 1->2->2->4->3->5
 */
public class PartitionList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,3,2,5,2};
        ListNode head = createLinkedList(nums, nums.length);
        ListNode res= partition(head,3);
        printLinkedList(res);
    }

    /**
     * 将链表进行划分
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {

        ListNode list1 = new ListNode(0);
        ListNode list1Cur = list1;
        ListNode list2 = new ListNode(0);
        ListNode list2Cur = list2;

        while (head!=null) {
            ListNode temp = null;
            if (head.val < x) {
                temp = new ListNode(head.val);
                list1Cur.next = temp;
                list1Cur = list1Cur.next;
            }else {
                temp = new ListNode(head.val);;
                list2Cur.next = temp;
                list2Cur = list2Cur.next;
            }
            head = head.next;
        }

        list2 = list2.next;

        while (list2!=null) {
            list1Cur.next = new ListNode(list2.val);
            list2 = list2.next;
            list1Cur = list1Cur.next;
        }


        return list1.next;
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
