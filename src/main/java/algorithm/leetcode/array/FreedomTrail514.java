package algorithm.leetcode.array;

import jdk.nashorn.internal.ir.ReturnNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 514. 自由之路
 * @author: xiongyayun
 * @date: 2021/8/21 11:33 下午
 */
public class FreedomTrail514 {

    public int findRotateSteps(String ring, String key) {
        char[] chars = ring.toCharArray();
        int N = chars.length;
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        //构建每个字符出现的位置
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], new ArrayList<>());
            }
            map.get(chars[i]).add(i);
        }
        char[] str = key.toCharArray();
        int M = str.length;
        int[][] dp = new int[N][M + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M; j++) {
                dp[i][j] = -1;
            }
        }
        return process(0, 0, str, map, N, dp);

    }

    public static int process(int preButton, int index, char[] str, HashMap<Character, ArrayList<Integer>> map, int N,
                              int[][] dp) {

        if (dp[preButton][index] != -1) return dp[preButton][index];

        int ans = Integer.MAX_VALUE;
        if (index == str.length) {
            ans = 0;
        } else {
            char cur = str[index];
            ArrayList<Integer> nextPositions = map.get(cur);
            for (Integer next : nextPositions) {
                int cost = dial(preButton, next, N) + 1 + process(next, index + 1, str, map, N, dp);
                ans = Math.min(ans, cost);
            }
        }
        dp[preButton][index] = ans;
        return ans;
    }

    private static int dial(int preButton, Integer next, int size) {
        return Math.min(Math.abs(preButton - next), Math.min(preButton, next) + size - Math.max(preButton, next));
    }
}
