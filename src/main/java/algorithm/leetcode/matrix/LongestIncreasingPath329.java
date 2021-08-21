package algorithm.leetcode.matrix;

/**
 * 329. 矩阵中的最长递增路径
 * @author: xiongyayun
 * @date: 2021/8/18 11:49 下午
 */
public class LongestIncreasingPath329 {

    public static int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, process(matrix, i, j, dp));
            }
        }
        return ans;
    }

    private static int process(int[][] matrix, int i, int j, int [][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int up = i > 0 && matrix[i][j] < matrix[i - 1][j] ? process(matrix, i - 1, j, dp) : 0;
        int down = i < matrix.length - 1 && matrix[i][j] < matrix[i + 1][j] ? process(matrix, i + 1, j, dp) : 0;
        int left = j > 0 && matrix[i][j] < matrix[i][j - 1] ? process(matrix, i, j - 1, dp) : 0;
        int right = j < matrix[0].length - 1 && matrix[i][j] < matrix[i][j + 1] ? process(matrix, i, j + 1, dp) : 0;
        return Math.max(Math.max(up, down), Math.max(left, right)) + 1;
    }
}
