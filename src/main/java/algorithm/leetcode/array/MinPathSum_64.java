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
        int[][] grid = new int[][]{{1}};
        System.out.println(minPathSum(grid));

    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cells = grid[0].length;

        int[][] result = new int[rows][cells];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if (i == 0 && j == 0) {
                    result[i][j] = grid[i][j];
                }else if (i == 0) {
                    result[i][j] = result[i][j - 1] + grid[i][j];
                }else if (j == 0) {
                    result[i][j] = result[i - 1][j] + grid[i][j];
                }else {
                    result[i][j] = Math.min(result[i - 1][j] + grid[i][j], result[i][j -1] + grid[i][j]);
                }

            }
        }
        return result[rows -1][cells - 1];
    }

}
