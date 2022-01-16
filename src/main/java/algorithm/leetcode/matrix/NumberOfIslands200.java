package algorithm.leetcode.matrix;

/**
 * @author: xiongyayun
 * @date: 2022/1/16 12:03
 */
public class NumberOfIslands200 {

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfsMark(grid, i, j);
                }
            }
        }
        return res;
    }

    public static void dfsMark(char[][] grid, int m, int n){
        if(m < 0 || m >= grid.length || n < 0 || n >= grid[0].length || grid[m][n] != '1'){
            return;
        }
        grid[m][n] = '0';
        dfsMark(grid, m - 1, n);
        dfsMark(grid, m + 1, n);
        dfsMark(grid, m, n - 1);
        dfsMark(grid, m, n + 1);
    }

}
