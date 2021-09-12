package algorithm.leetcode.dynamic;

/**
 * 678. 有效的括号字符串
 * @author: xiongyayun
 * @date: 2021/9/12 16:49
 */
public class ValidParenthesisString678 {

    public boolean checkValidString(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1);
            for (int j = 0; j <= i; j++) {
                if (ch == '(') {
                    if (j  >= 1) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }else if (ch == ')') {
                    if (j + 1 <= i) {
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                }else {
                    dp[i][j] = dp[i - 1][j];
                    if (j - 1>= 0) {
                        dp[i][j] |= dp[i -1][j - 1];
                    }
                    if (j + 1 <= i) {
                        dp[i][j] |= dp[i - 1][j + 1];
                    }
                }
            }
        }
        return dp[n][0];
    }
}
