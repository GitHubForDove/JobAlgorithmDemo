package leetCodePractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FindAllAnagrams {

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        List<Integer> list = findAllAnagrams2(s,p);
        Iterator it = list.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }


    public static List<Integer> findAllAnagrams(String s,String p) {
        List<Integer> list = new ArrayList<>();

        if (s.length() < p.length()) return list;

        int l=0,r=p.length()-1;

        while (r < s.length()) {
            if (r<s.length() && isContains(s.substring(l,r+1), p)) {
                list.add(l);
                r++;
                l++;
            }else {
                if (r<s.length()) {
                    r++;
                    l++;
                }else {
                    return list;
                }

            }

        }
        return list;
    }

    /**
     * 优化版 使用两个freq数组
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAllAnagrams2(String s,String p) {
        List<Integer> list = new ArrayList<>();

        if (s.length() < p.length()) return list;

        int[] freq_s = new int[26];
        int[] freq_p = new int[26];
        int l=0,r=-1;

        for (int i=0;i<p.length();i++) {
            freq_p[p.charAt(i)-'a']++;
            freq_s[s.charAt(++r)-'a']++;
        }

        if (Arrays.equals(freq_p, freq_s)){
            list.add(l);
        }

        while (r < s.length()-1) {
            freq_s[s.charAt(++r)-'a']++;
            freq_s[s.charAt(l++)-'a']--;

            if (Arrays.equals(freq_p, freq_s)) {
                list.add(l);
            }
        }
        return list;
    }

        public static boolean isContains(String s, String p) {
        int[] freq = new int[256];
        for (int i=0;i<p.length();i++) {
            freq[p.charAt(i)]++;
        }

        for (int j=0;j<s.length();j++) {
            freq[s.charAt(j)]--;
        }

        for (int i=0;i<freq.length;i++) {
            if (freq[i] != 0) return false;
        }
        return true;
    }
}
