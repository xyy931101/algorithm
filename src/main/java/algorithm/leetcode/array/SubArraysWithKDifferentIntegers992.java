package algorithm.leetcode.array;

/**
 * @author: xiongyayun
 * @date: 2021/10/7 11:31
 */
public class SubArraysWithKDifferentIntegers992 {

    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        // k-1种数的窗口词频统计
        int[] lessCounts = new int[n + 1];
        // k种数的窗口词频统计
        int[] equalCounts = new int[n + 1];
        int lessLeft = 0;
        int equalLeft = 0;
        int lessKinds = 0;
        int equalKinds = 0;
        int ans = 0;
        for (int r = 0; r < n; r++) {
            // 当前刚来到r位置！
            if (lessCounts[nums[r]] == 0) {
                lessKinds++;
            }
            if (equalCounts[nums[r]] == 0) {
                equalKinds++;
            }
            lessCounts[nums[r]]++;
            equalCounts[nums[r]]++;
            while (lessKinds == k) {
                if (lessCounts[nums[lessLeft]] == 1) {
                    lessKinds--;
                }
                lessCounts[nums[lessLeft++]]--;
            }
            while (equalKinds > k) {
                if (equalCounts[nums[equalLeft]] == 1) {
                    equalKinds--;
                }
                equalCounts[nums[equalLeft++]]--;
            }
            ans += lessLeft - equalLeft;
        }
        return ans;
    }
}
