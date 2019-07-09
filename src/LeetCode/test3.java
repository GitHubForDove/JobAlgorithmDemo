package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String num = sc.nextLine();
            String[] ss = num.trim().split(",");
            System.out.println(hasCircle(ss));
        }
    }

    public static boolean hasCircle(String[] ss) {
        Map map = new HashMap<String, String>();
        for (String s : ss) {
            if (map.containsValue(s)) return true;
            map.put(s,s);
        }
        return false;
    }
}
