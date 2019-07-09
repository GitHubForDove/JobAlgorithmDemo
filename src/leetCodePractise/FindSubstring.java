package leetCodePractise;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 */
public class FindSubstring {

    public static void main(String[] args) {

       /* Scanner sc  = new Scanner(System.in);

        while (sc.hasNext()) {
            String s = sc.nextLine();
            int n = sc.nextInt();
            String[] words = new String[n];
            for (int i=0; i< n;i++) {
                words[i] = sc.nextLine();
            }
*/
       String s = "mississippi";
        String[] words = new String[]{"is"};

        List<Integer> res = findSubstring(s, words);
        System.out.println(Arrays.toString(res.toArray()));

        }


    public static List<Integer> findSubstring(String s, String[] words) {

        // 当words== 0时
        if (words.length == 0) {
            return new ArrayList<>();
        }
        // 当words的长度大于s的长度 返回空list
        if (s.length() < words.length * words[0].length()) {
            return new ArrayList<>();
        }

        int len = words[0].length();

        // 将words 直接转化为list  存入wordss中
        List<String> wordss = new ArrayList<>(Arrays.asList(words));


        List<Integer> res = new ArrayList<>();

        if (wordss.size() == s.length()) res.add(0);
        int i = 0;
        while (i+len < s.length()) {

            // 因为word的长度固定  遍历时 滑动窗口往前进行滑动
            if (wordss.contains(s.substring(i,i+len))) {
                // 每次遍历重新将words装入user中
                List<String> use = new ArrayList<>(wordss);
                // 将已经确认存在的word从list中移除
                use.remove(s.substring(i,i+len));

                int j = 1;
                while (i + (j+1)*len <= s.length()) { // 判断后面的 i + （j+1）*len 是否小于s的长度

                    // 如果移动use移除后面固定窗口的字符串 不存在use中 则代表不是连续包含所有words 则跳出
                    if (!use.remove(s.substring(i+j*len,i+(j+1)*len))) {
                        break;
                    }
                    // 如果use为空  说明全部word都存在 res添加word的下标
                    if (use.isEmpty()) {
                        res.add(i);
                    }
                    // 滑动窗口继续向前移动
                    j++;
                }
            }
            i++;
        }
        return res;
    }

   /* public static int num(String[] arrayA) {
        int len = arrayA.length;
        int num = len;
        for (int i=arrayA.length-1; i>0; i--) {
            num = num * i;
        }
        return num;
    }

    public static ArrayList<String> recursionArrange(String[] arrayA,int start,int end){
        int len = num(arrayA);
        System.out.println(len);

        ArrayList<String> list = new ArrayList<>();
        if(start == end){
            String temp = "";
            for(int i = 0;i < arrayA.length;i++)
                temp += arrayA[i];
            list.add(temp);
        }
        else{
            for(int i = start;i <= end;i++){
                swap(arrayA,i,start);
                recursionArrange(arrayA,start+1,end);
                swap(arrayA,i,start);
            }
        }
        return list;
    }
    //交换数组m位置和n位置上的值
    public static void swap(String[] arrayA, int m, int n){
        String temp = arrayA[m];
        arrayA[m] = arrayA[n];
        arrayA[n] = temp;
    }*/

}
