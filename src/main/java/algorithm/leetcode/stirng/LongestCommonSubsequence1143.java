package algorithm.leetcode.stirng;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符
 * （也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * @Author: Xiongyy
 * @Date: 2021/4/3 10:54
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class LongestCommonSubsequence1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        System.nanoTime();
        //其实这里可以不用做判断,题目里面已经给定了两个字符串不为空
        if (text1 == null || text2 == null || text1.length() < 1 ||text1.length() < 2) {
            return 0;
        }
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //如果两个字符相等,则是前面的最长公共子序列+1
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    //如果不相等那就要看text1的前i个字符和text2的前j - 1个字符
                    //以及text1的前i - 1个字符和text2的前j个字符的最长公共子序列长度哪个大了
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j -1]);
                }
            }
        }
        return dp[m][n];
    }

}
