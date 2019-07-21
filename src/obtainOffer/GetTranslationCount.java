package obtainOffer;

/**
 * 面试题46：把数字翻译成字符串
 * 题目：给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成”a“，1 翻译成”b“，
 *  ... ，11 翻译成”l“，...25 翻译成”z“。一个数字可能会有多个翻译。例如，12258有5种不同的翻译，分别是
 *  ”bccfi“、”bwfi“、”bczi“、”mcfi“和”mzi“。请编程实现一个函数，用来计算一个数字有多少不同的翻译方法。
 */
public class GetTranslationCount {


    public static void main(String[] args) {
        int number = 12218;
        int res = getTranslationCount(number);
        System.out.println(res);
    }


    public static int getTranslationCount(int number) {
        if (number < 0) {
            return 0;
        }

        String numberInString = number + "";
        return getTranslationCount(numberInString);
    }

    private static int getTranslationCount(String number) {
        int length = number.length();
        int[] counts = new int[length];
        int count = 0;

        for (int i=length-1;i>= 0; --i) {
            count = 0;
            if (i<length-1) {
                count = counts[i + 1];
            } else {
                count = 1;
            }

            if (i<length-1) {
                int digit1 = number.charAt(i) - '0';
                int digit2 = number.charAt(i+1) - '0';
                int converted = digit1 * 10 + digit2;
                if (converted >= 10 && converted <= 25) {
                    if (i < length-2) {
                        count += counts[i + 2];
                    } else {
                        count += 1;
                    }
                }
            }
            counts[i] = count;
        }
        count = counts[0];
        return count;
    }
}
