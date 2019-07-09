package leetCodePractise;

public class SortedArrayToBST {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        int[] nums = new int[] {-10};
        TreeNode root = sortedArrayToBST(nums);

        //System.out.println(root.val + "----" + root.left.val + " : " + root.right.val);
        System.out.println(root.val);

    }


    /**
     * 给点有序数组 还原一颗平衡二叉的排序树
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        // 左右等分建立左右子树，中间节点作为子树根节点，递归该过程
        return nums == null ? null : buildTree(nums, 0, nums.length - 1);
    }

    private static TreeNode buildTree(int[] nums, int l, int r) {

        if (l > r) {
            return null;
        }

        // 找到中间位置的树 作为根节点
        int m = l + (r - l) / 2;

        TreeNode root = new TreeNode(nums[m]);
        root.left = buildTree(nums, l, m - 1);
        root.right = buildTree(nums, m + 1, r);
        return root;
    }
}
