package leetCodePractise;


/**
 * 98. 验证二叉搜索树
 *
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

 假设一个二叉搜索树具有如下特征：

 节点的左子树只包含小于当前节点的数。
 节点的右子树只包含大于当前节点的数。
 所有左子树和右子树自身必须也是二叉搜索树。
 示例 1:

 输入:
 2
 / \
 1   3
 输出: true
 示例 2:

 输入:
 5
 / \
 1   4
 / \
 3   6
 输出: false
 解释: 输入为: [5,1,4,null,null,3,6]。
 根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class IsValidBST {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);

        boolean c = isValidBST(root);
        System.out.println(c);
    }


    /**
     * 采用递归的解法
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {

        //Long.MIN_VALUE
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root,long left,long right) {

        if(root==null) return true;

        if(root.val<=left || root.val>=right) return false;

        return isValidBST(root.left,left,root.val) && isValidBST(root.right,root.val,right);
    }


    /**
     * 使用先序遍历  判断是否是二叉搜索树
     */
    private long pre = Long.MIN_VALUE;
    private boolean valid = true;

    public boolean isValidBST2(TreeNode root) {
        inOrderTraversal(root);
        return valid;
    }

    private void inOrderTraversal(TreeNode root){
        if(valid && root != null){
            inOrderTraversal(root.left);

            if(root.val <= pre){
                valid = false;
            }
            pre = root.val;

            inOrderTraversal(root.right);
        }
    }
}
