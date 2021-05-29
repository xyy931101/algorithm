package algorithm.leetcode.dynamic;

/**
 * @author xiongyayun
 * @date 2021/5/12 23:27
 */
public class LongestPalindromicSubsequence516 {


    public int longestPalindromeSubseq(String s) {
        if (s == null ||s.length() <= 1) {
            return s.length();
        }

        char[] chars = s.toCharArray();
        int length = s.length();
        int[][] dp = new int[length][length];
        dp[0][0] = 1;
        dp[length - 1][length - 1] = 1;
        for (int i = 1; i < length - 1; i++) {
            dp[i][i] = 1;
            dp[i][i + 1] = chars[i] == chars[i + 1]? 2 : 1;
        }
        for (int i = length - 3; i >= 0; i--) {
            for (int j = i + 2; j < length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                if (chars[i] == chars[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j + 1] + 2);
                }
            }
        }
        return dp[0][length - 1];
    }

}
