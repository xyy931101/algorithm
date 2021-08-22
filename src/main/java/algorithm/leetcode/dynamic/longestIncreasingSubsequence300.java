package algorithm.leetcode.dynamic;

/**
 * 300. 最长递增子序列
 * @author: xiongyayun
 * @date: 2021/8/20 10:57 下午
 */
public class longestIncreasingSubsequence300 {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{0}));
    }

    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        //最少都是包括自己
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);

                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
