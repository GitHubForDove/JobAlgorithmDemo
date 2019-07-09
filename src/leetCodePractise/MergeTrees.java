package leetCodePractise;

public class MergeTrees {

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

        //TreeNode res = mergeTrees(head);
        //System.out.println(isBalanced(head));
    }


    /**
     * 合并两个二叉树
     * @param t1
     * @param t2
     * @return
     */
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        // 如果t1为空 则返回t2
       if (t1 == null) return t2;
        // 如果t2为空 则返回t1
       if (t2 == null) return t1;

        // 合并后的数值为 t1.val + t2.val
        t1.val = t1.val + t2.val;
        // 递归循环
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);

        return t1;

    }
}
