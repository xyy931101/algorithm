package algorithm.leetcode.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * 1218. 最长定差子序列
 * @author: xiongyayun
 * @date: 2021/11/5 10:30 下午
 */
public class LongestArithmeticSubsequenceOfGivenDifference1218 {

    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : arr) {
            countMap.put(i, countMap.getOrDefault(i - difference, 0) + 1);
            ans = Math.max(countMap.get(i), ans);
        }
        return ans;
    }
}
