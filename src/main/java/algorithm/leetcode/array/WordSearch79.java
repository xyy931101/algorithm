package algorithm.leetcode.array;

/**
 * 79. 单词搜索
 * @Author: Xiongyy
 * @Date: 2021/5/3 18:13
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class WordSearch79 {

    private int rows;
    private int cols;

    public boolean exist(char[][] board, String word) {
        //边界值判断
        if (word == null || word.length() < 1) {
            return false;
        }
        rows = board.length;
        cols = board[0].length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <  board[0].length; j++) {
                if (existWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existWord(char[][] board, String word, int index, int row, int cell) {
        if (index == word.length() - 1) {
            return board[row][cell] == word.charAt(index);
        }
        if (word.charAt(index) != board[row][cell] || !inArea(row, cell)) {
            return false;
        }

        char temp = board[row][cell];
        //如果相等，先临时吧当前字符改成-1
        board[row][cell] = '1';
        boolean up = existWord(board, word, index + 1, row - 1, cell);
        boolean down = existWord(board, word, index + 1, row + 1, cell);
        boolean left = existWord(board, word, index + 1, row, cell - 1);
        boolean right = existWord(board, word, index + 1, row, cell + 1);
        //把字母还原
        board[row][cell] = temp;
        return up || down || left;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
