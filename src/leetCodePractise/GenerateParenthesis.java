package leetCodePractise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        int n = 3;
        List<String> list = generateParenthesis(3);
        Iterator<String> it = list.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }


    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String s = "";


        return list;

    }


    public static boolean isValid(String s) {

        int len = s.length();
        if (len % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        for (int i=0; i < len; i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
            }else if (isMatch(stack.peek(), s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        if (stack.empty()) {
            return true;
        }
        return false;
    }

    public static boolean isMatch(char c1, char c2) {

        if (c1 == '(' && c2 == ')') return true;
        if (c1 == '{' && c2 == '}') return true;
        if (c1 == '[' && c2 == ']') return true;

        return false;
    }
}
