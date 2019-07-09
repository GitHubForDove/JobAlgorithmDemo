package leetCodePractise;


/**
 * 数组中
 */
public class ArrayRepeatNum {

    public static void main(String[] args) {
        int[] str = new int[]{1,2,3,4,2,5,6,1,0,2};
        System.out.println(arrayRepeatNum(str));
    }

    public static int arrayRepeatNum(int[] str) {
        int num=0;

        if (str== null && str.length <= 0) return 0;

        for (int i=0; i<str.length; i++) {
            if (str[i] < 0 && str[i] > str.length-1)
                return 0;
        }

        for (int i=0; i< str.length; i++) {

            while (str[i] != i) {
                if (str[i] == str[str[i]] ) {
                    num = str[i];
                    return num;
                }
                // 进行交换
                int temp = str[i];
                str[i] = str[temp];
                str[temp] = temp;

            }
        }

        return num;
    }
}
