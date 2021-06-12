package algorithm.leetcode.dynamic;

/**
 * 279. 完全平方数
 * @author: xiongyayun
 * @date: 2021/6/11 8:21
 */
public class PerfectSquares279 {

    public int numSquares(int n) {

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            //最坏的情况,i个1相加
            dp[i] = i;

            for (int j = 1; i - j * j >= 0; j++) {
                //遍历前面的i的平方数,查找前面平方数最小的值
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }

        }
        return dp[n];
    }

}
