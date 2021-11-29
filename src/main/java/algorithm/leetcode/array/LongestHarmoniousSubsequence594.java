package algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 594. 最长和谐子序列
 * @author: xiongyayun
 * @date: 2021/11/20 11:09 上午
 */
public class LongestHarmoniousSubsequence594 {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (int num : nums) {
            if (countMap.containsKey(num - 1)) {

                ans = Math.max(ans, countMap.get(num) + countMap.get(num - 1));
            }
        }
        return ans;
    }
}
