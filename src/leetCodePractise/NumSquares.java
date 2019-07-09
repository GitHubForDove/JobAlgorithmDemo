package leetCodePractise;

import java.util.LinkedList;
import java.util.Queue;

public class NumSquares {




    public static void main(String[] args) throws Exception {
        int n =  13;
        int res = numSquares(n);
        System.out.println(res);
    }


    public static int numSquares(int n) throws Exception {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n,0});

        // 默认为flase  先将所有的路径都设为没有经过
        boolean[] visited = new boolean[n+1];

        // 已经添加的点设为true
        visited[n] = true;

        while (!queue.isEmpty()) {

            int num = queue.peek()[0];
            int step = queue.peek()[1];
            queue.poll();

            for (int i=0;;i++) {
                int a = num-i*i;

                if (a<0) break;

                if (a==0) return step+1;

                if (!visited[a]) {
                    queue.add(new int[]{a,step+1});
                    visited[a] = true;
                }
            }
        }

        throw new Exception("不是正确的n值！");
    }
}
