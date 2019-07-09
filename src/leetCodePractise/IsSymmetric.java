package leetCodePractise;


/**
 * 给定一个二叉树，检查它是否是镜像对称的。

 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

 1
 / \
 2   2
 / \ / \
 3  4 4  3

 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

 1
 / \
 2   2
 \   \
 3    3
 */
public class IsSymmetric {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    public static boolean isMirror(TreeNode root1,TreeNode root2) {

        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;

        //如果是第一个根节点，直接比较左右子树，避免重复比较
        if(root1 == root2) return isMirror(root1.left,root1.right);

        return isMirror(root1.left,root2.right)&&
                isMirror(root1.right,root2.left);
    }

    /**
     * 使用迭代的方式进行+
     * @param root
     * @return
     */
    public static boolean isSymmetric2(TreeNode root) {
        return isMirror(root,root);
    }


}
