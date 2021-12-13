package algorithm.leetcode.matrix;

/**
 * 1034. 边界着色
 * @author: xiongyayun
 * @date: 2021/12/7 8:36
 */
public class ColoringABorder1034 {

    int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    int[][] ans;
    int color;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        if (grid[row][col] == color) {
            return grid;
        }
        this.color = color;
        int m = grid.length;
        int n = grid[0].length;
        ans = new int[m][n];
        dfs(grid, row, col, grid[row][col]);


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] == 0) ans[i][j] = grid[i][j];
                else if (ans[i][j] == -1) ans[i][j] = color;
            }
        }
        return grid;
    }

    private void dfs(int[][] grid, int row, int col, int old) {
        int cnt = 0;
        for (int[] di : dirs) {
            int nx = row + di[0], ny = col + di[1];
            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) continue;
            if (grid[row][col] != grid[nx][ny]) continue;
            else cnt++;
            //没有被访问过
            if (ans[nx][ny] != 0) continue;
            ans[nx][ny] = -1;
            dfs(grid, nx, ny, old);
        }
        ans[row][col] = cnt == 4 ? grid[row][col] : -1;

    }

}
