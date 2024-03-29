package leetCodePractise;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * 求根到叶子节点数字之和
 *
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

 例如，从根到叶子节点路径 1->2->3 代表数字 123。

 计算从根到叶子节点生成的所有数字之和。

 说明: 叶子节点是指没有子节点的节点。

 示例 1:

 输入: [1,2,3]
 1
 / \
 2   3
 输出: 25
 解释:
 从根到叶子节点路径 1->2 代表数字 12.
 从根到叶子节点路径 1->3 代表数字 13.
 因此，数字总和 = 12 + 13 = 25.
 示例 2:

 输入: [4,9,0,5,1]
 4
 / \
 9   0
 / \
 5   1
 输出: 1026
 解释:
 从根到叶子节点路径 4->9->5 代表数字 495.
 从根到叶子节点路径 4->9->1 代表数字 491.
 从根到叶子节点路径 4->0 代表数字 40.
 因此，数字总和 = 495 + 491 + 40 = 1026.
 */
public class SumNumbers {


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

        int res = sumNumbers(head);
        System.out.println(res);

    }


    public static int sumNumbers(TreeNode root) {

        if (root == null) return 0;

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> list = new ArrayList<>();


        dfs(root, res, list);

        int sum = 0;

        Iterator it = res.listIterator();

        while (it.hasNext()) {
            List<Integer> temp = (List<Integer>) it.next();
            int num = 0;
            for (int i=0;i< temp.size();i++) {
               num = num*10+temp.get(i);
            }
            sum += num;
        }

        return sum;
    }

    public static void dfs(TreeNode root, List<List<Integer>> lists, List<Integer> list) {

        if (root == null) return;

        if (root.left == null && root.right ==null) {
            lists.add(list);
        }
        list.add(root.val);

        dfs(root.left, lists, new ArrayList<>(list));
        dfs(root.right, lists, new ArrayList<>(list));
    }
}
