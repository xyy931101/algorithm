package algorithm.leetcode.stirng;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * @Author: Xiongyy
 * @Date: 2021/3/20 22:57
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        //如果为空，或者字符串长度小于2，则直接返回该字符串
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        //往前推几个字段
        for (int l = 0; l < n; ++l) {
            //从哪个字段开始
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }
}
