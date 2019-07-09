package leetCodePractise;


/**
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * 记录一个字符上次出现的位置，如果两个字符串中的字符上次出现的位置一样，那么就属于同构。
 *
 */
public class IsIsomorphic {


    public static void main(String[] args) {
        System.out.println(isIsomorphic("banacca","tcyckkc"));
    }

    public static boolean isIsomorphic(String s, String t) {
        //if (s.length() != t.length()) return false;

        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);

            if (preIndexOfS[sc] != preIndexOfT[tc]) {
                return false;
            }

            preIndexOfS[sc] = i + 1;
            preIndexOfT[tc] = i + 1;
        }
        return true;
    }
}
