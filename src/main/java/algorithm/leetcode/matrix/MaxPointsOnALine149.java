package algorithm.leetcode.matrix;

import sun.util.resources.cldr.ta.CurrencyNames_ta;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xiongyayun
 * @date: 2021/6/24 10:24 下午
 */
public class MaxPointsOnALine149 {

    public int maxPoints(int[][] points) {
        int n = points.length;

        int res = 0;
        for (int i = 0; i <= n - 1; i++){
            int[] x = points[i];
            for (int j = i + 1; j < n ; j++) {
                int[] y = points[j];
                int cnt = 2;
                for (int k = j + 1; k < n; k++) {
                    int[] p = points[k];

                    int s1 = (y[0] - x[0]) * (p[1] - y[1]);
                    int s2 = (y[1] - x[1]) * (p[0] - y[0]);
                    if (s1 == s2) cnt++;
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }


    public int maxPoints_best(int[][] ps) {
        int n = ps.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            // 由当前点 i 发出的直线所经过的最多点数量
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                int x1 = ps[i][0], y1 = ps[i][1], x2 = ps[j][0], y2 = ps[j][1];
                int a = x1 - x2, b = y1 - y2;
                int k = gcd(a, b);
                String key = (a / k) + "_" + (b / k);
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            ans = Math.max(ans, max + 1);
        }
        return ans;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
