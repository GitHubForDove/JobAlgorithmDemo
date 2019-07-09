package leetCodePractise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {


     public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static class Command {

        String s;
        TreeNode node;

        public Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }

    }

    public static void main(String[] args) {

    }


    /**
     * 使用非递归 模拟栈的方法进行前序遍历
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {


        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Stack<Command> stack = new Stack();

        stack.push(new Command("go",root));

        while (!stack.isEmpty()) {

            Command command = stack.pop();
            if (command.s == "print"){
                res.add(command.node.val);
            }else {
                if (command.node.left!=null) {
                    stack.push(new Command("go", command.node.left));
                }
                if (command.node.right!=null) {
                    stack.push(new Command("go", command.node.right));
                }
                stack.push(new Command("print",command.node));
            }
        }
        return res;
    }
}
