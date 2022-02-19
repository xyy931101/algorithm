package algorithm.leetcode.matrix;

/**
 * 1020. 飞地的数量
 * @author: xiongyayun
 * @date: 2022/2/13 11:12
 */
public class NumberOfEnclaves1020 {
    static int [][] grid = new int[][]{{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};

    public static void main(String[] args) {
        System.out.println(numEnclaves(grid));
    }

    public static int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                dfs(i, 0, grid);
            }
            if (grid[i][n - 1] == 1) {
                dfs(i, n-1, grid);
            }
        }

        for (int i = 1; i < n - 1; i++) {
            if (grid[0][i] == 1) {
                dfs(0, i, grid);
            }
            if (grid[m - 1][i] == 1) {
                dfs(m - 1, i, grid);
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private static void dfs(int x, int y, int[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1){
            return;
        }
        grid[x][y] = 0;
        dfs(x - 1, y, grid);
        dfs(x + 1, y, grid);
        dfs(x, y - 1, grid);
        dfs(x, y + 1, grid);
    }

}
