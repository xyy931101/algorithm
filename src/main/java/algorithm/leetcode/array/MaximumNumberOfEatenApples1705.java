package algorithm.leetcode.array;

import java.util.PriorityQueue;

/**
 * 1705. 吃苹果的最大数目
 * @author: xiongyayun
 * @date: 2021/12/24 8:24
 */
public class MaximumNumberOfEatenApples1705 {

    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[0] -b[0]);
        int n = apples.length, time = 0, ans = 0;
        while (time < n || !queue.isEmpty()) {
            if (time < n && apples[time] > 0) {
                queue.add(new int[]{days[time] + time - 1, apples[time]});
            }
            //把之前过期的苹果清除
            while (!queue.isEmpty() && queue.peek()[0] < time) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                int[] cur = queue.poll();
                //拿出最接近过期的苹果吃掉
                if (--cur[1] > 0 && cur[0] > time) {
                    queue.add(cur);
                }
                ans++;
            }
            time++;
        }
        return ans;
    }
    
}
