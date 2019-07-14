package obtainOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 分行从上到下 打印二叉树
 */
public class PrintBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 思路： 给两个变量 一个用来记录层次  一个用来记录本层次需要打印的节点个数
     */
    public static void print(TreeNode root) {

        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int nextLevel = 0;
        int toBePrinted = 1;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            toBePrinted--;

            if (node.left != null) {
                queue.add(node.left);
                nextLevel++;
            }

            if (node.right != null) {
                queue.add(node.right);
                nextLevel++;
            }

            if (toBePrinted == 0) {
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }

    }
}
