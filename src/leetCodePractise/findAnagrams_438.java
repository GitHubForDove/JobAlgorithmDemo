package leetCodePractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findAnagrams_438 {

    public static void main(String[] args) {
        String s = "cbaebabacd",p="abc";

        System.out.println(findAnagrams(s,p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        int[] freq_s = new int[26];
        int[] freq_p = new int[26];

        int l =0,r=-1;

        for (int i =0;i<p.length(); i++) {
            freq_p[s.charAt(i)-'a']++;
            freq_s[s.charAt(++r)-'a']++;
        }

        // 如果正好p等于s的前p.length()个字符串  则添加到list中
        if (Arrays.equals(freq_s, freq_p)) {
            list.add(l);
        }

        // 从r下标开始
        while (r < s.length()-1) {

            freq_s[s.charAt(l++)-'a']--;
            freq_s[s.charAt(++r)-'a']++;


            if (Arrays.equals(freq_s, freq_p)) {
                list.add(l);
            }

        }
        return list;
    }
}
