package TreadedTree;

public class ThreadedBinaryTree {

    ThreadedTreeNode root;

    // 临时存储前驱节点
    ThreadedTreeNode pre= null;


    // 中序线索化二叉树
    public void threadNodes() {
        threadNodes(root);
    }

    public void threadNodes(ThreadedTreeNode node) {

        // 如果当前节点为null，直接返回
        if (node == null) {
            return;
        }


        // 处理左子树
        threadNodes(node.leftNode);
        // 处理前驱节点
        if (node.leftNode == null) {
            // 将左指针指向前驱节点
            node.leftNode = pre;
            // 改变的当前节点左指针的类型
            node.leftType = 1;
        }

        // 处理前驱的有指针，如果前驱节点的右指针是null(没有指向右指针)
        if (pre!=null && pre.rightNode == null) {
            // 让前驱节点的右指针指向当前节点
            pre.rightNode = node;
            // 改变前驱节点的右指针类型
            pre.rightType = 1;
        }

        // 每处理一个节点，当前节点是下一个节点的前驱节点
        pre = node;


        // 处理右子树
        threadNodes(node.rightNode);
        if (node.rightNode == null) {
            // 将左指针指向前驱节点
            node.rightNode = pre;
            // 改变的当前节点左指针的类型
            node.rightType = 1;
        }


    }




    // 获取根节点
    public ThreadedTreeNode getRoot() {
        return root;
    }

    // 设置根节点
    public void setRoot(ThreadedTreeNode root) {
        this.root = root;
    }
}
