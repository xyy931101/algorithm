package algorithm.leetcode.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 846. 一手顺子
 * @author: xiongyayun
 * @date: 2021/12/30 8:35
 */
public class HandOfStraights846 {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> handCount = new HashMap<>();
        Arrays.sort(hand);
        for (int h : hand) {
            handCount.put(h, handCount.getOrDefault(h, 0) + 1);
        }

        for (int h : hand) {
            if (!handCount.containsKey(h)) {
                continue;
            }
            for (int i = 0; i < groupSize; i++) {
                int num = h + i;
                if (!handCount.containsKey(num)) {
                    return false;
                }
                Integer count = handCount.get(num) - 1;
                if (count == 0) {
                    handCount.remove(num);
                }else {
                    handCount.put(num, count);
                }
            }
        }
        return true;
    }
    
}
