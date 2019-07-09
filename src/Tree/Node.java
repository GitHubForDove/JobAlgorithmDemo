package Tree;


import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public class Node {

    int val;
    Node left;
    Node right;
    Node(int val) {
        this.val = val;
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }

        // 判断当前节点的值比d当前子树的根节点的值大还是小
        if (node.val < this.val) {
            // 如果左节点为空
            if (this.left == null) {
                this.left = node;
                // 如果不为空
            }  else {
                this.left.add(node);
            }

        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

    }

    public void frontShow(Node node) {
        
        if (node != null) {
            node.left.frontShow(node);
            System.out.println(node.val);
            node.right.frontShow(node);
        }
    }
}
