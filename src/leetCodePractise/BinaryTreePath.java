package leetCodePractise;


import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {

    public static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode(int x) {
            this.val = x;
        }
    }
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.right = new TreeNode(5);

        System.out.println(sumPath(head));

        List<String> res = binaryTreePath(head);

        for (int i=0;i<res.size();i++) {
            System.out.println(res.get(i));
        }


    }


    /**
     * 遍历所有的二叉树路径
     * @param root
     * @return
     */
    public static List<String> binaryTreePath(TreeNode root) {

        List<String> res = new ArrayList<>();

        if (root==null) return res;

        if (root.left==null && root.right==null) {
            res.add(String.valueOf(root.val));
            return res;
        }

        // 拿到当前节点后面左子树的路径
        List<String> leftS = binaryTreePath(root.left);
        for (int i=0;i<leftS.size();i++) {
            // 将已经遍历的明确的路径 加在当前路径的的后面
            res.add(String.valueOf(root.val) + "->" + leftS.get(i));
        }

        // 拿到当前节点后面右子树的路径
        List<String> rightS = binaryTreePath(root.right);
        for (int i=0;i<rightS.size();i++) {
            // 将已经遍历的明确的路径 加在当前路径的的后面
            res.add(String.valueOf(root.val) + "->" + rightS.get(i));
        }

        //  res的字符串路径 返回给上一层
        return res;
    }


    public static int sumPath(TreeNode root){
        if (root == null) return 0;

       int res = treePath(root, 0);

        return res;
    }

    public static int treePath(TreeNode root, int current) {

        if (root ==null) return 0;

        if(root.left == null && root.right == null){
            return current*10 + root.val;
        }

        int left = treePath(root.left,current*10 + root.val);
        int right = treePath(root.right,current*10 + root.val);

        return left+right;
    }
}
