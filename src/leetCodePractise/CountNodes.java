package leetCodePractise;


/**
 *
 * 完全二叉树的节点个数
 *
 * 给出一个完全二叉树，求出该树的节点个数。

 说明：

 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。

 示例:

 输入:
 1
 / \
 2   3
 / \  /
 4  5 6

 输出: 6
 */
public class CountNodes {


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
        //head.right = new TreeNode(3);
       // head.left.left = new TreeNode(4);
       // head.left.right = new TreeNode(5);
       // head.right.left = new TreeNode(6);

        int res = countNodes(head);
        System.out.println(res);
    }


    /**
     * 完全二叉树的节点个数
     * @param root
     * @return
     */
    public static int countNodes(TreeNode root) {

        if (root == null) return 0;

        /*

        int h = 1;
        while (cur.right != null) {
            cur = cur.right;
            h++;
        }

        counts = (int) Math.pow(2,h)-1;


        if (cur.left != null) {
            counts = counts+1;
        }


        int tempHight = h;

        while (tempHight-->1) {
            root = root.left;
        }

        if (root.left != null) {
            counts = counts+1;
        }
        if (root.right!=null) {
            counts = counts+1;
        }*/

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
