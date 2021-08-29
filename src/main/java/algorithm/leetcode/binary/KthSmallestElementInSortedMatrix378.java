package algorithm.leetcode.binary;

/**
 * 378. 有序矩阵中第 K 小的元素
 * @author: xiongyayun
 * @date: 2021/8/29 10:34 下午
 */
public class KthSmallestElementInSortedMatrix378 {

    public static int kthSmallest(int[][] matrix, int k) {
        int M = matrix.length;
        int N = matrix[0].length;

        int left = matrix[0][0];
        int right = matrix[M - 1][N - 1];

        int ans = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            Info info = noMoreNum(matrix, mid);

            if (info.num < k) {
                left = mid + 1;
            } else {
                ans = info.near;
                right = mid - 1;
            }

        }
        return ans;
    }


    public static Info noMoreNum(int[][] matrix, int value) {
        int near = Integer.MIN_VALUE;
        int num = 0;
        int N = matrix.length;
        int M = matrix[0].length;
        int row = 0;
        int col = M - 1;
        while (row < N && col >= 0) {
            if (matrix[row][col] <= value) {
                near = Math.max(near, matrix[row][col]);
                num += col + 1;
                row++;
            } else {
                col--;
            }
        }
        return new Info(near, num);
    }

    public static class Info {
        public int near;
        public int num;

        public Info(int n1, int n2) {
            near = n1;
            num = n2;
        }
    }
}
