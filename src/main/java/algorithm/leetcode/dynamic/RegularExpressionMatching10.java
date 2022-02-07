package algorithm.leetcode.dynamic;

/**
 * 10. 正则表达式匹配
 * @author: xiongyayun
 * @date: 2022/2/5 11:40
 */
public class RegularExpressionMatching10 {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m +1][n + 1];
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        dp[0][0] = true;
        dp[0][0] = true;

        // s为空，p不为空，由于*可以匹配0个字符，所以有可能为true
        for (int j = 1; j <= m; j++) {
            if (cp[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++){
                if (cs[i - 1] == cp[j - 1] || cp[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }else if (cp[j - 1] == '*') {
                    if (cs[i - 1] == cp[j - 2] || cp[j - 2] == '.') {
                        dp[i][j] = dp[i][j - 2]  || dp[i - 1][j];
                    }
                }
            }
        }
        return  dp[m][n];
    }
}
