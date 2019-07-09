package leetCodePractise;



public class NextGreaterElement {

    public static void main(String[] args) {
        int n = 12443322;
        System.out.println(nextGreaterElement(n));
    }

    public static int nextGreaterElement(int n) {

        if (n < 12){
            return -1;
        }

        String num = String.valueOf(n);
        char[] cNum = num.toCharArray();
        int index = num.length() - 2;
        while (index >= 0 && cNum[index+1] <= cNum[index]){
            index--;
        }

        if (index >=0) {
            int len = num.length()-1;

            while (len >= index && cNum[len] <= cNum[index]) {
                len --;
            }
            swap(cNum, index, len);
        }
        reverse(cNum, index+1,cNum.length-1);


        int resNum = cNum[0]-'0';
        for (int i=1; i< cNum.length; i++) {
            resNum = resNum*10 + cNum[i]-'0';
        }

        if (resNum > Integer.MAX_VALUE){//如果超过了int型的最大表示范围，返回-1
            return -1;
        }

        if (resNum < n)  return -1;
        return resNum;
    }

    public static void reverse(char[] nums, int start, int end) {
        int i=start, j = end;

        while (i<j) {
            swap(nums, i ,j);
            i++;
            j--;
        }

    }


    public static void swap(char[] nums, int start, int end) {
        char temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
