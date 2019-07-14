package obtainOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * Copyright (c) 2019
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-07-14
 * @descript 字符串的全排列
 */
public class Permutation {

    public static Set<String> result = new HashSet<>();

    public static void permutation(String str) {

        if (str == null) return;
        char[] c = str.toCharArray();
        permutation(c, 0,str.length()-1);
    }

    public  static void permutation(char[] c, int from, int to) {

        if (c == null || from > to || from < 0) {
            return;
        }
        if (from == to) {
            result.add(String.valueOf(c));
        }

        for (int i = from; i <= to; i++) {
            swap(c, i, from);
            permutation(c, from + 1, to);
            swap(c, i, from);
        }

    }

    private static void swap(char[] a, int left, int right) {
        char temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }


    public static void main(String[] args) {
        String str = "abc";
        permutation(str);

        System.out.println(result);

    }

}
