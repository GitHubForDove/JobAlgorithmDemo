package leetCodePractise;


import java.util.*;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

 示例 1:

 输入:
 "tree"

 输出:
 "eert"

 解释:
 'e'出现两次，'r'和't'都只出现一次。
 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 示例 2:

 输入:
 "cccaaa"

 输出:
 "cccaaa"

 解释:
 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 示例 3:

 输入:
 "Aabb"

 输出:
 "bbAa"
 */
public class FrequencySort {


    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }



    public static String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();

        for (int i=0;i<s.length();i++) {
            if (map.containsKey(s.charAt(i))) {
                int objectValue = map.get(s.charAt(i));
                map.put(s.charAt(i), ++objectValue);
            }else {
                map.put(s.charAt(i),1);
            }

        }

        String res = "";

        // 大顶堆
        PriorityQueue<Character> queue = new PriorityQueue(
                (a, b) -> map.get(b) - map.get(a)
        );

        Iterator<Character> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            queue.add(iterator.next());
        }
        StringBuilder sb = new StringBuilder();
        Character w;
        while (queue.peek() != null) {
            w = queue.remove();
            int loopSize = map.get(w);
            for (int i = 0; i < loopSize; i++) {
                sb.append(w);
            }
        }
        return sb.toString();
    }
}
