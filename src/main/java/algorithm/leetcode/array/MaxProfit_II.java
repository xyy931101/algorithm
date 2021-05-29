package algorithm.leetcode.array;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @Author: Xiongyy
 * @Date: 2021/2/16 22:15
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class MaxProfit_II {

    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }

    /**
     * 把每天看做一个小区间,只要小区间是赚钱的就可以加
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if(prices[i] < prices[i + 1]){
                maxProfit = maxProfit + prices[i + 1] - prices[i];
            }
        }

        return maxProfit;
    }
}
