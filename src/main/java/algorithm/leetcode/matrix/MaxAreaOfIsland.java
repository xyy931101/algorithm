package algorithm.leetcode.matrix;

/**
 * @author: xiongyayun
 * @date: 2022/11/14 22:01
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    res = Math.max(dfs(grid, i, j), res);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1){
            return 0;
        }
        grid[i][j] = 0;
        return 1 + dfs(grid, i + 1, j)
                +dfs(grid, i - 1, j)
                +dfs(grid, i, j + 1)
                +dfs(grid, i, j - 1);
    }

}
