package leetCodePractise;


/**
 *
 * 计算一组字符集合可以组成的回文字符串的最大长度
 *
 * Input : "abccccdd"
 * Output : 7
 * Explanation : One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 * 使用长度为 256 的整型数组来统计每个字符出现的个数，每个字符有偶数个可以用来构成回文字符串。
 *
 * 因为回文字符串最中间的那个字符可以单独出现，所以如果有单独的字符就把它放到最中间。
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }

    public static int longestPalindrome(String s) {

        int[] ans = new int[265];

        for (char c : s.toCharArray()) {
            ans[c] ++;
        }

        int length = 0;
        for (int a : ans) {
            length += (a / 2) * 2;
        }

        if (length < s.length()) {
            length = length +1;
        }

        return length;
    }
}
