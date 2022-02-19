package algorithm.leetcode.greedy;

import java.util.Arrays;

/**
 * 1984. 学生分数的最小差值
 * @author: xiongyayun
 * @date: 2022/2/13 11:54
 */
public class MinimumDifferenceBetweenHighestAndLowestOfKScores1984 {

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length - (k - 1); i++) {
            ans = Math.min(nums[i], nums[i + k - 1]);
        }
        return ans;
    }
}
