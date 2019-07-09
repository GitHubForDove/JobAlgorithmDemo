package TreadedTree;


public class ThreadedTreeNode {

    // 节点的权
    int value;

    // 左儿子
    ThreadedTreeNode leftNode;

    //右儿子
    ThreadedTreeNode rightNode;

    ThreadedTreeNode pre=null;

    // 表示指针类型  0 表示没有前驱节点  1 表示有前驱节点
    int leftType;
    int rightType;

    public  ThreadedTreeNode(int value) {
        this.value = value;
    }

    public void setLeftNode(ThreadedTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(ThreadedTreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
