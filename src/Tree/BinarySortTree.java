package Tree;

public class BinarySortTree {

    Node root;

    public void add(Node node) {
        // 如果树为空
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }


    /**
     * 中序遍历二叉排序树
     */
    public void frontShow() {
        if (root!= null) {
            root.frontShow(root);
        }
    }

}
