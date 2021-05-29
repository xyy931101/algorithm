package algorithm.leetcode.array;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * @Author: Xiongyy
 * @Date: 2021/2/16 21:47
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = {7, 4, 6, 3, 5, 1};
        System.out.println(maxProfit(prices));
        System.out.println(0x1);
    }
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            //如果当前值比前面的最小值小,并且后面存在利润比之前的大
            if(minPrice > prices[i]){
                minPrice = prices[i];
            }else if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
