package leetCodePractise;

public class StockMaxProfit {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        int res = maxProfit2(nums);
        System.out.println(res);
    }


    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

     设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

     注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

     示例 1:

     输入: [7,1,5,3,6,4]
     输出: 7
     解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     示例 2:

     输入: [1,2,3,4,5]
     输出: 4
     解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     示例 3:

     输入: [7,6,4,3,1]
     输出: 0
     解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i]>prices[i-1])
            {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }


    /**
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

     设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

     注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

     示例 1:

     输入: [3,3,5,0,0,3,1,4]
     输出: 6
     解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     示例 2:

     输入: [1,2,3,4,5]
     输出: 4
     解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     示例 3:

     输入: [7,6,4,3,1]
     输出: 0
     解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
     */


    public static int maxProfit2(int[] prices) {
        /**
         对于任意一天考虑四个变量:
         fstBuy: 在该天第一次买入股票可获得的最大收益
         fstSell: 在该天第一次卖出股票可获得的最大收益
         secBuy: 在该天第二次买入股票可获得的最大收益
         secSell: 在该天第二次卖出股票可获得的最大收益
         分别对四个变量进行相应的更新, 最后secSell就是最大
         收益值(secSell >= fstSell)
         **/
        int fstBuy = Integer.MIN_VALUE, fstSell = 0;
        int secBuy =Integer.MIN_VALUE, secSell = 0;

        // 动态规划
        for(int p : prices) {

            fstBuy = Math.max(fstBuy, -p);
            System.out.println(fstBuy);

            fstSell = Math.max(fstSell, fstBuy + p);
            System.out.println(fstSell);

            secBuy = Math.max(secBuy, fstSell - p);
            System.out.println(secBuy);

            secSell = Math.max(secSell, secBuy + p);
            System.out.println(secSell);
        }

        return secSell;
    }

}
