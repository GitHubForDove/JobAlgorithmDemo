package leetCodePractise;


/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class question4 {

    public static void main(String[] args) {
        String s = "babad";
        boolean b = isHW(s);
        String len = longestPalindrome(s);
        System.out.println(b);
        System.out.println(len);
    }

    public static String longestPalindrome(String s) {



        /**
         *
         * 递归求解 太慢 不能满足要求
         *
        if (isHW(s)) {
            len = s.length();
        }

        if (n-1 > 0 && longestPalindrome(s.substring(0,n-1)) > len) {
            len = longestPalindrome(s.substring(0,n-1));
        }

        if (n > 1 && longestPalindrome(s.substring(1,n)) > len) {
            len = longestPalindrome(s.substring(1,n));
        }
        return len;
         */

        /**
         * 暴力破解

        int len = 1;
        String str = "";
        int n = s.length();
        if (n < 1) return "";
        if (n == 1) return s;

        for (int i = n; i > 0 ; i --) {
            for (int j = 0; j < i ; j++) {

                if (isHW(s.substring(j, i)) && (i - j) > len) {
                    len = i - j ;
                    str = s.substring(j,i);
                }
            }
        }

        return str;*/

        if(s.length() <= 1)
            return s;
        for(int i = s.length();i > 0; i--) {//子串长度
            for (int j = 0; j <= s.length() - i; j++) {
                String sub = s.substring(j , i + j);//子串位置
                int count = 0;//计数，用来判断是否对称
                for (int k = 0; k < sub.length() / 2; k++) {//左右对称判断
                    if (sub.charAt(k) == sub.charAt(sub.length() - k - 1))
                        count++;
                }
                    if (count == sub.length() / 2)
                        return sub;
                }
        }
        return "";

    }


    public static boolean isHW(String s) {

        int len = s.length();
        for (int i=0; i< len/2 + 1; i++) {
            if (s.charAt(i) != s.charAt(len - i -1)) return false;
        }
        return true;
    }





}
