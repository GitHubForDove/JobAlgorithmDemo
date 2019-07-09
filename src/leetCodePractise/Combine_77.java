package leetCodePractise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Combine_77 {
    
    public static void main(String[] args) {

        int n=4,k=2;
        List<List<Integer>> res = combine(n,k);
        Iterator it = res.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }


    public static List<List<Integer>> res = new ArrayList<>();
    /**
     * 产生组合
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {

        res.clear();
        List<List<Integer>> lists = new ArrayList<>();
        if (n <= 0 || k>n || k<=0) return lists;

        List<Integer> list = new ArrayList<>();
        generateCombinations(n,k, 1,list);
        return res;
    }

    /**
     * 递归循环 生成组合
     */
    public static void generateCombinations(int n,int k, int start, List<Integer> list) {

        // 递归结束条件
        if (list.size() == k) {
            // 将满足条件的list加入到res中
            res.add(list);
            return;
        }

        // for循环 查找不同的组合
        for(int i=start; i <= n;i++) {
            list.add(i);
            // 递归查找
            generateCombinations(n,k,i+1,new ArrayList<>(list));
            // 因为循环还在继续 所以需要将上一次 加入到list中的结果 移除掉
            list.remove(list.size()-1);
        }

        return;
    }
}

