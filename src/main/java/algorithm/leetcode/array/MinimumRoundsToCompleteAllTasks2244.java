package algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 2244. 完成所有任务需要的最少轮数
 * @author: xiongyayun
 * @date: 2024/5/14 22:39
 */
public class MinimumRoundsToCompleteAllTasks2244 {

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int task : tasks){
            count.put(task, count.getOrDefault(task, 0) + 1);
        }
        int ans = 0;
        for(int c : count.values()){
            if(c == 1) return -1;
            ans += (c + 2) / 3;
        }
        return ans;
    }
}
