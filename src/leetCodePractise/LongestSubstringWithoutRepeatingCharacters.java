package leetCodePractise;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(func("abcabcac"));
    }



    public static int func(String s) {

        int[] freq = new int[256];
        int l=0,r=-1;
        int res = 0;

        // 滑动窗口
        while (l < s.length()) {

            // 判断是否右重复的值
            if (r+1 < s.length() && freq[s.charAt(r+1)] == 0) {
                freq[s.charAt(r+1)]++;
                r++;
            }else {
                // 有的话  l向前滑动 并将在freq位置的次数减一
                freq[s.charAt(l++)]--;
            }

            res = Math.max(res, r-l+1);

        }
        return res;
    }
}
