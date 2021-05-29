package algorithm.leetcode.dynamic;

/**
 * 1269. 停在原地的方案数
 * @author xiongyayun
 * @date 2021/5/13 8:32
 */
public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps1269 {

    public static void main(String[] args) {
        System.out.println(numWays(3, 2));
    }

    public static int numWays(int steps, int arrLen) {
        if (arrLen == 0) {
            return 0;
        }
        int MODULO = 1000000007;
        //右arrLen的长度的话,其实就是arrLen - 1
        int maxColumn = Math.min(steps, arrLen - 1);
        int[][] dp = new int[steps + 1][maxColumn + 1];
        //baseCase
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            //处理第i步,在第j个位置处的数量
            for (int j = 0; j <= maxColumn; j++) {
                //其中第i个位置可以由原地踏步
                dp[i][j] = dp[i - 1][j];
                //也可以i-1向右移动而来
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MODULO;
                }
                //也可以由i+1向左移动而来
                if (j <= maxColumn - 1) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MODULO;
                }
            }
        }
        return dp[steps][0];
    }

}
