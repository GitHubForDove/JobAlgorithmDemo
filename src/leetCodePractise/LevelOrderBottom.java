package leetCodePractise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }


    /**
     * 使用递归的思想 完成双
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrderBottom(root, 0, list);
        return list;
    }

    private void levelOrderBottom(TreeNode root, int level, List<List<Integer>> list) {
        if(root == null)
            return;
        if(list.size() <= level)
            list.add(0, new ArrayList<>());
        list.get(list.size() - level - 1).add(root.val);
        levelOrderBottom(root.left, level + 1, list);
        levelOrderBottom(root.right, level + 1, list);
    }


    /**
     * 用双队列

     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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

            lists.add(0,list);
        }
        return lists;
    }
}
