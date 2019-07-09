package leetCodePractise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class InorderTraversal {


     public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    public  static class Command {
        String s;
        TreeNode node;

        public Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }

    }


    /**
     * 中序遍历 使用非递归的方法  使用模拟stack栈的操作
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
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
                stack.push(new Command("print",command.node));

                if (command.node.right!=null) {
                    stack.push(new Command("go", command.node.right));
                }
            }
        }
        return res;
    }


    /**
     * 中序遍历 使用非递归的方法  使用模拟stack栈的操作
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){// 将节点的左节点全部都遍历到底
                stack.push(root);
                root = root.left;
            }
            root = stack.pop(); // 将最后一个节点弹出
            list.add(root.val);
            root = root.right;  // 转到左节点
        }
        return list;
    }
}
