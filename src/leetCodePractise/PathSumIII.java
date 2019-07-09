package leetCodePractise;

public class PathSumIII {


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


    public static int pathSum(TreeNode root, int sum) {

        if (root == null) return 0;

        // 先找从当前节点路径上和为sum路径的条数
        int res = findPath(root, sum);

        // 然后再下一个左节点和右节点找 递归调用
        res += pathSum(root.left,sum);
        res += pathSum(root.right,sum);

        return res;
    }


    public static int findPath(TreeNode node, int sum) {

        if (node == null) return 0;

        int res=0;
        if (node.val == sum) {
            res += 1;
        }

        res += findPath(node.left, sum-node.val);
        res += findPath(node.right, sum-node.val);


        return res;
    }
}
