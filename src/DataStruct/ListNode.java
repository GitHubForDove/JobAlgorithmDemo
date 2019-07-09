package DataStruct;

public class ListNode {

    public Object value;
    public ListNode head;
    public ListNode current;
    public ListNode next;
    private int size;

    public ListNode(Object value) {
        this.value = value;
    }

    public void add(Object obj) {
        if (head == null) {
            head = new ListNode(obj);
            current = head;
            head.next = null;
            size = 1;
        } else {
            current.next = new ListNode(obj);
            size++;
        }
    }

    public ListNode getLastNode() {
        int temp = 1;
        while (size > temp) {
            current = current.next;
        }
        return current;
    }

    /*public void insert(ListNode listNode) {
        int temp = size;
        ListNode lastNode = getLastNode();
        current = lastNode;
        while ( true) {
            lastNode.next = lastNode;
            temp--;
        }

        current = listNode;

    }*/
}
