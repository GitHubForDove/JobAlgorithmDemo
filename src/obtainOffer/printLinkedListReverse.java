package obtainOffer;

import DataStruct.ListNode;
import DataStruct.Stack;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 从尾打印链表
 *
 */
public class printLinkedListReverse {


    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(7);
        //printLinkedList(list);

        ListNode n = new ListNode(1);
        n.next = new ListNode(4);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(5);
        //printLinkedListRecursion(n);
        //n.insert();
    }

    /**
     * 使用栈
     * @param list
     */
    public static void printLinkedList(LinkedList<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        Iterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            stack.push(it.next());
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 递归形式
     * @param listNode
     */
    public static void printLinkedListRecursion(ListNode listNode) {
        if (listNode == null) {
            return;
        } else {
            printLinkedListRecursion(listNode.next);
        }
        System.out.println(listNode.value);
    }

}
