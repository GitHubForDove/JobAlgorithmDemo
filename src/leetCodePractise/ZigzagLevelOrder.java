package leetCodePractise;

import java.util.*;

public class ZigzagLevelOrder {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(9);
        head.right = new TreeNode(0);
        head.left.left = new TreeNode(5);
        head.left.right = new TreeNode(1);


        //System.out.println(res);

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();
        if (root== null) return lists;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);
        boolean isReverser = false;
        while (queue1.size()>0) {
            List<Integer> list = new ArrayList<>();

            while (queue1.size()>0){
                TreeNode node = queue1.poll();
                queue2.add(node);
                list.add(node.val);
            }
            while (queue2.size()>0) {
                TreeNode temp = queue2.poll();
                if (temp.left!=null) {
                    queue1.add(temp.left);
                }
                if (temp.right!=null) {
                    queue1.add(temp.right);
                }
            }

            if (isReverser) {
                Collections.reverse(list);
            }
            lists.add(list);
            isReverser = !isReverser;
        }
        return lists;
    }


}
