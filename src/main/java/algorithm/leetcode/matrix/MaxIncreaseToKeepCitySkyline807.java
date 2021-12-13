package algorithm.leetcode.matrix;

/**
 * 807. 保持城市天际线
 * @author: xiongyayun
 * @date: 2021/12/13 8:47 下午
 */
public class MaxIncreaseToKeepCitySkyline807 {

    public static void main(String[] args) {
        int[][] grid =  new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        System.out.println(maxIncreaseKeepingSkyline(grid));
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid== null || grid.length < 1){
            return 0;
        }
        int[] rows = new int[grid.length];
        int[] cells = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            int row = grid[i][0];
            cells[0] = Math.max(cells[0], grid[i][0]);
            for (int j = 1; j < grid[0].length; j++) {
                row = Math.max(row, grid[i][j]);
                cells[j] = Math.max(cells[j], grid[i][j]);
            }
            rows[i] = row;

        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res += Math.min(rows[i], cells[j]) - grid[i][j];
            }
        }
        return res;
    }
}
