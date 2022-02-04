package algorithm.leetcode.dynamic;

/**
 * 115. 不同的子序列
 * @author: xiongyayun
 * @date: 2022/2/3 13:19
 */
public class DistinctSubsequences115 {

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }

    public static int numDistinct(String s, String t) {
        int m = t.length();
        int n = s.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++){
                dp[i][j] = dp[i][j - 1];
                if(s.charAt(j - 1) == t.charAt(i - 1)){
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
