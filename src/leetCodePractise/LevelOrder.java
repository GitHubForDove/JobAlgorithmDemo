package leetCodePractise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> lists = levelOrder(root);

        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    /**
     * 使用队列完成层次遍历
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();
        if (root== null) return lists;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);

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

            lists.add(list);
        }
        return lists;
    }
}
