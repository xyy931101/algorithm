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
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 0; i <= amount; i++){
            for(int coin : coins){
                if(i >= coin){
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
