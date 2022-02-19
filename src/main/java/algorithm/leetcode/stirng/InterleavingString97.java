package algorithm.leetcode.stirng;

/**
 * 97. 交错字符串
 * @author: xiongyayun
 * @date: 2022/2/13 15:49
 */
public class InterleavingString97 {

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        char[] str3 = s3.toCharArray();
        int m = str1.length, n = str2.length;
        if(str3.length != m + n){
            return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m && str1[i-1] ==str3[i-1]; i++) dp[i][0] = true; // 不相符直接终止
        for (int j = 1; j <= n && str2[j-1] == str3[j-1]; j++) dp[0][j] = true; // 不相符直接终止

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (str1[i - 1] == str3[i + j - 1] && dp[i - 1][j])
                        || (str2[j - 1] == str3[i +j  - 1] && dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

}
