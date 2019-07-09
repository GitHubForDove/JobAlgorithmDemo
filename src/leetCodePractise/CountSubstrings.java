package leetCodePractise;


/**
 *
 * 题目 : 回文子字符串个数
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 从字符串的某一位开始，尝试着去扩展子字符串。
 */
public class CountSubstrings {


    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

    static int cns= 0;
    public static int countSubstrings(String s) {

        for (int i=0; i < s.length(); i++) {
            count(s, i, i); // 奇数算个数
            count(s, i, i+1); // 偶数算个数
        }
        return cns;
    }


    /**
     * 双指针法 判断是否是
     * @param s
     * @param start
     * @param end
     */
    public static void count(String s, int start, int end) {

        while (start >=0 && end < s.length() && s.charAt(start)== s.charAt(end)) {
            start--;
            end ++;
            cns ++;
        }

    }
}
