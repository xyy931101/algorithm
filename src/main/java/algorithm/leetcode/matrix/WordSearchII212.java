package algorithm.leetcode.matrix;

import java.util.*;

/**
 * 212. 单词搜索 II
 * @author: xiongyayun
 * @date: 2021/9/16 8:05
 */
public class WordSearchII212 {

    public static class Tire{
        boolean end;
        Tire[] nextList;

        public Tire(){
            end = false;
            nextList = new Tire[26];
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        //先构建前缀树
        Tire root = new Tire();
        for (String word : words) {
            Tire node = root;
            char[] chars = word.toCharArray();
            for (char ch : chars) {
                int index = ch - 'a';
                if (node.nextList[index] == null) {
                    node.nextList[index] = new Tire();
                }
                node = node.nextList[index];
            }
            node.end = true;
        }

        int M = board.length;
        int N = board[0].length;

        Set<String> ans = new HashSet<>();
        // 沿途走过的字符，收集起来，存在path里
        StringBuilder path = new StringBuilder();
        //感染board
        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                process(board, row, col, path, root, ans);
            }
        }

        return new ArrayList<>(ans);
    }

    private void process(char[][] board, int row, int col, StringBuilder path, Tire cur, Set<String> ans) {
        //如果已经越界，或者已经走过了,直接pass
        if (!validateIndex(board, row, col)) {
            return;
        }
        char ch = board[row][col];
        int index = ch - 'a';
        if (cur.nextList[ch - 'a'] == null) {
            return;
        }
        cur = cur.nextList[index];
        path.append(ch);
        if (cur.end) {
            ans.add(path.toString());
        }
        board[row][col] = 0;
        process(board, row + 1, col, path, cur, ans);
        process(board, row - 1, col, path, cur, ans);
        process(board, row, col + 1, path, cur, ans);
        process(board, row, col - 1, path, cur, ans);
        //还原回原来的字符
        board[row][col] = ch;
        path.deleteCharAt(path.length() - 1);
    }

    public static String generatePath(LinkedList<Character> path) {
        char[] str = new char[path.size()];
        int index = 0;
        for (Character cha : path) {
            str[index++] = cha;
        }
        return String.valueOf(str);
    }

    private boolean validateIndex(char[][] board, int row, int col) {
        int M = board.length;
        int N = board[0].length;
        if (row < 0 || row >= M || col < 0 || col >= N || board[row][col] == 0) {
            return false;
        }
        return true;
    }

}
