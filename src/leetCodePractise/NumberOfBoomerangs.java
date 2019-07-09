package leetCodePractise;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {


    public static void main(String[] args) {
        int[][] points = new int[][]{{0,0},{1,0},{2,0}};
        System.out.println(numberOfBoomerangs(points));
    }


    public static int numberOfBoomerangs(int[][] points) {
        if(points.length<3) return 0;
        int res=0;

        for (int i=0;i<points.length;i++) {

            Map<Integer, Integer> map = new HashMap();

            for (int j=0;j<points.length;j++) {
                if (i != j) {
                    if (map.containsKey(distance(points[i],points[j]))) {
                        map.put(distance(points[i],points[j]),map.get(distance(points[i],points[j]))+1);
                    }else {
                        map.put(distance(points[i],points[j]),1);
                    }
                }
            }
            // 遍历一个查找表
            for(int val: map.values()){

                if(val>=2){
                    res+=val*(val-1);
                }
            }

        }

        return res;

    }

    private static Integer distance(int[] point1, int[] point2) {
        return  (point2[0] - point1[0])*(point2[0] - point1[0])
                + (point2[1] - point1[1])*(point2[1] - point1[1]);
    }


}
