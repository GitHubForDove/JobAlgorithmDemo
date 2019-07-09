package leetCodePractise;

public class DeleteNode {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
     }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,1,9};
        ListNode head = createLinkedList(nums, nums.length);
        ListNode cur = head;
        while (cur!=null) {

            if (cur.val == 1) {
                break;
            }
            cur = cur.next;
        }
        deleteNode(cur);
        printLinkedList(head);
    }

    /**
     * 删除节点  通过将前一个节点的值 赋值给要删除的节点 然后将删除的节点连接到当前就节点的下下个节点
     * @param node
     */
    public static void deleteNode(ListNode node) {

       if (node.next == null){
           node= null;
       }

       node.val = node.next.val;
       node.next = node.next.next;
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
