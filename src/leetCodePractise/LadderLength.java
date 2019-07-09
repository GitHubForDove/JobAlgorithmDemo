package leetCodePractise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LadderLength {


    public static void main(String[] args) {

    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();//建立队列
        queue.add(beginWord); // 将开始的字符串加入到队列中
        boolean[] marked = new boolean[wordList.size()+1]; // 建立标记
        int layer = 1; // 注意返回的是层数+1.所以这里直接放1了

        while (!queue.isEmpty()) {

            layer++;
            int size = queue.size();

            while (size-- > 0) {
                String cur = queue.poll();
                // 将当前的字符串与字典中的字符串进行对比  如果可以转换 就直接加入到队列中
                // 如果直接等于endword 那么直接返回当前的层次
                for (int i=0;i<wordList.size();i++) {
                    if (marked[i]) continue;
                    String dict = wordList.get(i);
                    if (canTransfer(cur,dict)) {
                        if (dict.equals(endWord)) return layer;
                        queue.add(dict);
                        marked[i] = true;
                    }
                }
            }
        }


        return 0;
    }

    public static boolean canTransfer(String word, String otherword) {
        int diff = 0;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != otherword.charAt(i))diff++;
        }
        return diff==1;
    }
}
