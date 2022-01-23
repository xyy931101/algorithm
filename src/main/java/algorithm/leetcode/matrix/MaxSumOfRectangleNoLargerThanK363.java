package algorithm.leetcode.matrix;

import java.util.TreeSet;

/**
 * 363. 矩形区域不超过 K 的最大数值和
 * @author: xiongyayun
 * @date: 2022/1/23 17:29
 */
public class MaxSumOfRectangleNoLargerThanK363 {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int ans = Integer.MIN_VALUE;
        //遍历上边界
        for (int top = 1; top <= m; top++) {
            //遍历下边界
            for (int bot = top; bot <= m; bot++) {
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                for (int r = 1; r <= n; r++) {
                    //到有边界的值
                    int right = sum[bot][r] - sum[top - 1][r];
                    Integer left = ts.ceiling(right - k);
                    if(left != null){
                        int cur = right - left;
                        ans = Math.max(cur, ans);
                    }
                    ts.add(right);
                }
            }
        }
        return ans;
    }
}
