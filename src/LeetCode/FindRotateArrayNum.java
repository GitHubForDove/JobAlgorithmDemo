package LeetCode;

import Tree.TreeNode;
import com.sun.deploy.net.HttpRequest;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

import static java.lang.Math.max;

/**
 * 题目：把一个数组最开始的若干元素半岛数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如：数组{3，4，5，1，2}为{1，2，3，4，5}的一个旋转，该数组的最小值为1.
 */
public class FindRotateArrayNum {


    public static void main(String[] args) throws ScriptException {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("javascript");
            System.out.println(engine.eval(str));
        }

    }

    /**
     *  求字符串  四则运算
     * @param str
     * @return
     */
    public static int result(String str) {

        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("javascript");
            return (Integer) engine.eval(str);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 求树的最长路径大小
     * @param root
     * @return
     */
   public static long maxDepth(TreeNode root) {
        if (root!=null) return 0;
            long leftDepth = maxDepth(root.lNode) + 1;
            long rightDepth = maxDepth(root.rNode) + 1;
            return Math.max(leftDepth, rightDepth);
        }

}
