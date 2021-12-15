package algorithm.leetcode.dag;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 851. 喧闹和富有
 * @author: xiongyayun
 * @date: 2021/12/15 9:33 下午
 */
public class LoudAndRich851 {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[] in = new int[n];
        //存储这比自己有钱的人
        int[][] w = new int[n][n];
        for (int[] r : richer) {
            int a = r[0];
            int b = r[1];
            w[a][b] = 1;
            //有多少个比自己有钱的
            in[b]++;
        }

        //没有比自己有钱的
        Deque<Integer> d = new ArrayDeque<>();

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i;
            if (in[i] == 0) d.addLast(i);
        }
        while (!d.isEmpty()) {
            int t = d.pollFirst();
            for (int i = 0; i < n; i++) {
                //如果自己比这个人有钱
                if (w[t][i] == 1) {
                    //在自己有钱的前提下,如果自己比当前人安静,则直接置换
                    if (quiet[ans[i]] > quiet[ans[t]]) {
                        ans[i] = ans[t];
                    }
                    if (--in[i] == 0) {
                        d.addLast(i);
                    }
                }
            }
        }
        return ans;
    }

}
