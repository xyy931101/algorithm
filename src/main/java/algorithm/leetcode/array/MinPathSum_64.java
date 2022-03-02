package algorithm.leetcode.array;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 * @Author: Xiongyy
 * @Date: 2021/3/28 9:31
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class MinPathSum_64 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));

    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for(int i = 1; i < n; i++){
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for(int i = 1; i < m; i++){
            dp[0] += grid[i][0];
            for(int j = 1; j < n; j++){
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }

}
