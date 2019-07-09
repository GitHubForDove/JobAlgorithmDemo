package leetCodePractise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 *
 * 131. 分割回文串
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

 返回 s 所有可能的分割方案。

 示例:

 输入: "aab"
 输出:
 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */
public class Partition {


    public static void main(String[] args) {
        String s = "aab";
       // boolean b = isPalindronme(s);
        List<List<String>> lists = partition(s);
        Iterator it = lists.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }


    /**
     *
     * @param s
     * @return
     */
    static List<List<String>> lists = new ArrayList<>();

    public static List<List<String>> partition(String s) {

        if (s.length() == 0) return lists;
        List<String> list = new ArrayList<>();
        partition(s, lists, list, 0);

        return lists;

    }

    /**
     * 使用层次遍历 完成递归过程
     * @param s
     * @param lists
     * @param list
     * @param index
     */
    public static void partition(String s, List<List<String>> lists,List<String> list, int index) {

        if (index == s.length()) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = index;i<s.length();i++) {

            if (isPalindronme(s.substring(index,i+1))) {

                list.add(s.substring(index, i+1));

                partition(s,lists, list,i+1);
                list.remove(list.size()-1);
            }
        }

    }

    /**
     * 判断是否为回文串
     * @param s
     * @return
     */
    public static boolean isPalindronme(String s) {
        int low = 0;
        int high = s.length()-1;

        while (low<=high ) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            }else {
                return false;
            }

        }

        return true;
    }
}
