package leetCodePractise;

public class SortList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,1,3};
        ListNode head = createLinkedList(nums, nums.length);
        ListNode res = sortList(head);
        printLinkedList(res);
    }

    /**
     * 使用归并排序 对链表进行排序
     *
     * 主要考察3个知识点，
     * 知识点1：归并排序的整体思想
     * 知识点2：找到一个链表的中间节点的方法
     * 知识点3：合并两个已排好序的链表为一个新的有序链表
     *
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        return head == null ? null : mergeSort(head);
    }

    /**
     * 使用快慢指针将链表分为两个部分
     * 然后将左边和右边进行截断  分别左边和右边的部分进行递归 mergeSort
     * @param head
     * @return
     */
    private static ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode p = head, q = head, pre = null;
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(p);
        return merge(l, r);
    }

    /**
     * 将两个链表进行合并
     * @param l
     * @param r
     * @return
     */
    public static ListNode merge(ListNode l, ListNode r) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        while (l != null && r != null) {
            if (l.val <= r.val) {
                cur.next = l;
                cur = cur.next;
                l = l.next;
            } else {
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }
        if (l != null) {
            cur.next = l;
        }
        if (r != null) {
            cur.next = r;
        }
        return dummyHead.next;
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
