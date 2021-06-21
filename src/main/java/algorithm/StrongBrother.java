package algorithm;

/**
 * n *n矩阵，只有0，1元素
 * 给定任意起点（x0, y0) 任意终点（x1,y1)
 * 目标：求 起点到终点路径条数
 * 约束：只能向下和向右，0不能通过。
 *
 *  1 1 0 1
 *  1 1 1 1
 *  1 1 0 1
 *  1 1 1 1
 */
public class StrongBrother {

    public static Integer[][] nums = new Integer[][]{
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1}
    };

    public Integer getWays(int start1, int end1, int start2, int end2){
        if (start1 < start2 || end1 < end2) return 0;

        int[][] dp = new int[start2 - start1 + 1][end2 - end1 + 1];

        for (int i = start1; i <= start2; i++) {
            if (nums[i][0] != 0) dp[i][0] = 1;
        }

        for (int i = end1 + 1; i <= end2; i++) {
            if (nums[0][i] != 0) dp[0][i] = 1;
        }

        for (int i = start1 + 1; i <= start2 ; i++) {
            for (int j = end1 + 1; j <= end2; j++) {
                if (dp[i][j] != 0)
                    dp[i][j] = dp[i][j - 1] +  dp[i - 1][j];
            }
        }

        return dp[start2 - start1][end2 - end1];
    }
}
