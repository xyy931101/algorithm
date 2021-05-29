package algorithm.leetcode.dynamic;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * @author xiongyayun
 * @description
 * @date 2021/5/6 19:13
 */
public class CoinChange323 {

    public static void main(String[] args) {
        CoinChange323 c = new CoinChange323();
        System.out.println(c.coinChange(new int[] {1, 2, 5}, 11));;
    }

    public int coinChange(int[] coins, int amount) {
        //边界值
        if (coins == null || coins.length == 0) return -1;
        //构建dp数组
        int[] dp = new int[amount + 1];
        //不可能存在的amount的值
        Arrays.fill(dp, amount + 1);
        //baseCase
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
