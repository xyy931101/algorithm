package algorithm.msb.class19;

/**
 * @author: xiongyayun
 * @date: 2021/8/1 10:30 下午
 */
public class LongestCommonSubsequence {

    public static int longestCommonSubsequence1(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        // 尝试
        return process1(str1, str2, str1.length - 1, str2.length - 1);
    }

    private static int process1(char[] str1, char[] str2, int index1, int index2) {
        if (index1 == 0 && index2 == 0) {
            return str1[index1] == str2[index2] ? 1 : 0;
        }else if (index1 == 0) {
            if (str1[index1] == str2[index2]) {
                return 1;
            }else {
                return process1(str1, str2, index1, index2 - 1);
            }
        }else if (index2 == 0) {
            if (str1[index1] == str2[index2]) {
                return 1;
            } else {
                return process1(str1, str2, index1 - 1, index2);
            }
        }else {
            int p1 = process1(str1, str2, index1 - 1, index2);
            int p2 = process1(str1, str2, index1, index2 - 1);
            int p3 = str1[index1] == str2[index2] ? (1 + process1(str1, str2, index1 - 1, index2 - 1)) : 0;
            return Math.max(Math.max(p1, p2), p3);
        }
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        int M = text1.length();
        int N = text2.length();
        int[][] dp = new int[M ][N];

        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1; i < M; i ++) {
            dp[i][0] = str1[i] == str2[0] ? 1 : dp[i - 1][0];
        }

        for (int i = 1; i < N; i ++) {
            dp[0][i] = str1[0] == str2[i] ? 1 : dp[0][i - 1];
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.max(dp[i -1][j], dp[i][j -1]);
                if (str1[i] == str2[j]) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j]);
                }
            }
        }
        return dp[M - 1][N - 1];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
}
