package leetCodePractise;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * 路径总和 II
 *
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

 说明: 叶子节点是指没有子节点的节点。

 示例:
 给定如下二叉树，以及目标和 sum = 22，

 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 返回:

 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
public class PathSum {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 求路径和为sum的路径
     * @param node
     * @param sum
     * @return
     */
    public static List<List<Integer>> pathSum(TreeNode node, int sum) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list =new ArrayList<>();

        if (node == null) return res;

        dfs(node, res, list,sum);

        return res;

    }


    /**
     * 层次遍历
     */
    public static void dfs(TreeNode root, List<List<Integer>> res,  List<Integer> list , int value) {

        if (root == null) {
            return;
        }

        list.add(root.val);
        if (root.left == null && root.right == null && value == root.val) {
            res.add(new ArrayList(list)); // 第一个要 注意的点，这里应该添加此时此刻列表的快照，不能直接添加，因为后面还会更改这个列表
            // return; 第三个注意的点，不能直接返回，即使找到了符合条件的列表，也需要接着执行，在后面删除当前添加的最后一个节点然后返回给上层
        }

        dfs(root.left,  res,list,value - root.val);
        dfs(root.right,  res,list,value - root.val);

        // 第二个要注意的点，此时底层遍历完后，应当删除这一层遍历中添加的元素（恢复list的原貌），再返回给上层进行其他子树的遍历
        list.remove(list.size() - 1);
    }


    /**
     * 使用递归 求解
     *
     * @param root
     * @return
     */
    public int sumNumbers2(TreeNode root) {
        if(root == null) return 0;
        return helper(root,0);
    }

    int helper(TreeNode root,int current){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return current*10 + root.val;
        }

        int left = helper(root.left,current*10 + root.val);
        int right = helper(root.right,current*10 + root.val);

        return left+right;
    }

}
