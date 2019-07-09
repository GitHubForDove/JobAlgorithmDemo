package leetCodePractise;

import java.util.*;


/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

 示例:

 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 输出:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 */
public class GroupAnagrams {


    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams2(strs);
        Iterator it = res.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) return res;


        Map<String,Integer> map = new HashMap();

        for (int i=0;i<strs.length; i++) {

            if (map.containsKey(strs[i])){
                continue;
            }

            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            map.put(strs[i],1);
            for (int j=i+1;j<strs.length;j++) {
                if (isAnagrams(strs[i],strs[j])) {
                    list.add(strs[j]);
                    map.put(strs[j],1);
                }
            }
            res.add(list);
        }

        return res;
    }

    public static boolean isAnagrams(String s,String p) {
        if (s.length() != p.length()) return false;

        int[] ans = new int[26];

        for (int i=0;i<s.length();i++) {
            ans[s.charAt(i)-'a']++;
        }

        for (int j=0;j<p.length();j++) {
            ans[p.charAt(j)-'a']--;
        }

        for (int k=0;k<ans.length;k++) {
            if (ans[k] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 优化版本
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams2(String[] strs) {

        if (strs.length == 0) return new ArrayList();

        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);

            //将排好序的字符串当作key值
            String key = String.valueOf(ca);

            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
