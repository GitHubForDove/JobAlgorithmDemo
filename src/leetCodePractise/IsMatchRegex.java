package leetCodePractise;

import java.util.Arrays;
import java.util.Iterator;

public class IsMatchRegex {


    public static void main(String[] args) {
        String s = "bcacbcbaaabccbbbb";
        String p = "b*c*a*.c*b*bac*";
        //System.out.println(p.contains(".") + " : " + p.contains("*"));
        System.out.println(isMatch(s,p));
    }


    public static boolean isMatch(String s, String p) {
        int m = s.length(),n = p.length();

        boolean[][] result = new boolean[m+1][n+1];

        result[0][0]=true;

        for(int i=0 ;i<=m;i++)
            for(int j=1; j<=n; j++){
                // 使用dp算法
                if(p.charAt(j-1)=='*'){
                    //这里i j 可以有三种情况转化而来。
                    // 1. s去掉 *和*之前字母能够 匹配。也就是*之前字母取0次。
                    // 2.*和*之前字母取一次,匹配s中第i个字母，（用递归 所以从1次开始往后几次也是都可以）
                    // 3.这种情况是& 也就是 一定要匹配s中第i-1 。也是因为*之前字母可以取0次，换句话说如果不能匹配i-1 那么一定不能匹配[i][j]
                    result[i][j] = result[i][j-2] || ((i>0) && (s.charAt(i-1)==p.charAt(j-2)|| p.charAt(j-2)=='.')) && result[i-1][j];
                }else{
                    // 把. 当成普通字符一起匹配。这个就比较简单当前位置一样，或者是. 并且[i-1][j-1]也是要匹配
                    result[i][j] = i > 0 && (s.charAt(i-1)==p.charAt(j-1)|| p.charAt(j-1)=='.') && result[i-1][j-1];
                }
            }
        return result[m][n];
    }


    /*public static boolean isMatch(String s, String p) {

        // 如果s的长度要大于p的长度 而且p不包含.或者*符号 则返回false
        if (s.length() == 0 || p.length() == 0 || s.length() > p.length() && (!p.contains(".") || !p.contains("*"))) return false;

        boolean res = isMatchChar(s,0,p,0);
       return res;

    }


    public static boolean isMatchChar(String s, int sCur,String p,int pCur) {

        // 结束条件
        if (sCur >= s.length()-1 && pCur>=p.length()-1) {
            return true;
        } else if (sCur >= s.length()-1 || pCur >= p.length()-1){
            return false;
        }


        if (p.charAt(pCur) != s.charAt(sCur) ) {
            // 判断 p当前字符是不是等于.符号且不等于*符号都满足  那么肯定不匹配
            if (p.charAt(pCur) != '.' && (pCur+1) <=p.length()-1 && p.charAt(pCur+1) != '*') {
                return false;
            }else if (p.charAt(pCur) == '.' && (pCur+1) <= p.length()-1 && p.charAt(pCur+1) == '*' ) {
                if (pCur+2 <= p.length()-1 && s.substring(pCur+2,p.length()-1) == p.substring(pCur+2,p.length()-1)){
                    return true;
                }

            } else  {
                // 如果不是上门面哪些情况 再进行讨论
                if (p.charAt(pCur) == '.' && (pCur+1) <= p.length()-1 && p.charAt(pCur+1) != '*') {
                    pCur++;
                    sCur++;
                    return isMatchChar(s,sCur, p,pCur);
                    // 如果 当前下标p的下一个字符为* 那么 可以认为*匹配为0个字符
                } else if ((pCur+1) <= p.length()-1 && p.charAt(pCur+1) == '*') {
                    return isMatchChar(s,sCur+1, p, pCur+2);
                }
            }
        } else {
            if ((pCur+1) <= p.length()-1 && p.charAt(pCur + 1) == '*') {
                while ((sCur+1) <= s.length()-1 && s.charAt(sCur+1) == p.charAt(pCur)) {
                    sCur++;
                }

                return isMatchChar(s,sCur+1,p,pCur+2);

            }
        }
        return isMatchChar(s,sCur+1,p,pCur+1);
    }*/




}
