package leetCodePractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestoreIpAddresses {


    public static void main(String[] args) {
        String s = "255255111235";
        //List<String> res = restoreIpAddresses(s);
        String[] str = s.split("", 3);
        System.out.println(Arrays.toString(str));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();

        return res;

    }

    // 地址只能分为四段  每段只能是 0 到 255 之间
    public static void ipAddresses(List<String> res, String s, String newStr,  int index) {

        if (index == s.length()) {
            res.add(newStr);
            return;
        }
        s.split(s, 3);

        for (int i=0;i<s.length();i++) {

        }

        return;
    }
}
