package LeetCode;


import java.util.*;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

 例如，给出 n = 3，生成结果为：

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class GenerateParenthesis {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            List<String> list = generateParenthesis(n);
            Iterator it = list.listIterator();
            while (it.hasNext()) {
                System.out.println(it.next());

            }
        }
    }

    // 暴力法破解
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        
        //
        generationAll(new char[2 * n], 0, list);

        return list;
    }

    public static void generationAll(char[] chars, int pos, List<String> list) {

        if (pos == chars.length) {
            if (isValid(chars) ) {
                list.add(new String(chars));
            }
        }else {
            chars[pos] = '(';
            generationAll(chars, pos+1, list);
            chars[pos] = ')';
            generationAll(chars, pos+1, list);
        }

    }

    // 判断字符串是否是正确的括号对   模仿栈操作
    public static boolean isValid(char[] current) {
        int balance = 0;
        for (char c : current) {

            if (c == '(') balance ++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }

    
}
