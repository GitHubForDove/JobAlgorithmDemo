package leetCodePractise;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount {

    public static void main(String[] args) {
        int[] A = new int[]{1,2};
        int[] B = new int[]{-2,-1};
        int[] C = new int[]{-1,2};
        int[] D = new int[]{0,2};
        int res = fourSumCount(A,B,C,D);
        System.out.println(res);
    }

    /**
     * 用哈希表来优化嵌套循环，将时间复杂度从 O(n^4) 降低到 O(n^2)
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer>  map = new HashMap<>();

        for (int i=0;i<C.length;i++) {
            for (int j=0;j<D.length;j++) {
                if (map.containsKey(C[i]+D[j])) {
                    map.put(C[i]+D[j], map.get(C[i]+D[j])+1);
                }else {
                    map.put(C[i]+D[j], 1);
                }
            }
        }

        int res=0;
        for (int m=0;m<A.length;m++) {
            for (int n=0;n<B.length;n++) {

                if (map.containsKey(0-A[m]-B[n])) {
                    int value = map.get(0-A[m]-B[n]);
                    res += value;
                }
            }
        }

        return res;
    }
}
