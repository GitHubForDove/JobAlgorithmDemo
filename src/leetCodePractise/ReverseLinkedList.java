package leetCodePractise;

public class ReverseLinkedList {


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }

    /**
     * 反转链表
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = reverseList(head);
        while (res!= null) {
            System.out.println(res.val);
            res = res.next;
        }

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

        while (head!=null) {
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
        return;
    }


    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return  pre;
    }
}
