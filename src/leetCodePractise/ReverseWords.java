package leetCodePractise;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

 示例 1:

 输入: "Let's take LeetCode contest"
 输出: "s'teL ekat edoCteeL tsetnoc"
 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class ReverseWords {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System .out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        if (s.length() == 0) return s;
        ArrayList list = new ArrayList();
        String temp = "";
        Stack stack = new Stack();
        for (int i=0; i<s.length(); i++) {

            if (s.charAt(i) == ' ') {

                while (stack.size() >0) {
                    temp = temp + stack.pop();
                }
                temp = temp + ' ';
                list.add(temp);
                temp = "";
                continue;
            }
            stack.push(s.charAt(i));

        }
        while (stack.size()>0) {
            temp = temp + stack.pop();
        }
        list.add(temp);

        String res = "";
       for (int i=0; i<list.size(); i++) {
           res += list.get(i);
       }
        return res;
    }


}
