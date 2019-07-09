package leetCodePractise;

public class MinDepth {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        int res = minDepth(root);
        System.out.println(res);
    }

     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public static int minDepth(TreeNode root) {

        if(root == null) return 0;

        if(root!=null && root.left == null && root.right==null) return 1;

        int rightLevel = minDepth(root.right);
        int leftLevel = minDepth(root.left);

        if(rightLevel == 0) return leftLevel+1;
        if(leftLevel == 0) return rightLevel+1;

        return Math.min(rightLevel,leftLevel)+1;
    }
}
