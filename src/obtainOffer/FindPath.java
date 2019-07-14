package obtainOffer;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  二叉树中和为某一个值的路径
 *
 *  题目：输入一颗二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到
 *   叶子节点所经过的节点形状成一条路径。
 */
public class FindPath {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);

        findPath(root,22);
    }



    public static void findPath(TreeNode root, int expectedSum) {
        if (root == null) return;

        List path = new ArrayList();
        int currentSum = 0;

        findPath(root, expectedSum, path, currentSum);
    }

    public static void findPath(TreeNode root, int expectedSum, List path, int currentSum) {

        currentSum += root.val;
        path.add(root.val);

        boolean isLeaf = (root.left == null) && (root.right == null);
        if (isLeaf && currentSum == expectedSum) {
            Iterator it = path.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
            System.out.println();
        }

        if (root.left != null) {
            findPath(root.left, expectedSum, new ArrayList(path), currentSum);
        }

        if (root.right != null) {
            findPath(root.right , expectedSum, new ArrayList(path), currentSum);
        }

        path.remove(path.size()-1);
    }
}
