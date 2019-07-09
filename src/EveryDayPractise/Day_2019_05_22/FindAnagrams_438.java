package EveryDayPractise.Day_2019_05_22;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

 说明：

 字母异位词指字母相同，但排列不同的字符串。
 不考虑答案输出的顺序。
 示例 1:

 输入:
 s: "cbaebabacd" p: "abc"

 输出:
 [0, 6]

 解释:
 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 示例 2:

 输入:
 s: "abab" p: "ab"

 输出:
 [0, 1, 2]

 解释:
 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class FindAnagrams_438 {

    /**
     * 答题思路
     *
     * 1、使用 下标数组将字符相应的位置进行标记
     * 2、 使用双指针对s进行滑动窗口的位移 与 p进行比较
     * 3、将满足条件的下标 放入list中 存储
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
        int[] freq_s = new int[26];
        int[] freq_q = new int[26];

        int l=0,r=-1;
        for (int i=0;i<p.length();i++) {
            freq_s[s.charAt(++r)-'a']++;
            freq_q[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freq_s,freq_q)) {
            list.add(l);
        }

        while (r < s.length()-1) {

            freq_s[s.charAt(++r)-'a']++;
            freq_s[s.charAt(l++)-'a']--;

            if (Arrays.equals(freq_s,freq_q)) {
                list.add(l);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        String s = "abab",p="ab";
        System.out.println(findAnagrams(s,p));
    }
}
