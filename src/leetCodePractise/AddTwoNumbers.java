package leetCodePractise;


import java.util.Stack;

public class AddTwoNumbers {



    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{5};
        int[] nums2 = new int[]{5};
        ListNode l1 = createLinkedList(nums1,nums1.length);
        ListNode l2 = createLinkedList(nums2,nums2.length);

        ListNode res = addTwoNumbers(l1,l2);
        printLinkedList(res);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();

        while (l1!=null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2!=null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int i=0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int value1 = !stack1.isEmpty()? stack1.pop() : 0;
            int value2 = !stack2.isEmpty() ? stack2.pop() : 0;
            int sum = value1 + value2 + i;
            i = sum/10;
            stack3.push(sum%10);
        }

        if (i>0) {
            stack3.push(i);
        }
        ListNode head = new ListNode(0);
        ListNode res = head;
        while (!stack3.isEmpty()) {
            head.next = new ListNode(stack3.pop());
            head = head.next;
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
