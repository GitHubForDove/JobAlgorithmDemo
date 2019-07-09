package Test;

import DataStruct.ListNode;

import java.util.List;

public class test4 {


    public static void main(String[] args) {

    }


    /**
     * 反转链表
     *
     */
    public static ListNode ReverseList(ListNode pHead) {

        ListNode pReverseHead = null;
        ListNode pNode = pHead;
        ListNode pPrev = null;

        while (pNode != null) {
            ListNode pNext = pNode.next;

            if (pNext == null) pReverseHead = pNode;

            pNode.next = pPrev;

            pPrev = pNode;
            pNode = pNext;
        }
        return pReverseHead;
    }

    /**
     * 合并已经排好序的链表
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static ListNode mergeList(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null) return pHead2;
        else if (pHead2 == null) return pHead1;

        ListNode mergeListHead = null;

        if ((Integer)pHead1.value > (Integer)pHead2.value) {
            mergeListHead = pHead2;
            mergeListHead.next = mergeList(pHead1, pHead2.next);
        }else {
            mergeListHead = pHead1;
            mergeListHead.next = mergeList(pHead1.next, pHead2);
        }

        return mergeListHead;
    }
}
