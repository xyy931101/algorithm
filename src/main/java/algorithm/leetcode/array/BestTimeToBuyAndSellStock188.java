package algorithm.leetcode.array;

/**
 * 188. 买卖股票的最佳时机 IV
 * @author: xiongyayun
 * @date: 2021/8/29 13:56
 */
public class BestTimeToBuyAndSellStock188 {

    public static int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int N = prices.length;
        //因为有升有降,所以只要大于N/2,就可以退化为不限制次数
        if (k >= N / 2) {
            return allTrans(prices);
        }
        int[][] dp = new int[k + 1][N];
        int ans = 0;
        for (int tran = 1; tran <= k; tran++) {
            int pre = dp[tran][0];
            int best = pre - prices[0];
            for (int index = 1; index < N; index++) {
                pre = dp[tran - 1][index];
                dp[tran][index] = Math.max(dp[tran][index - 1], prices[index] + best);
                best = Math.max(best, pre - prices[index]);
                ans = Math.max(dp[tran][index], ans);
            }
        }
        return ans;
    }

    public static int allTrans(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - prices[i - 1], 0);
        }
        return ans;
    }
}
