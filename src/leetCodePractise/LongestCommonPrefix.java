package leetCodePractise;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        String res = longestCommonPrefix2(strs);
        System.out.println(res);
    }


    /**
     * 直接使用枚举的方式
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLen = Math.min(strs[i].length(), minLen);
        }
        String res = "";
        int index = 0;
        while (minLen > 0) {
            boolean isHas = true;
            char c = strs[0].charAt(index);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(index) != c) {
                    isHas = false;
                    break;
                }
            }
            if (!isHas) break;

            res += c;
            index++;
            minLen--;
        }
        return res;
    }


    // 使用分治的解法
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private static String longestCommonPrefix(String[] strs, int l, int r) {

        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    public static String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i))
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }
}