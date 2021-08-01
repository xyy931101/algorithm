package algorithm.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1353. 最多可以参加的会议数目
 * @author: xiongyayun
 * @date: 2021/7/31 12:27
 */
public class MaximumNumberOfEventsThatCanBeAttended1353 {

    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt((int[] a) -> a[1]));

        int endTime = 0;
        int count = 0;
        for (int i = 0; i < events.length; i++) {
            if (events[i][0] >= endTime) {
                endTime = events[i][1];
                count++;
            }
        }
        return count;
    }
}
