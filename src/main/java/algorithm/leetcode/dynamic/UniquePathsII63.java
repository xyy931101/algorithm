package algorithm.leetcode.dynamic;

/**
 * @author: xiongyayun
 * @date: 2022/1/16 16:13
 */
public class UniquePathsII63 {

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
        System.out.println(uniquePathsWithObstacles(new int[][]{{1,0}}));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m && obstacleGrid[i][0] == 0; i++){
            dp[i][0] = 1;
        }
            for(int i = 0; i < n && obstacleGrid[0][i] == 0; i++){
            dp[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] != 1){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
