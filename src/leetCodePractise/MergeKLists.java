package leetCodePractise;


import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKLists {


    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
               String s = sc.next();

        }*/
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{list1, list2, list3};

        ListNode res = mergeKLists(lists);
        while (res!= null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists ) {
        // 创建一个小顶堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1,o2)->o1-o2);

        // 将链表中的所有值都放入小顶堆中
        for (int i=0; i< lists.length; i++) {
            while (lists[i] != null) {
                minHeap.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }


        ListNode pre = new ListNode(0);
        ListNode head = pre;
        int len = minHeap.size();
        // 将小顶堆的对顶元素 一个一个poll出来 并放入链表中
        for (int j=0;j< len; j++) {
            head.next = new ListNode(minHeap.poll());
            head = head.next;
        }


        return pre.next;

    }

}
