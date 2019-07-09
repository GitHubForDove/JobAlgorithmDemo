package LeetCode;


import java.util.Arrays;

/**
 * 正则表达式  剑指offer 面试题 19
 */
public class Question19 {

    public static void main(String[] args) {
        String str = "aaa";
        char[] chars = str.toCharArray();
        String pattern = "aa*ac*a";
        char[] patterns = pattern.toCharArray();
        boolean res = match(chars, patterns);
        System.out.println("result : " + res);
    }


    public static boolean match(char[] str, char[] pattern) {

        if (str == null || pattern == null) return false;

        return  matchCore(str, 0, pattern, 0);
    }

    public static boolean matchCore(char[] str, int strIndex, char[] pattern,int patternIndex) {

        //如果都匹配到尾了成功
        if(strIndex==str.length && patternIndex==pattern.length)
            return true;
        //如果模式到尾，字符串没到尾，匹配失败
        if(strIndex!=str.length && patternIndex==pattern.length)
            return false;


        if(patternIndex+1 < pattern.length && pattern[patternIndex+1]=='*'){
            if(str[strIndex]==pattern[patternIndex] && strIndex != str.length||
                    pattern[patternIndex]=='.' && strIndex!=str.length){
                        // 向str 向前移动一个字符串 pattern 向前移动两个字符串  并表示 pattern的a*只匹配str中a 一个字符
                return matchCore(str,strIndex,pattern,patternIndex+2)//视x*匹配0个字符，即*前一个字符出现0次 情况b1
                        ||matchCore(str, strIndex+1, pattern, patternIndex+2)//匹配1个字符，即*前一个字符仅出现1次 情况b2
                        ||matchCore(str, strIndex+1, pattern, patternIndex);//匹配1个字符，模式保持不变 情况b3
            }else {
                // 忽视 a* 这种情况
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        if(strIndex!=str.length && (str[strIndex]==pattern[patternIndex] || pattern[patternIndex]=='.')){
            return matchCore(str, strIndex+1, pattern, patternIndex+1);
        }

        return false;
    }
}
