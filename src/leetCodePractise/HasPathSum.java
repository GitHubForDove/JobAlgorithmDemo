package leetCodePractise;

public class HasPathSum {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    public static boolean hasPathSum(TreeNode root, int sum) {

        // 当根节点为空时
        if (root == null) return false;

        // 当根的左节点为空 右节点也为空的时候  判断root的值是否是等于sum  是的话 返回true
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        // 递归左子树  判断sum -root.val 是不是最后为0
        if (hasPathSum(root.left, sum - root.val)) {
            return true;
        }
        // 递归右子树  判断sum -root.val 是不是最后为0
        if (hasPathSum(root.right, sum - root.val)) {
            return true;
        }

        return false;

    }
}
