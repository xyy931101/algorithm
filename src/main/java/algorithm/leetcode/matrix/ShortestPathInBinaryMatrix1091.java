package algorithm.leetcode.matrix;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1091. 二进制矩阵中的最短路径
 *
 * @author: xiongyayun
 * @date: 2022/2/4 8:24 下午
 */
public class ShortestPathInBinaryMatrix1091 {

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix1091 s = new ShortestPathInBinaryMatrix1091();
        int i = s.shortestPathBinaryMatrix(new int[][]{
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1, 1, 0},
                {0, 1, 0, 1, 1, 1, 1, 0},
                {0, 1, 1, 0, 0, 1, 1, 0},
                {0, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0}});
        System.out.println(i);

    }

    int[][] direction = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, 0}, {1, -1}, {1, 1}};
    int row;
    int col;

    public int shortestPathBinaryMatrix(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        if (grid[0][0] != 0 || grid[row - 1][col - 1] != 0) {
            return -1;
        }
        int[][] v = new int[row][col];//识别数组
        Deque<int[]> deque = new LinkedList<int[]>();
        deque.push(new int[]{0, 0});
        v[0][0] = 1;
        int res = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] temp = deque.poll();
                int x = temp[0];
                int y = temp[1];
                if (x == row - 1 && y == col - 1) {
                    return res;
                }
                for (int[] d : direction) {
                    int x1 = x + d[0];
                    int y1 = y + d[1];
                    if (inGrid(x1, y1) && grid[x1][y1] == 0 && v[x1][y1] != 1) {
                        deque.add(new int[]{x1, y1});
                        v[x1][y1] = 1;
                    }
                }

            }
            res++;
        }
        return -1;
    }

    private boolean inGrid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
