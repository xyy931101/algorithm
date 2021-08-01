package algorithm.leetcode.array;

import java.util.PriorityQueue;

/**
 * 1337. 矩阵中战斗力最弱的 K 行
 * @author: xiongyayun
 * @date: 2021/8/1 7:59 下午
 */
public class TheKWeakestRowsinaAMatrix1337 {

    public static void main(String[] args) {
        int[][] m = new int [][]{{1,0},{0,0},{1,0}};
        System.out.println(kWeakestRows(m, 2));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] a, int[]b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        for (int i = 0; i < mat.length; i++) {
            int left = 0, right = mat[i].length - 1;
            while (left < right) {
                int mid = left + right + 1 >> 1;
                if (mat[i][mid] >= 1) left = mid;
                else right = mid - 1;
            }
            int cur = mat[i][right] >= 1 ? right + 1 : right;
            queue.add(new int[]{cur, i});
        }
        int[] res = new int[k];
        int i = 0;
        while (k >= 1 && !queue.isEmpty()){
            int[] poll = queue.poll();
            res[i++] = poll[1];
            k--;
        }
        return res;
    }
}
