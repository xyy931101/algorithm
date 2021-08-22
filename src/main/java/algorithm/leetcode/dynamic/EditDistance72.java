package algorithm.leetcode.dynamic;

/**
 * @author: xiongyayun
 * @date: 2021/8/22 11:28
 */
public class EditDistance72 {

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        int M = word1.length();
        int N = word2.length();
        int [][] dp = new int[M + 1][N + 1];
        for (int i = 0; i <= M; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= N; i++) {
            dp[0][i] = i;
        }
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                //若str1[i]==str2[j],则完全取之前的,否则替换
                dp[i][j] = dp[i - 1][j - 1] + (str1[i - 1] == str2[j - 1] ? 0 : 1);
                //删除一个字符
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j]);
                //插入
                dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i][j]);
            }
        }
        return dp[M][N];
    }
}
