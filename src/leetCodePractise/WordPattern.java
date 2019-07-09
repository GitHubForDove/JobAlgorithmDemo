package leetCodePractise;

import java.util.*;

public class WordPattern {

    public static void main(String[] args) {
        String pattern = "abba", str = "dog cat cat tog";
        Boolean res = wordPattern(pattern, str);
        System.out.println(res);
    }


    public static boolean wordPattern(String pattern, String str) {

        String[] strs = str.split(" ");
        char[] c = pattern.toCharArray();
        if (c.length != strs.length) return false;
        Map<Character, String> map = new HashMap<>();

        for (int j=0;j<c.length;j++) {
            if (!map.containsKey(c[j])) {
                if(!map.containsValue(strs[j])) {
                    map.put(c[j], strs[j]);
                }else {
                    return false;
                }
            } else {
                if(!map.get(c[j]).equals(strs[j])) {
                    return false;
                }
            }
        }

        return true;
    }

}
