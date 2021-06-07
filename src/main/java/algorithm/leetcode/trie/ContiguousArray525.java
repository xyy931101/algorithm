package algorithm.leetcode.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xiongyayun
 * @date: 2021/6/3 8:33
 */
public class ContiguousArray525 {

    public int findMaxLength(int[] nums) {
        int res = 0;
        //构建1的数量跟最早出现的下标
        Map<Integer, Integer> countMap = new HashMap<>();
        //表示1的数量
        int counter = 0;
        countMap.put(counter, -1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            }else {
                counter--;
            }
            if (countMap.containsKey(counter)) {
                res = Math.max(res, i - countMap.get(counter));
            }else {
                countMap.put(counter, i);
            }
        }
        return res;
    }
}
