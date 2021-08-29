package algorithm.leetcode.array;

import java.util.*;

/**
 * 787. K 站中转内最便宜的航班
 * @author: xiongyayun
 * @date: 2021/8/24 10:28 下午
 */
public class CheapestFlightsWithinKStops787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1;
        int[][] f = new int[k + 2][n];
        for (int i = 0; i < k + 2; ++i) {
            Arrays.fill(f[i], INF);
        }

        f[0][src] = 0;

        //算出t步内到达的各个地点的值
        for (int t = 1; t <= k + 1; ++t) {
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                f[t][i] = Math.min(f[t][i], f[t - 1][j] + cost);
            }
        }

        int ans = INF;
        //求出最终终点为dst的最小花费
        for (int t = 1; t <= k + 1; ++t) {
            ans = Math.min(ans, f[t][dst]);
        }
        return ans == INF ? -1 : ans;

    }


}
