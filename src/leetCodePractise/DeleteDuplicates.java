package leetCodePractise;

import java.util.HashMap;
import java.util.Map;

public class DeleteDuplicates {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,3};
        ListNode head = createLinkedList(nums,nums.length);
        ListNode res = deleteDuplicates(head);
        printLinkedList(res);
    }

    public static ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }
        Map<Integer, Integer> map = new HashMap<>();
        ListNode cur = head;

        while (cur!=null) {
            if (map.containsKey(cur.val)){
                int value = map.get(cur.val);
                map.put(cur.val, value+1);
                cur = cur.next;
            }else {
                map.put(cur.val,1);
                cur = cur.next;
            }
        }

        cur = head;
        ListNode pre = new ListNode(0);
        ListNode res = pre;
        pre.next = cur;

        while (cur!=null) {

            if (map.get(cur.val) >=2) {
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
