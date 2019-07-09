package leetCodePractise;

public class SumOfLeftLeaves {


    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }


    public static void main(String[] args) {

    }

    /**
     *
     * 左叶子之和
     *
     * 计算给定二叉树的所有左叶子之和。

     示例：

     3
     / \
     9  20
     /  \
     15   7

     在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root ==null) {
            return 0;
        }
        return leftSum(root, false);
    }

    public int leftSum(TreeNode root, boolean isLeft) {
        if(root ==null) {
            return 0;
        }
        if(isLeft && root.left==null && root.right==null) {
            return root.val;
        }
        return leftSum(root.left, true) + leftSum(root.right,false);
    }
}
