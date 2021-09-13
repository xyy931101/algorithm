package algorithm.leetcode.matrix;

/**
 * @author: xiongyayun
 * @date: 2021/9/13 9:51 下午
 */
public class SetMatrixZeroes73 {


    public void setZeroes(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        boolean row0Zero = false;
        boolean col0Zero = false;

        for (int i = 0; i < M; i++) {
            if (matrix[i][0] == 0) {
                col0Zero = true;
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            if (matrix[0][i] == 0) {
                row0Zero = true;
                break;
            }
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (col0Zero) {
            for (int i = 0; i < M; i++) {
                matrix[i][0] = 0;
            }
        }
        if (row0Zero) {
            for (int i = 0; i < N; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
