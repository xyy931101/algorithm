package algorithm.leetcode.matrix;

/**
 * 1139. 最大的以 1 为边界的正方形
 * @author: xiongyayun
 * @date: 2021/8/21 11:18 下午
 */
public class Largest1BorderedSquare1139 {

    public int largest1BorderedSquare(int[][] grid) {
        //边界值判断
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int[][] right = new int[grid.length][grid[0].length];
        int[][] down = new int[grid.length][grid[0].length];
        setBorderMap(grid, right, down);

        for (int size = Math.min(grid.length, grid[0].length); size != 0; size--) {
            if (hasSizeOfBorder(size, right, down)) {
                return size * size;
            }
        }
        return 0;

    }

    private boolean hasSizeOfBorder(int size, int[][] right, int[][] down) {

        for (int i = 0; i < right.length - size + 1; i++) {
            for (int j = 0; j < right[0].length  - size + 1; j++) {
                if (right[i][j] >= size && down[i][j] >= size && right[i + size - 1][j] >= size && down[i][j + size - 1] >= size){
                    return true;
                }
            }
        }
        return false;
    }

    private void setBorderMap(int[][] grid, int[][] right, int[][] down) {

        int r = grid.length;
        int c = grid[0].length;
        if (grid[r - 1][c - 1] == 1) {
            right[r - 1][c - 1] = 1;
            down[r - 1][c - 1] = 1;
        }
        //处理最后两行
        for (int i = r - 2; i != -1; i--) {
            if (grid[i][c - 1] == 1) {
                right[i][c - 1] = 1;
                down[i][c - 1] = down[i + 1][c - 1] + 1;
            }
        }
        //处理最后两列
        for (int i = c - 2; i != -1; i--) {
            if (grid[r - 1][i] == 1) {
                right[r - 1][i] = right[r - 1][i + 1] + 1;
                down[r - 1][i] = 1;
            }
        }

        for (int i = r - 2; i != -1; i--) {
            for (int j = c - 2; j != -1; j--) {
                if (grid[i][j] == 1) {
                    right[i][j] = right[i][j + 1] + 1;
                    down[i][j] = down[i + 1][j] + 1;
                }
            }
        }
    }

}
