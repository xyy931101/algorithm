package algorithm.leetcode.dynamic;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 502. IPO
 * @author: xiongyayun
 * @date: 2021/9/8 8:21
 */
public class Ipo502 {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Queue<int[]> pairs =  new PriorityQueue<int[]>((x, y) -> (x[0] - y[0]));
        Queue<Integer> pro =  new PriorityQueue<Integer>((x, y) -> (y -x));

        for (int i = 0; i < n; i++) {
            pairs.add(new int[] {capital[i], profits[i]});
        }

        for(int i = 0; i < k; i++){
            while (!pairs.isEmpty() && pairs.peek()[0] <= w) {
                pro.offer(pairs.poll()[1]);
            }
            if(pro.isEmpty()) break;
            w += pro.poll();
        }
        return w;
    }

}
