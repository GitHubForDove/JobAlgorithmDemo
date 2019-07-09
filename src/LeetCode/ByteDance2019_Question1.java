package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ByteDance2019_Question1 {

    static class Feature {
        int x;
        int y;

        public Feature(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean compare(Feature feature) {
            if (feature.x == this.x && feature.y == this.y) {
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args) {

        int count =0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            Map map = new HashMap();
            for (int i=0; i< n; i++) {
                int testNum = sc.nextInt();
                for (int j=0; j<testNum; j++) {
                    int zNum = sc.nextInt();
                    for (int k=0; k<zNum; k++) {

                    }
                }
            }
        }
    }

    public static int num() {
        Map map = new HashMap();
        return 0;
    }
}
