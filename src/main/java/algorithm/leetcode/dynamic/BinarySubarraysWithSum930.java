package algorithm.leetcode.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * 930. 和相同的二元子数组
 * @author: xiongyayun
 * @date: 2021/7/8 8:24
 */
public class BinarySubarraysWithSum930 {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        int ret = 0;
        for (int num : nums) {

            //放置前缀和
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            sum = sum + num;
            ret = ret + cnt.getOrDefault(sum - goal, 0);
        }
        return ret;
    }


}
