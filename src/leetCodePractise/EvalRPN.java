package leetCodePractise;


import java.util.Stack;

public class EvalRPN {


    public static void main(String[] args) {
        String[] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int res = evalRPN(tokens);
        System.out.println(res);
    }

    public static int evalRPN(String[] tokens) {

        if(tokens==null || tokens.length==0){
            return 0;
        }

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i].equals("+") || tokens[i].equals("-")
                    || tokens[i].equals("*") || tokens[i].equals("/")) {

                int value1 = Integer.valueOf(s.pop());
                int value2 = Integer.valueOf(s.pop());

                int sum ;
                if (tokens[i] == "+") {
                    sum = value2+value1;
                }else if (tokens[i] == "-") {
                    sum = value2-value1;
                }else if (tokens[i] == "*") {
                    sum = value2*value1;
                }else {
                    sum = value2 / value1;
                }
                s.push(sum);
            }else {
                s.push(Integer.parseInt(tokens[i]));
            }

        }

        return s.pop();
    }
}
