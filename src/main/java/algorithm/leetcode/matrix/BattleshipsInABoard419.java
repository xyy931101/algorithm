package algorithm.leetcode.matrix;

/**
 * 419. 甲板上的战舰
 * @author: xiongyayun
 * @date: 2021/12/18 15:17
 */
public class BattleshipsInABoard419 {

    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    ans++;
                    dfs(board, i, j);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] board, int i, int j) {
        if (i >= board.length || j >= board[0].length || i <0 || j <0 ||  board[i][j] == '.') {
            return;
        }
        board[i][j] = '.';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i , j + 1);
        dfs(board, i, j - 1);
    }


    public int countBattleships2(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' && isLand(board, i, j)) {
                   ans++;
                }
            }
        }
        return ans;
    }

    private boolean isLand(char[][] board, int i, int j) {

        return (i == 0 || board[i - 1][j] != 'X') && (j == 0 || board[i][j - 1] != 'X');
    }

}
