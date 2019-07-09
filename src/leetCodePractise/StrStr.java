package leetCodePractise;


/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 */
public class StrStr {
    public static void main(String[] args) {
        String haystack = "mississippi", needle = "issipi";
        System.out.println(strStr(haystack, needle));
    }

    /**
     * 找出 第一个出现字串的位置
     * @param haystack
     * @param needle
     * @return
     */
    public static  int strStr(String haystack, String needle) {

        if (haystack.length() ==0 && needle.length() == 0) return 0;
        if (haystack.length() != 0 && needle.length() == 0) return 0;
        if ((haystack.length()==0 && needle.length() != 0) || haystack.length() < needle.length()) return -1;

        int index=0;
        boolean isInclude = false;

        for (int i=0; i<haystack.length(); i++) {

            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.length() - i < needle.length()) break;
                int temp = i;

                for (int j=0; j< needle.length(); j++) {

                    if ( haystack.charAt(temp) != needle.charAt(j)) {
                        isInclude = false;
                        break;
                    }
                    temp++;
                    isInclude = true;
                }

                if (isInclude == true) {
                    index = i;
                    break;
                }
            }
        }
        return isInclude ? index : -1;
    }
}
