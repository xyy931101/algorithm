package algorithm.leetcode.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * @author: xiongyayun
 * @date: 2022/1/16 17:02
 */
public class Triangle120 {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> l0 = Arrays.asList(2);
        List<Integer> l1 = Arrays.asList(3,4);
        List<Integer> l2 = Arrays.asList(6, 5, 7);
        List<Integer> l3 = Arrays.asList(4, 1, 8, 3);
        triangle.add(l0);
        triangle.add(l1);
        triangle.add(l2);
        triangle.add(l3);
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < n; i++){
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for(int j = 1; j < i; j++){
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int res = dp[n - 1][0];
        for(int i = 1; i< n; i++){
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }

}
