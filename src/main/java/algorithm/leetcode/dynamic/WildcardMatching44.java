package algorithm.leetcode.dynamic;

/**
 * 44. 通配符匹配
 * @author: xiongyayun
 * @date: 2022/2/4 15:51
 */
public class WildcardMatching44 {

    public static void main(String[] args) {
        System.out.println(isMatch("adceb", "*a*b"));
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) != '*') {
                break;
            }
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }

}
