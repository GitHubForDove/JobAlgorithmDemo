package leetCodePractise;


import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {
        String s = "(()";
        //Boolean flag = isValid(s,1,s.length());
        //System.out.println(flag);
        System.out.println(longestValidParentheses(s));
    }



    public static int longestValidParentheses(String s) {
        int len = s.length();

        if (len < 2) return 0;
        Stack<Integer> stack = new Stack<>();
        int[] list = new int[len];

        for (int i=0; i<len;i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.size() == 0) {
                    continue;
                }
                list[stack.peek()] = 1;
                list[i] = 1;
                stack.pop();
            }
        }


        int cur = 0;
        int mymax = 0;
        for (int i = 0; i < len; i ++)
        {
            if (list[i] == 1)
            {
                cur ++;
            }
            else
            {
                if (cur > mymax)
                {
                    mymax = cur;
                }
                cur = 0;
            }
        }
        if (cur > mymax)
        {
            mymax = cur;
        }
        return mymax;
    }



/*
    public static int longestValidParentheses(String s) {

        int res=0;
        for (int i=0; i<s.length(); i++) {

            int j=i+1;

            while (j< s.length()) {
                if ((j -i + 1)%2 != 0){
                    j++;
                    continue;
                }
                if (!isValid(s, i,j)) {
                    j++;
                }else {
                    res = res > (j-i) ? res : j-i+1;
                    j++;
                }
            }


        }

        return res;

    }*/

    /*
    public static boolean isValid(String s,int start, int end) {

        if ((end - start+1) % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        for (int i= start; i < end+1; i++) {
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
        return false;
    }*/

}
