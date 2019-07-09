package leetCodePractise;


/**
 *
 * 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

 注意：给定 n 是一个正整数。

 示例 1：

 输入： 2
 输出： 2
 解释： 有两种方法可以爬到楼顶。
 1.  1 阶 + 1 阶
 2.  2 阶
 示例 2：

 输入： 3
 输出： 3
 解释： 有三种方法可以爬到楼顶。
 1.  1 阶 + 1 阶 + 1 阶
 2.  1 阶 + 2 阶
 3.  2 阶 + 1 阶
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs2(44));
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n+1];

        for (int i=0; i<= n;i++) {
            if(i==0){
                dp[i] = 0;
            }
            if(i==1){
                dp[i] = 1;
            }
            if(i==2){
                dp[i] = 2;
            }
            if (i-2>=0) {
                dp[i] += dp[i-1] + dp[i-2];
            }else if (i-1>=0) {
                dp[i] += dp[i-1];
            }

        }

        return dp[n];
    }

    /**
     * 动态规划 使用数组记录执行的过程 从后往前回溯 直到求出所有结果
     */
    static int[] memory;
    public static int climbStairs2(int n) {
        memory = new int[n+1];
        return calcWays(n);
    }

    public static int calcWays(int n){
        //记忆化搜索的方法,calcWays这个方法被执行的2*n-3次，属于O(N)级别的算法
        if(n == 1 ){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(memory[n] == 0){
            memory[n] = calcWays(n-1)+calcWays(n-2);
        }
        return memory[n];
    }
}
