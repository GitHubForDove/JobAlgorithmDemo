package leetCodePractise;


/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。

 示例 1:

 输入: s = "anagram", t = "nagaram"
 输出: true
 示例 2:

 输入: s = "rat", t = "car"
 输出: false
 说明:
 你可以假设字符串只包含小写字母。
 */
public class IsAnagram {

    public static void main(String[] args) {

    }

    /**
     * 判断是否两个字符串包含的字符是否完全相同
     * @param s
     * @param t
     * @return
     */
    public static boolean IsAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] ans = new int[26];
        char[] S = s.toCharArray();
        for (int i=0; i< S.length; i++) {
            ans[S[i] - 'a']++;
        }
        char[] T = t.toCharArray();
        for (int j=0; j< T.length; j++) {
            ans[T[j] - 'a']--;
        }

        for (int k=0; k< ans.length; k++) {
            if (ans[k] != 0) {
                return false;
            }
        }

        return true;
    }
}
