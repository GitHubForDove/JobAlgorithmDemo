package leetCodePractise;

public class MergeTwoLists {

    public static class ListNode {
     int val;
     ListNode next;
    ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
    }

    /**
     * 合并两个有序数组
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode list = new ListNode(0);
        ListNode temp = list;
        while (l1 !=null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }else {
                temp.next = l2;
                temp = temp.next;
                l2= l2.next;
            }
        }

        if (l1 == null) {
            temp.next = l2;
        }
        if (l2 == null) {
            temp.next = l1;
        }

        return list.next;
    }
}
