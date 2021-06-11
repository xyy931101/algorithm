package algorithm.leetcode.dynamic;

/**
 * 518. 零钱兑换 II
 * @author: xiongyayun
 * @date: 2021/6/10 11:53 下午
 */
public class CoinChangeII518 {

    public int change(int amount, int[] coins) {
        int len = coins.length;
        if (len == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = coins[0]; i <= amount; i += coins[0]) {
            dp[i] = 1;
        }

        for (int i = 1; i < len; i++) {

            // 从 coins[i] 开始即可
            for (int j = coins[i] ; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];

    }
}
