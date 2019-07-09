package leetCodePractise;

public class LowestCommonAncestor {


    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(5);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(9);

        TreeNode node = lowestCommonAncestor(root, root.left, root.right);
        System.out.println(node.val);
    }


    /**
     *
     * 235. 二叉搜索树的最近公共祖先
     *
     *
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

     百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

     例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     * @param root
     * @param p
     * @param q
     * @return
     */

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;

        // 如果p.val 和 q.val 都小于root.val  那么p和q的公共祖先则在root的左边
        if(p.val < root.val && q.val < root.val) {
            lowestCommonAncestor(root.left, p,q);
        }
        // 如果p.val 和 q.val 都大于root.val  那么p和q的公共祖先则在root的右边
        if (p.val > root.val && q.val > root.val) {
            lowestCommonAncestor(root.right, p,q);
        }

        // 返回公共祖先
        return root;
    }
}
