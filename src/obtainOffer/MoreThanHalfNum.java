package obtainOffer;


/**
 *  找出数组中出现次数超过一半的数字
 */
public class MoreThanHalfNum {


    public static void main(String[] args) {
        int[] data = new int[]{1,2,3,2,2,2,5,4,2};
        int res = moreThanHalfNum(data,data.length);
        System.out.println(res);
    }

    /**
     * 思路： 超过数组一半的数字  一定是是次数最多的那个数字  最后的结果 一定是那个超过数组一半的那个数
     */
    public static int moreThanHalfNum(int[] data, int length) {
        if (length <= 0 ) return 0;

        int result = data[0];
        int times = 1;

        for (int i=1; i< length; i++) {
            if (times == 0) {
                result = data[i];
                times=1;
            } else if (result == data[i]) {
                times++;
            } else {
                times--;
            }

        }
        return result;
    }
}
