package algorithm.leetcode.array;

/**
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 * @Author: Xiongyy
 * @Date: 2021/3/2 23:51
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class NumMatrix {
    int [][] sums;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        if(rows > 0){
            int cells = matrix[0].length;
            sums = new int[rows + 1][ cells + 1];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cells; j++) {
                    sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];

                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }

}
