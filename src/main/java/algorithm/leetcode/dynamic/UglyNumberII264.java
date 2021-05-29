package algorithm.leetcode.dynamic;

/**
 * 264. 丑数 II
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 * @Author: Xiongyy
 * @Date: 2021/4/11 16:15
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class UglyNumberII264 {

    public static void main(String[] args) {
        UglyNumberII264 u = new UglyNumberII264();
        System.out.println(u.nthUglyNumber(10));
    }

    public int nthUglyNumber(int n) {
        if (n < 1) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int index2 = 1, index3 = 1, index5 = 1;
        for (int i = 1; i < n; i++) {
            int nextUgly = Math.min(Math.min(dp[index2 - 1] * 2, dp[index3 - 1] * 3), dp[index5 - 1] * 5);
            dp[i] = nextUgly;
            if (nextUgly == dp[index2 - 1] * 2) {
                index2 ++;
            }
            if (nextUgly == dp[index3 - 1] * 3) {
                index3++;
            }
            if (nextUgly == dp[index5 - 1] * 5) {
                index5++;
            }
        }
        System.out.println(dp);
        return dp[n-1];
    }
}
