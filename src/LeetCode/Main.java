package LeetCode;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int GetResult(String s) {
        int len =s.length();
        if(s == null && s.length() <0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        Map map = new HashMap();
        String str = "";
        int sum=0;
        for (int i=0; i < s.length(); i++) {
            if (!map.containsValue(s.charAt(i))) {
                map.put(i,s.charAt(i));
                sum++;
            }

        }

        return sum;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _s;
        try {
            _s = in.nextLine();
        } catch (Exception e) {
            _s = null;
        }

        res = GetResult(_s);
        System.out.println(res);
    }
}
