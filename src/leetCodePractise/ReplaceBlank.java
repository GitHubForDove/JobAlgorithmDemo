package leetCodePractise;

import java.util.Arrays;

/**
 * 替换掉字符串中的空格
 */
public class ReplaceBlank {


    public static void main(String[] args) {
        String s = "we are happy";
        s = s.replace(" ", "%20");
        System.out.println(s);
    }


    public static void replaceBlank(String str, int len) {
        if (str == null && str.length() < 0) return;

        int originalLen = len;
        int i = 0;
        while (len > 0) {
            if (str.charAt(i) == ' ' ) {
                i++;
            }
            len --;
        }

        int newLen = originalLen + i * 2;

        while (newLen > 0 && originalLen > 0) {

            if (str.charAt(originalLen) == ' ') {
               // str.charAt(newLen--) = '%';
               // str.charAt(newLen--) = '2';
               // str.charAt(newLen--) = '0';
            } else {
                newLen--;
                originalLen --;
            }

        }
    }
}
