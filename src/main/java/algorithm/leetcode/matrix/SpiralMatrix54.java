package algorithm.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiongyayun
 * @date: 2021/6/20 11:01 下午
 */
public class SpiralMatrix54 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        //边界值判断
        if(matrix == null || matrix.length == 0)
            return res;
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;

        //统计矩阵从外向内的层数，如果矩阵非空，那么它的层数至少为1层
        int count = (Math.min(m, n)+1)/2;
        
        while (i < count) {
            for (int top = i; top < n - i; top++) {
                res.add(matrix[i][top]);
            }

            for (int right = i + 1; right < m - i; right++) {
                res.add(matrix[right][n - i - 1]);
            }

            for (int bottom = n - i - 2; bottom >= i && (m-1-i != i); bottom--) {
                res.add(matrix[m - i - 1][bottom]);
            }

            for (int left = m - i - 2; left > i && (n-1-i) != i; left--) {
                res.add(matrix[left][i]);
            }
            i++;
        }

        return res;
    }

}
