package algorithm.leetcode.array;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 * @Author: Xiongyy
 * @Date: 2021/3/23 8:56
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class SetZeroes {

    public static void main(String[] args) {
        int i = 1;
        System.out.println(i++);
        System.out.println(++i);
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "2");
        System.out.println(1 >>> 16);


    }

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cells = matrix[0].length;


        boolean[] row = new boolean[rows];
        boolean[] cell = new boolean[cells];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if(matrix[i][j] == 0){
                    row[i] = true;
                    cell[j] = true;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if (row[i] || cell[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
