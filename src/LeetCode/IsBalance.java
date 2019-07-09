package LeetCode;

import Tree.TreeNode;

public class IsBalance {


    private static boolean isBalanced = false;

    public static void main(String[] args) {

    }

    /**
     * 树是否平衡
     * @param pRoot
     * @return
     */
    public static int height(TreeNode pRoot) {

        if (pRoot == null) return 0;

        int left = height(pRoot.lNode);
        int right = height(pRoot.rNode);

        if (Math.abs(left-right) > 1)
            isBalanced = false;

        return 1 + Math.max(left, right);
    }
}
