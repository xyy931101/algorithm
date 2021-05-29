package algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hw
 * @date: 2021/5/28 8:18
 */
public class LongestConsecutiveSequence128 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Map<Integer, Integer> seqMap = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果当前元素在map中存在，则需要跳过
            if (!seqMap.containsKey(nums[i])) {
                //如果当前元素的前一个自然数在map中存在,则其一定是边界值
                Integer left = seqMap.getOrDefault(nums[i] - 1, 0);
                Integer right = seqMap.getOrDefault(nums[i] + 1, 0);

                int cur = left + right + 1;
                res = Math.max(res, cur);

                //更新边界值(自己就是边界的情况)
                seqMap.put(nums[i], cur);
                seqMap.put(nums[i] - left, cur);
                seqMap.put(nums[i] + right, cur);
            }
        }
        return res;
    }
    
}
