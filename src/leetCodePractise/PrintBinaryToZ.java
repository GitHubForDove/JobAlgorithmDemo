package leetCodePractise;



import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 按之字形打印二叉树
 */
public class PrintBinaryToZ {


    public static void main(String[] args) {

    }

    /**
     * 之字形打印二叉树
     * @param pRoot
     * @return
     */
    public static ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

        // 队列可以由new LinkedList<>()方法实例得来
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(pRoot);
        // 是否需要反转
        boolean reverse = false;
        // 当队列不为空的时候 进行while循环
        while (!queue.isEmpty()) {

            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();

            while (cnt-- > 0) {
                // 将队尾的节点弹出
                TreeNode node = queue.poll();
                if (node == null) continue;

                list.add(node.value);
                // 队列头添加弹出节点的左节点 和右节点
                queue.add(node.lNode);
                queue.add(node.rNode);
            }
            // 当遍历完一层之后  如过需要进行反转  就将list进行反转
            if (reverse) {
                Collections.reverse(list);
            }
            reverse = !reverse;
            if (list.size() != 0) {
                ret.add(list);
            }
        }
        return ret;
    }
}
