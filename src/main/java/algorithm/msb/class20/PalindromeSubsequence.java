package algorithm.msb.class20;

/**
 * 测试链接：https://leetcode.com/problems/longest-palindromic-subsequence/
 * @author: xiongyayun
 * @date: 2021/8/2 10:46 下午
 */
public class PalindromeSubsequence {

    public static int lpsl1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        return f(str, 0, str.length - 1);
    }

    private static int f(char[] str, int L, int R) {
        if (L == R) return 1;
        else if (L == R -1) return str[L] == str[R] ? 2 : 1;

        int p1 = f(str, L + 1, R);
        int p2 = f(str, L, R - 1);
        int p3 = f(str, L + 1, R - 1);

        if (str[L] == str[R]) {
            p3 += 2;
        }
        return Math.max(Math.max(p1, p2), p3);
    }

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;

        char[] chars = s.toCharArray();

        int N = chars.length;
        int[][] dp = new int[N][N];

        dp[N -1][N -1] = 1;
        for (int i = 0; i < N - 1; i++) {
            dp[i][i] = 1;
            dp[i][ i + 1] = chars[i] == chars[i + 1] ? 2:1;
        }
        for (int L = N -3; L >= 0; L--) {
            for (int R = L +2; R < N; R++) {

                dp[L][R] = Math.max(dp[L][R -1], dp[L + 1][R]);
                if (chars[L] == chars[R]) {
                    dp[L][R] = Math.max(dp[L + 1][R - 1] + 2, dp[L][R]);
                }
            }
        }
        return dp[0][N -1];
    }

}
