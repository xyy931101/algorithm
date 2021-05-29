package algorithm.leetcode.dynamic;

/**
 * 377. 组合总和 Ⅳ
 * @Author: Xiongyy
 * @Date: 2021/4/24 20:29
 * .............................................
 * 佛祖保佑             永无BUG
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。
 * 请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 */
public class CombinationSumIV377 {

    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;
        //算出1-target中所以的种数
        for (int j = 1; j <= target; j++) {
            //边里nums中所有元素,算出所有的可能
            for (int u : nums) {
                //如果当前元素大于
                if (j >= u) {
                    //
                    dp[j] = dp[j] + dp[j - u];
                }
            }
        }
        return dp[target];
    }

}
