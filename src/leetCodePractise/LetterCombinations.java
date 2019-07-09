package leetCodePractise;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinations {

    static HashMap<Character, String> map = new HashMap<>();

    static ArrayList<String> res = new ArrayList<>();

    public static void main(String[] args) {

        String digits = "";
        ArrayList<String> list = letterCombinations(digits);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static ArrayList<String> letterCombinations(String digits) {

        map.put('2', "abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"ikl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        if (digits.equals("")) {
            return res;
        }

        find(digits, 0,"");

        return res;
    }

    /**
     * 找出对应数字可能出现的所有可能性
     * @param digits
     * @param index
     * @param now
     */
    public  static void find(String digits,int index,String now) {

        if (index == digits.length()) {
            res.add(now);
            return;
        }

        char  c = digits.charAt(index);
        String number = map.get(c);
        for (int i=0; i< number.length(); i++) {
            find(digits, index+1, now + number.charAt(i));
        }
    }
}
