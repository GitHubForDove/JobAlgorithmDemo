package leetCodePractise;


import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class IsValid {

    public static void main(String[] args) {
        String s = "(]";
        System.out.println(isValid(s));
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
