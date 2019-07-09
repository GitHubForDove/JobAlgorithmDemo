package leetCodePractise;

public class IsBalanced {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(2);
        head.left.left = new TreeNode(3);
        head.left.right = new TreeNode(3);
        head.left.left.left = new TreeNode(4);
        head.left.left.right = new TreeNode(4);

        System.out.println(isBalanced(head));
    }

    public static boolean isBalanced(TreeNode root) {

        if (root == null)
            return true;

        // 判断左右节点的高度的差值 如果相差高度小于等于1 就继续向下遍历
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }else
            return false;
    }

    /**
     * 获取二叉树的高度
     * @param root
     * @return
     */
    public static int getDepth(TreeNode root) {
        if (root == null) return 0;

        int leftLevel = getDepth(root.left);
        int rightLevel = getDepth(root.right);

        return 1 + Math.max(leftLevel, rightLevel);
    }
}
