package algorithm.leetcode.matrix;

/**
 * 130. 被围绕的区域
 * @author: xiongyayun
 * @date: 2021/9/15 10:23 下午
 */
public class SurroundedRegions130 {

    public void solve(char[][] board) {
        //边界值判断
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }

        int M = board.length;
        int N = board[0].length;

        for (int i = 0; i < M; i++) {
            if (board[i][0] == 'O') {
                free(board, i, 0);
            }
            if (board[i][N-1] == 'O') {
                free(board, i, N-1);
            }
        }

        for (int i = 1; i < N - 1; i++) {
            if (board[0][i] == 'O') {
                free(board, 0, i);
            }
            if (board[M - 1][i] == 'O') {
                free(board, M - 1, i);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }else if (board[i][j] == 'F') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void free(char[][] board, int i, int j) {
        if (i < 0 || i > board.length || j < 0 || j > board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'F';
        free(board, i + 1, j);
        free(board, i - 1, j);
        free(board, i, j + 1);
        free(board, i, j - 1);
    }
}
